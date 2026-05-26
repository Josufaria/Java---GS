package app;

import abstracts.Transporte;
import model.Caminhao;
import model.Drone;
import model.Entrega;
import service.GerenciadorEntregas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEntregas gerenciador = new GerenciadorEntregas();
        int opcao = 0;

        System.out.println("=================================================");
        System.out.println(" Bem-vindo à Plataforma SmartInfra - Logística ");
        System.out.println("=================================================");

        while (opcao != 5) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Registrar Entrega");
            System.out.println("3. Listar Veículos");
            System.out.println("4. Listar Entregas");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Tipo de Veículo: 1 para Caminhão, 2 para Drone");
                    String tipo = scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Capacidade de Carga (kg): ");
                    double cap = Double.parseDouble(scanner.nextLine());

                    if (tipo.equals("1")) {
                        System.out.print("Placa: ");
                        String placa = scanner.nextLine();
                        Caminhao caminhao = new Caminhao(id, cap, placa);
                        gerenciador.cadastrarTransporte(caminhao);
                    } else if (tipo.equals("2")) {
                        System.out.print("Altitude Máxima (m): ");
                        double alt = Double.parseDouble(scanner.nextLine());
                        Drone drone = new Drone(id, cap, alt);
                        gerenciador.cadastrarTransporte(drone);
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Código da Entrega: ");
                    String cod = scanner.nextLine();
                    System.out.print("Origem: ");
                    String orig = scanner.nextLine();
                    System.out.print("Destino: ");
                    String dest = scanner.nextLine();
                    System.out.print("Distância (km): ");
                    double dist = Double.parseDouble(scanner.nextLine());
                    System.out.print("É prioritária? (S/N): ");
                    boolean prio = scanner.nextLine().equalsIgnoreCase("s");

                    Transporte t = gerenciador.buscarTransporteDisponivel();
                    if (t == null) {
                        System.out.println("Não há transportes disponíveis no momento.");
                    } else {
                        // Utilizando sobrecarga
                        Entrega entrega;
                        if (prio) {
                            entrega = new Entrega(cod, orig, dest, dist, t, true);
                        } else {
                            entrega = new Entrega(cod, orig, dest, dist, t);
                        }
                        gerenciador.registrarEntrega(entrega);
                        
                        // Exemplo de uso das interfaces
                        if (t instanceof model.Caminhao) {
                            ((model.Caminhao) t).enviarNotificacao("Saindo para entrega " + cod);
                            System.out.println(((model.Caminhao) t).obterLocalizacaoAtual());
                        } else if (t instanceof model.Drone) {
                            System.out.println(((model.Drone) t).obterLocalizacaoAtual());
                        }
                    }
                    break;
                case 3:
                    gerenciador.listarTransportes();
                    break;
                case 4:
                    gerenciador.listarEntregas();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
