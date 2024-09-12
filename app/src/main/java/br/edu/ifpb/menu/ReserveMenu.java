package br.edu.ifpb.menu;

import br.edu.ifpb.domain.services.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.*;
import br.edu.ifpb.presenter.reserveCommand.*;
import br.edu.ifpb.presenter.CommandInvoker;
import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.interfaces.decorator.*;
import br.edu.ifpb.enums.ReserveMenuOption;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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

    private List<ServiceComponent> selectAdditionalServices() {
        List<ServiceComponent> selectedServices = new ArrayList<>();
        
        System.out.println("\n== Seleção de Serviços Adicionais ==");
        System.out.println("1 - Café da Manhã");
        System.out.println("2 - Cuidados com Animais");
        System.out.println("3 - Spa");
        System.out.println("4 - Guia de Turismo");
        System.out.println("5 - Nenhum");

        System.out.print("\nEscolha o(s) serviço(s) adicional(is) (digite os números separados por espaço): ");
        String[] input = scanner.nextLine().split(" ");

        BreakFastService breakFastService = new BreakFastService(new BasicService("", 0.0));
        PetCareService petCareService = new PetCareService(new BasicService("", 0.0));
        SpaService spaService = new SpaService(new BasicService("", 0.0));
        TourismGuideService tourismGuideService = new TourismGuideService(new BasicService("", 0.0));

        
        for (String s : input) {
            switch (s) {
                case "1":
                    selectedServices.add(breakFastService);
                    break;
                case "2":
                    selectedServices.add(petCareService);
                    break;
                case "3":
                    selectedServices.add(spaService);
                    break;
                case "4":
                    selectedServices.add(tourismGuideService);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opção inválida: " + s);
                    break;
            }
        }
        
        return selectedServices;
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
            System.out.println("* 7 - Voltar ao Menu");

            System.out.print("\nOpção: ");
            
            try {
                int optionReserve = scanner.nextInt();
                scanner.nextLine();

                if (optionReserve < 1 || optionReserve > ReserveMenuOption.values().length) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue; 
                }

                switch (ReserveMenuOption.values()[optionReserve - 1]) {
                    case ADD_RESERVE_OPTION:
                        roomController.listAvailableRooms();

                        System.out.print("ID do Hóspede: ");
                        int guestInt = scanner.nextInt();
                        Id guestId = new Id(guestInt);

                        System.out.print("Número do Quarto: ");
                        int roomNumberInt = scanner.nextInt();
                        RoomNumber roomNumber = new RoomNumber(roomNumberInt);
                        scanner.nextLine();

                        List<ServiceComponent> services = selectAdditionalServices();
                        
                        Service service = new Service();
                        
                        for (ServiceComponent svc : services) {
                            service.addService(svc);
                        }

                        Command addReserveCommand = new AddReserveCommand(reserveController, guestId, roomNumber, service.getServiceId());
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
                    case RETURN_OPTION:
                        reserveProcessing = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); 
            }
        }
    }
}
