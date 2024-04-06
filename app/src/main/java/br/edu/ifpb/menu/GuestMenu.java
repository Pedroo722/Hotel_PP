package br.edu.ifpb.menu;

import br.edu.ifpb.domain.wrappers.CPF;
import br.edu.ifpb.domain.wrappers.GuestStatus;
import br.edu.ifpb.domain.wrappers.Id;
import br.edu.ifpb.domain.wrappers.Name;
import br.edu.ifpb.presenter.controller.GuestController;

import java.util.Scanner;

public class GuestMenu {
    private Scanner scanner;
    private GuestController guestController;

    public GuestMenu(Scanner scanner, GuestController guestController) {
        this.scanner = scanner;
        this.guestController = guestController;
    }

    public void handleGuestOptions() {
        boolean guestProcessing = true;

        while (guestProcessing) {
            System.out.println("== Operações de Hóspedes ==");
            System.out.println("* 1 - Cadastrar um Hóspede");
            System.out.println("* 2 - Listar os Hóspedes atuais");
            System.out.println("* 3 - Editar um Hóspede");
            System.out.println("* 4 - Remover um Hóspede");
            System.out.println("* 5 - Voltar ao Menu");

            System.out.print("\nOpção: ");
            int optionGuest = scanner.nextInt();

            switch (optionGuest) {
                case 1:
                    System.out.print("Nome do hóspede: ");
                    String name = scanner.nextLine();
                    Name newName = new Name(name);
                
                    System.out.print("CPF do hóspede: ");
                    String cpf = scanner.nextLine();
                    CPF newCpf = new CPF(cpf);
                
                    System.out.print("Status do hóspede (ATIVO ou INATIVO): ");
                    String statusStr = scanner.next();
                    GuestStatus status = GuestStatus.valueOf(statusStr);

                    guestController.addGuest(newName, newCpf, status);
                    break;
                case 2:
                    guestController.listGuests();
                    break;
                case 3:
                    System.out.print("ID do hóspede a ser editado: ");
                    Integer userId = scanner.nextInt();
                    Id id = new Id(userId);

                    System.out.print("Novo nome do hóspede: ");
                    String nameStr = scanner.nextLine();
                    Name editedName = new Name(nameStr);
                
                    System.out.print("Novo CPF do hóspede: ");
                    String cpfStr = scanner.nextLine();
                    CPF editedCpf = new CPF(cpfStr);
                
                    System.out.print("Novo status do hóspede (ATIVO ou INATIVO): ");
                    String newStatusStr = scanner.next();
                    GuestStatus editedStatus = GuestStatus.valueOf(newStatusStr);

                    System.out.print("ID do hóspede a ser editado: ");
                    int reserveInt = scanner.nextInt();
                    Id reserveId = new Id(reserveInt);
                
                    guestController.editGuest(id, editedName, editedCpf, editedStatus, reserveId);
                    break;
                case 4:
                    System.out.print("ID do hóspede a ser removido: ");
                    int guestId = scanner.nextInt();
                    Id removeId = new Id(guestId);
                    guestController.removeGuest(removeId);
                    break;
                case 5:
                    guestProcessing = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
