package br.edu.ifpb.menu;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.ReserveController;
import br.edu.ifpb.presenter.controller.RoomController;
import br.edu.ifpb.presenter.reserveCommand.*;

import br.edu.ifpb.presenter.CommandInvoker;
import br.edu.ifpb.interfaces.*;

import br.edu.ifpb.enums.ReserveMenuOption;
import java.util.Scanner;

public class ReserveMenu {
    private Scanner scanner;
    private ReserveController reserveController;
    private RoomController roomController;
    private CommandInvoker commandInvoker;

    public ReserveMenu(Scanner scanner, ReserveController reserveController, RoomController roomController) {
        this.scanner = scanner;
        this.reserveController = reserveController;
        this.roomController = roomController;
        this.commandInvoker = new CommandInvoker();
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
            scanner.nextLine(); // Consumir nova linha

            switch (ReserveMenuOption.values()[optionReserve - 1]) {
                case ADD_RESERVE_OPTION:
                    System.out.print("ID do Hóspede: ");
                    int guestInt = scanner.nextInt();
                    Id guestId = new Id(guestInt);

                    System.out.print("Número do Quarto: ");
                    int roomNumberInt = scanner.nextInt();
                    RoomNumber roomNumber = new RoomNumber(roomNumberInt);

                    Command addReserveCommand = new AddReserveCommand(reserveController, guestId, roomNumber);
                    commandInvoker.setCommand(addReserveCommand);
                    commandInvoker.executeCommand();
                    break;
                case LIST_RESERVES_OPTION:
                    Command listReservesCommand = new ListReservesCommand(reserveController);
                    commandInvoker.setCommand(listReservesCommand);
                    commandInvoker.executeCommand();
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

                    Command editReserveCommand = new EditReserveCommand(reserveController, editId, newGuestId, newRoomNumber);
                    commandInvoker.setCommand(editReserveCommand);
                    commandInvoker.executeCommand();
                    break;
                case CHECK_OUT_RESERVE_OPTION:
                    System.out.print("ID da reserva: ");
                    int reserveCheckOutInt = scanner.nextInt();
                    Id checkOutId = new Id(reserveCheckOutInt);

                    Command checkOutReserveCommand = new CheckOutReserveCommand(reserveController, checkOutId);
                    commandInvoker.setCommand(checkOutReserveCommand);
                    commandInvoker.executeCommand();
                    break;
                case REMOVE_RESERVE_OPTION:
                    System.out.print("ID da Reserva a ser removida: ");
                    int reserveId = scanner.nextInt();
                    Id removeId = new Id(reserveId);

                    Command removeReserveCommand = new RemoveReserveCommand(reserveController, removeId);
                    commandInvoker.setCommand(removeReserveCommand);
                    commandInvoker.executeCommand();
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
