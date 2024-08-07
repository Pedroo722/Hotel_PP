package br.edu.ifpb.menu;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.ReserveController;
import br.edu.ifpb.presenter.controller.RoomController;

import br.edu.ifpb.enums.ReserveMenuOption;
import java.util.Scanner;

public class ReserveMenu {
    private Scanner scanner;
    private ReserveController reserveController;
    private RoomController roomController;

    public ReserveMenu(Scanner scanner, ReserveController reserveController, RoomController roomController) {
        this.scanner = scanner;
        this.reserveController = reserveController;
        this.roomController = roomController;
    }

    public void handleReserveOptions() {
        boolean reserveProcessing = true;

        while (reserveProcessing) {
            System.out.println("\n== Operações de Reserva ==");
            System.out.println("* 1 - Cadastrar uma Reserva");
            System.out.println("* 2 - Listar Reservas");
            System.out.println("* 3 - Editar uma Reserva");
            System.out.println("* 4 - Fazer Check-out em uma Reserva");
            System.out.println("* 5 - Remover uma Reserva");
            System.out.println("* 6 - Listar todos os Quartos");
            System.out.println("* 7 - Listar Quartos Disponíveis");
            System.out.println("* 8 - Voltar ao Menu");

            System.out.print("\nOpção: ");
            int optionReserve = scanner.nextInt();


            switch (ReserveMenuOption.values()[optionReserve - 1]) {
                case ADD_RESERVE_OPTION:
                    // TODO: Checar se bater com existente, se n sugerir criar novo Guest
                    System.out.print("ID do Hóspede: ");
                    int guestInt = scanner.nextInt();
                    Id guestId = new Id(guestInt);
                
                    // TODO: Checar se está AVAILABLE
                    System.out.print("Número do Quarto: ");
                    int roomNumberInt = scanner.nextInt();
                    RoomNumber roomNumber = new RoomNumber(roomNumberInt);
                
                    reserveController.addReserve(guestId, roomNumber);
                    break;
                case LIST_RESERVES_OPTION:
                    reserveController.listReserves();
                    break;
                case EDIT_RESERVE_OPTION:
                    System.out.print("ID da reserva a ser editada: ");
                    int reserveInt = scanner.nextInt();
                    Id editId = new Id(reserveInt);

                    System.out.print("ID do novo hóspede: ");
                    int newGuestInt = scanner.nextInt();
                    Id newGuestId = new Id(newGuestInt);
                    
                    System.out.print("Novo Número do Quarto: ");
                    int newRoomInt = scanner.nextInt();
                    RoomNumber newRoomNumber = new RoomNumber(newRoomInt);

                    reserveController.editReserve(editId, newGuestId, newRoomNumber);
                    break;
                case CHECK_OUT_RESERVE_OPTION:
                    System.out.print("ID da reserva: ");
                    int reserveCheckOutInt = scanner.nextInt();
                    Id checkOutId = new Id(reserveCheckOutInt);

                    reserveController.checkOut(checkOutId);
                    break;
                case REMOVE_RESERVE_OPTION:
                    System.out.print("ID da Reserva a ser removida: ");
                    int reserveId = scanner.nextInt();
                    Id removeId = new Id(reserveId);
                    reserveController.removeReserve(removeId);
                    break;
                case LIST_ROOMS_OPTION:
                    roomController.listRooms();
                    break;
                case LIST_AVAILABLE_ROOMS_OPTION:
                    roomController.listAvailableRooms();
                    break;
                case RETURN_OPTION:
                    reserveProcessing = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
