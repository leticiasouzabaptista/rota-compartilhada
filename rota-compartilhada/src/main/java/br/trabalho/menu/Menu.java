package br.trabalho.menu;

import java.util.Scanner;
import br.trabalho.service.SistemaService;

public class Menu {

    private int opcao;
    private SistemaService sistema;
    private Scanner scanner;

    public Menu(SistemaService sistema){
        this.sistema = sistema;
        scanner = new Scanner(System.in);
    }

    private void exibe(){

        System.out.println("1) Cadastrar Motorista\n2) Exibir Motoristas Cadastrados\n3) Exibir Dados de um Motorista\n4) Deletar um Motorista\n5) Editar Dados de um Motorista\n6) Cadastrar um Passageiro\n7) Exibir Passageiros Cadastrados\n8) Exibir Dados de um Passageiro\n9) Deletar um Passageiro\n10) Editar Dados de um Passageiro\n11) Cadastrar uma Carona\n12) Agendar uma carona\n13) Exibir Agendamentos de Carona\n14) Atualizar Agendamento de Caronas\n15) Verificar status de uma Carona\n16) Exibir Caronas em Andamento\n17) Exibir Caronas Finalizadas\n18) Finalizar");
    }

    public void executa(){

        System.out.println("Digite a funcionalidade que deseja acessar: ");
        exibe();
        opcao = scanner.nextInt();
        scanner.nextLine();

        while(opcao != 18){

            switch (opcao) {
                case 1:{
                    sistema.getMotoristaService().cadastrarMotoritsa();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 2:{
                    sistema.getMotoristaService().exibirMotoristas();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                    
                case 3:{
                    sistema.getMotoristaService().exibirMotorista();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 4:{
                    sistema.getMotoristaService().removeMotorista();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 5:{
                    sistema.getMotoristaService().editaMotorista();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 6:{
                    sistema.getPassageiroService().cadastrarPassageiro();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 7:{
                    sistema.getPassageiroService().exibirPassageiros();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 8:{
                    sistema.getPassageiroService().exibirPassageiro();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 9:{
                    sistema.getPassageiroService().removePassageiro();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 10:{
                    sistema.getPassageiroService().editaPassageiro();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 11:{
                    sistema.getCaronaService().cadastraCarona();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 12:{
                    sistema.getCaronaService().agendaCarona();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 13:{
                    sistema.getCaronaService().exibeAgendamentosCaronas();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 14:{
                    //sistema.
                    break;
                }
                case 15:{
                    sistema.getCaronaService().exibeStatusCarona();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 16:{
                    sistema.getCaronaService().exibeCaronasAndamento();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 17:{
                    sistema.getCaronaService().exibeCaronasFinalizadas();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
               default:{
                    opcao = scanner.nextInt();
                    break;
                }
            }

            System.out.println("Digite a funcionalidade que deseja acessar: ");
            exibe();
            opcao = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.print("Programa finalizado com sucesso!");

    }

}
