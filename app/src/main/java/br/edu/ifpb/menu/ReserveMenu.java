package br.edu.ifpb.menu;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.ReserveController;
import br.edu.ifpb.presenter.controller.RoomController;

import java.util.Scanner;

public class ReserveMenu {
    private Scanner scanner;
    private ReserveController reserveController;
    private RoomController roomController;

    public ReserveMenu(Scanner scanner, ReserveController reserveController) {
        this.scanner = scanner;
        this.reserveController = reserveController;
    }

    public void handleReserveOptions() {
        boolean reserveProcessing = true;

        while (reserveProcessing) {
            System.out.println("\n== Operações de Reserva ==");
            System.out.println("* 1 - Cadastrar uma Reserva");
            System.out.println("* 2 - Listar Quartos e Reservas");
            System.out.println("* 3 - Editar uma Reserva");
            System.out.println("* 4 - Remover uma Reserva");
            System.out.println("* 5 - Voltar ao Menu");

            System.out.print("\nOpção: ");
            int optionReserve = scanner.nextInt();

            switch (optionReserve) {
                case 1:

                    // TODO: Checar se bater com existente, se n sugerir criar novo Guest
                    System.out.print("ID do Hóspede: ");
                    int guestInt = scanner.nextInt();
                    Id guestId = new Id(guestInt);
                
                    // TODO: Checar se está AVAILABLE
                    System.out.print("Número do Quarto: ");
                    int roomNumberInt = scanner.nextInt();
                    RoomNumber roomNumber = new RoomNumber(roomNumberInt);
                
                    // TODO: Alterar os Status de Guest e Room
                    reserveController.addReserve(guestId, roomNumber);
                    break;
                case 2:
                    // TODO: Metodo para retornar os Quartos Disponiveis
                    // roomController.listAvailableRooms();
                    reserveController.listReserves();
                    break;
                case 3:
                    System.out.print("ID da reserva a ser editada: ");
                    int reserveInt = scanner.nextInt();
                    Id editId = new Id(reserveInt);

                    System.out.print("ID do novo hóospede: ");
                    int newGuestInt = scanner.nextInt();
                    Id newGuestId = new Id(newGuestInt);
                    
                    System.out.print("Número do Quarto: ");
                    int newRoomInt = scanner.nextInt();
                    RoomNumber newRoomNumber = new RoomNumber(newRoomInt);

                    System.out.print("Status da Reserva: ");
                    String newStatusStr = scanner.next();
                    ReserveStatus newStatus = ReserveStatus.valueOf(newStatusStr);

                    reserveController.editReserve(editId, newGuestId, newRoomNumber, newStatus);
                    break;
                case 4:
                    System.out.print("ID do hóspede a ser removido: ");
                    int reserveId = scanner.nextInt();
                    Id removeId = new Id(reserveId);
                    reserveController.removeReserve(removeId);
                    break;
                case 5:
                    reserveProcessing = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
