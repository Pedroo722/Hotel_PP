package br.edu.ifpb.menu;

import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.RoomController;

import java.util.Scanner;

public class RoomMenu {
    private Scanner scanner;
    private RoomController roomController;

    public RoomMenu(Scanner scanner, RoomController roomController) {
        this.scanner = scanner;
        this.roomController = roomController;
    }

    public void handleRoomOptions() {
        boolean roomProcessing = true;

        while (roomProcessing) {
            System.out.println("\n== Operações de Quarto ==");
            System.out.println("* 1 - Cadastrar uma Quarto");
            System.out.println("* 2 - Listar os Quartos atuais");
            System.out.println("* 3 - Editar um Quarto");
            System.out.println("* 4 - Remover um Quarto");
            System.out.println("* 5 - Voltar ao Menu");

            System.out.print("\nOpção: ");
            int optionroom = scanner.nextInt();

            switch (optionroom) {
                case 1:
                    System.out.print("Número do Quarto: ");
                    int roomNumberInt = scanner.nextInt();
                    RoomNumber roomNumber = new RoomNumber(roomNumberInt);
                
                    System.out.print("Id do Tipo de Quarto: ");
                    int roomTypeInt = scanner.nextInt();
                    Id roomTypeId = new Id(roomTypeInt);

                    String statusStr = "AVAILABLE"; 
                    RoomStatus status = RoomStatus.valueOf(statusStr);
                
                    roomController.addRoom(roomNumber, roomTypeId, status);
                    break;
                case 2:
                    roomController.listRooms();
                    break;
                case 3:
                    System.out.print("ID do Quarto a ser editada: ");
                    int roomInt = scanner.nextInt();
                    Id editId = new Id(roomInt);

                    System.out.print("ID do novo hóospede: ");
                    int newGuestInt = scanner.nextInt();
                    Id newGuestId = new Id(newGuestInt);
                    
                    System.out.print("Número do Quarto: ");
                    int newRoomInt = scanner.nextInt();
                    RoomNumber newRoomNumber = new RoomNumber(newRoomInt);

                    System.out.print("Número do Tipo de Quarto: ");
                    int newRoomTypeInt = scanner.nextInt();
                    Id newRoomNumberId = new Id(newRoomTypeInt);

                    System.out.print("Status da Reserva: ");
                    String newStatusStr = scanner.next();
                    RoomStatus newStatus = RoomStatus.valueOf(newStatusStr);

                    roomController.editRoom(editId, newRoomNumber, newRoomNumberId, newStatus);
                    break;
                case 4:
                    System.out.print("ID do hóspede a ser removido: ");
                    int roomId = scanner.nextInt();
                    Id removeId = new Id(roomId);
                    roomController.removeRoom(removeId);
                    break;
                case 5:
                    roomProcessing = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
