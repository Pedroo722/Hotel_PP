package br.edu.ifpb.menu;

import br.edu.ifpb.domain.model.RoomType;
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
                    // System.out.print("Número do Quarto: ");
                    // int roomNumberInt = scanner.nextInt();
                    // RoomNumber roomNumber = new RoomNumber(roomNumberInt);
                
                    // System.out.print("Escolha o tipo de Quarto: \n1.Quarto pequeno \n2.Quarto médio \n3.Quarto grande \n4.Quarto de Luxo");
                    // int roomTypeInt = scanner.nextInt();
                    // RoomType roomType = new RoomType(roomTypeInt);

                    // String statusStr = "AVAILABLE"; 
                    // RoomStatus status = RoomStatus.valueOf(statusStr);
                
                    // roomController.addRoom(roomNumber, roomType, status);
                    break;
                case 2:
                    roomController.listRooms();
                    break;
                case 3:
                    System.out.print("ID do Quarto a ser editada: ");
                    int roomInt = scanner.nextInt();
                    Id editId = new Id(roomInt);
                    
                    System.out.print("Novo Número do Quarto: ");
                    int newRoomInt = scanner.nextInt();
                    RoomNumber newRoomNumber = new RoomNumber(newRoomInt);

                    System.out.print("Novo Tipo de Quarto: \n1.Quarto Pequeno \n2.Quarto Médio \n3.Quarto Grande \n4.Quarto de Luxo \n\nOpção: ");
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
