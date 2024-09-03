package br.edu.ifpb.menu;

import br.edu.ifpb.db.DataBaseManager;
import br.edu.ifpb.enums.MainMenuOption;
import br.edu.ifpb.presenter.controller.*;

import java.util.*;

public class MainMenu {
    private Scanner scanner;
    private ReserveController reserveController;
    private GuestController guestController;
    private RoomController roomController;

    public MainMenu() {
        scanner = new Scanner(System.in);
        DataBaseManager.initialize();
        reserveController = new ReserveController();
        guestController = new GuestController();
        roomController = new RoomController();
    }

    public void start() {
        boolean processing = true;
        System.out.println("Bem-vindo ao Hotel!");
    
        while (processing) {
            System.out.println("\n=== Menu ===");
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Operações nas Reservas");
            System.out.println("2 - Operações nos Hóspedes");
            System.out.println("3 - Operações Temporárias"); //\ TEMPORARIO /\\
            System.out.println("4 - Sair e Salvar\n");
    
            System.out.print("Opção: ");
            
            try {
                int option = scanner.nextInt();
                scanner.nextLine();
    
                if (option < 1 || option > MainMenuOption.values().length) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue; 
                }
    
                switch (MainMenuOption.values()[option - 1]) {
                    case RESERVE_OPTION:
                        ReserveMenu reserveMenu = new ReserveMenu(scanner, reserveController, roomController);
                        reserveMenu.handleReserveOptions();
                        break;
                    case GUEST_OPTION:
                        GuestMenu guestMenu = new GuestMenu(scanner, guestController);
                        guestMenu.handleGuestOptions();
                        break;
                    case TEMPORARY_OPTIONS:
                        TemporaryOptions temporaryOptions = new TemporaryOptions(scanner);
                        temporaryOptions.handleTemporaryOptions();
                        break;
                    case EXIT_OPTION:
                        processing = false;
                        System.out.println("Sistema encerrado.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); 
            }
        }
    }   

    public static void main(String[] args) {
        MainMenu main = new MainMenu();
        main.start();
    }
}
