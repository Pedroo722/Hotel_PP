package br.edu.ifpb.menu;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.*;

import br.edu.ifpb.enums.*;
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
            System.out.println("\n== Operações de Hóspedes ==");
            System.out.println("* 1 - Cadastrar um Hóspede");
            System.out.println("* 2 - Listar os Hóspedes atuais");
            System.out.println("* 3 - Editar um Hóspede");
            System.out.println("* 4 - Remover um Hóspede");
            System.out.println("* 5 - Voltar ao Menu");

            System.out.print("\nOpção: ");
            int optionGuest = scanner.nextInt();

            switch (GuestMenuOption.values()[optionGuest - 1]) {
                case ADD_GUEST_OPTION:
                    // TODO: Checar se é Id e número de quarto válidos
                    //        guestRepository.findGuestById(guestId);
                    //        roomRepository.findRoomByNumber(roomNumber);
                    System.out.print("\nNome do hóspede: ");
                    String name = scanner.next();
                    Name newName = new Name(name);
                
                    System.out.print("CPF do hóspede (EXEMPLO: 11122233340):\n");
                    String cpf = scanner.next();
                    CPF newCpf = new CPF(cpf);

                    guestController.addGuest(newName, newCpf);
                    break;
                case LIST_GUESTS_OPTION:
                    guestController.listGuests();
                    break;
                case EDIT_GUEST_OPTION:
                    System.out.print("ID do hóspede a ser editado: ");
                    Integer userId = scanner.nextInt();
                    Id id = new Id(userId);

                    System.out.print("Novo nome do hóspede: ");
                    String nameStr = scanner.next();
                    Name editedName = new Name(nameStr);
                
                    System.out.print("Novo CPF do hóspede: \n(EXEMPLO: 11122233340)\n");
                    String cpfStr = scanner.next();
                    CPF editedCpf = new CPF(cpfStr);
                
                    guestController.editGuest(id, editedName, editedCpf);
                    break;
                case REMOVE_GUEST_OPTION:
                    System.out.print("ID do hóspede a ser removido: ");
                    int guestId = scanner.nextInt();
                    Id removeId = new Id(guestId);
                    guestController.removeGuest(removeId);
                    break;
                case RETURN_OPTION:
                    guestProcessing = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
