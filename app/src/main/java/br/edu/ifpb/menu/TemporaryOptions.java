package br.edu.ifpb.menu;

import br.edu.ifpb.db.DataBaseInitializer;

import java.util.Scanner;

public class TemporaryOptions {
    private Scanner scanner;

    public TemporaryOptions(Scanner scanner) {
        this.scanner = scanner;
    }

    public void handleTemporaryOptions() {
        boolean temporaryProcessing = true;

        while (temporaryProcessing) {
            System.out.println("\n=== Menu de Operações Temporárias ===");
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Criar Quartos");
            System.out.println("2 - Imprimir Conteúdos das Tabelas do Banco de Dados");
            System.out.println("3 - Voltar ao Menu Principal\n");
    
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    CreateRoom.main(new String[]{});
                    break;
                case 2:
                    DataBaseInitializer.printTableContents();
                    break;
                case 3:
                    temporaryProcessing = false;
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
