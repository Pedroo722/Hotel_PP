package br.edu.ifpb.menu;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.enums.*;
import br.edu.ifpb.presenter.CommandInvoker;
import br.edu.ifpb.presenter.controller.GuestController;
import br.edu.ifpb.presenter.guestCommand.*;

import br.edu.ifpb.interfaces.Command;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuestMenu {
    private Scanner scanner;
    private GuestController guestController;
    private CommandInvoker commandInvoker;

    public GuestMenu(Scanner scanner, GuestController guestController) {
        this.scanner = scanner;
        this.guestController = guestController;
        this.commandInvoker = new CommandInvoker();
    }

    public void handleGuestOptions() {
        boolean guestProcessing = true;

        while (guestProcessing) {
            System.out.println("\n== Operações de Hóspedes ==");
            System.out.println("* 1 - Cadastrar um Hóspede");
            System.out.println("* 2 - Listar os Hóspedes atuais");
            System.out.println("* 3 - Editar um Hóspede");
            System.out.println("* 4 - Remover um Hóspede");
            System.out.println("* 5 - Voltar ao Menu");

            System.out.print("\nOpção: ");

            try {
                int optionGuest = scanner.nextInt();
                scanner.nextLine(); 

                if (optionGuest < 1 || optionGuest > GuestMenuOption.values().length) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue; 
                }

                Command command = null;

                switch (GuestMenuOption.values()[optionGuest - 1]) {
                    case ADD_GUEST_OPTION:
                        System.out.print("\nNome do hóspede: ");
                        String name = scanner.nextLine();
                        Name newName = new Name(name);

                        System.out.print("CPF do hóspede (EXEMPLO: 11122233340):\n");
                        String cpf = scanner.next();
                        CPF newCpf = new CPF(cpf);

                        command = new AddGuestCommand(guestController, newName, newCpf);
                        break;
                    case LIST_GUESTS_OPTION:
                        command = new ListGuestsCommand(guestController);
                        break;
                    case EDIT_GUEST_OPTION:
                        System.out.print("ID do hóspede a ser editado: ");
                        Integer userId = scanner.nextInt();
                        scanner.nextLine();
                        Id id = new Id(userId);

                        System.out.print("Novo nome do hóspede: ");
                        String nameStr = scanner.nextLine();
                        Name editedName = new Name(nameStr);

                        System.out.print("Novo CPF do hóspede: \n(EXEMPLO: 11122233340)\n");
                        String cpfStr = scanner.next();
                        CPF editedCpf = new CPF(cpfStr);

                        command = new EditGuestCommand(guestController, id, editedName, editedCpf);
                        break;
                    case REMOVE_GUEST_OPTION:
                        System.out.print("ID do hóspede a ser removido: ");
                        int guestId = scanner.nextInt();
                        Id removeId = new Id(guestId);
                        command = new RemoveGuestCommand(guestController, removeId);
                        break;
                    case RETURN_OPTION:
                        guestProcessing = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

                if (command != null) {
                    commandInvoker.setCommand(command);
                    commandInvoker.executeCommand();
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); 
            }
        }
    }
}
