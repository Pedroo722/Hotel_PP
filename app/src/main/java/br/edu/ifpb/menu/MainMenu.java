package br.edu.ifpb.menu;

import br.edu.ifpb.enums.MainMenuOption;
import br.edu.ifpb.presenter.controller.*;

import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private ReserveController reserveController;
    private GuestController guestController;
    private RoomController roomController;

    public MainMenu() {
        scanner = new Scanner(System.in);
        reserveController = new ReserveController();
        guestController = new GuestController();
        roomController = new RoomController();
    }

    public void start() {
        boolean processamento = true;
        System.out.println("Bem-vindo ao Hotel!");

        while (processamento) {
            System.out.println("\n=== Menu ===");
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Operações nos Reservas");
            System.out.println("2 - Operações nas Hóspedes");
            System.out.println("3 - Operações nos Quartos");
            System.out.println("4 - Sair e Salvar\n");

            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (MainMenuOption.values()[option - 1]) {
                case RESERVE_OPTION:
                    ReserveMenu reserveMenu = new ReserveMenu(scanner, reserveController);
                    reserveMenu.handleReserveOptions();
                    break;
                case GUEST_OPTION:
                    GuestMenu guestMenu = new GuestMenu(scanner, guestController);
                    guestMenu.handleGuestOptions();
                    break;
                case ROOM_OPTION:
                    RoomMenu roomMenu = new RoomMenu(scanner, roomController);
                    roomMenu.handleRoomOptions();
                    break;
                case EXIT_OPTION:
                    processamento = false;
                    guestController.handleFinish();
                    roomController.handleFinish();
                    reserveController.handleFinish();
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        MainMenu main = new MainMenu();
        main.start();
    }
}
