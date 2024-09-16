package br.edu.ifpb.menu;

import br.edu.ifpb.domain.model.services.*;
import br.edu.ifpb.domain.model.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.presenter.controller.ReserveController;
import br.edu.ifpb.presenter.controller.RoomController;
import br.edu.ifpb.presenter.controller.ServiceController;
import br.edu.ifpb.presenter.reserveCommand.*;
import br.edu.ifpb.presenter.serviceCommand.*;
import br.edu.ifpb.presenter.CommandInvoker;
import br.edu.ifpb.interfaces.*;
import br.edu.ifpb.enums.ReserveMenuOption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReserveMenu {
    private Scanner scanner;
    private ReserveController reserveController;
    private RoomController roomController;
    private ServiceController serviceController;
    private CommandInvoker commandInvoker;

    public ReserveMenu(Scanner scanner, ReserveController reserveController, RoomController roomController, ServiceController serviceController) {
        this.scanner = scanner;
        this.reserveController = reserveController;
        this.roomController = roomController;
        this.serviceController = serviceController; 
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

                        Service service = createService();

                        Command addReserveCommand = new AddReserveCommand(reserveController, guestId, roomNumber, service.getServiceId());
                        commandInvoker.setCommand(addReserveCommand);
                        commandInvoker.executeCommand();

                        Command addServiceCommand = new AddServiceCommand(serviceController, service);
                        commandInvoker.setCommand(addServiceCommand);
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

                        Command removeServiceCommand = new RemoveServiceCommand(serviceController, removeId);
                        commandInvoker.setCommand(removeServiceCommand);
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

    private Service createService() {
        Service service = new Service();
        boolean addMoreServices = true;

        while (addMoreServices) {
            System.out.println("\nEscolha um serviço adicional:");
            System.out.println("1 - Café da manhã");
            System.out.println("2 - Cuidado com animais de estimação");
            System.out.println("3 - Serviço de spa");
            System.out.println("4 - Guia turístico");
            System.out.println("5 - Concluir seleção de serviços");

            int serviceOption = scanner.nextInt();
            scanner.nextLine();

            switch (serviceOption) {
                case 1:
                    service.addService(new BreakFastService(service.getServices()));
                    break;
                case 2:
                    service.addService(new PetCareService(service.getServices()));
                    break;
                case 3:
                    service.addService(new SpaService(service.getServices()));
                    break;
                case 4:
                    service.addService(new TourismGuideService(service.getServices()));
                    break;
                case 5:
                    addMoreServices = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        return service;
    }
}