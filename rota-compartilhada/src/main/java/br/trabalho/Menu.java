package br.trabalho;
import java.util.Scanner;

public class Menu {

    //private char opcao;
    private int opcao;
    private DadosSistema sistema;

    public Menu(DadosSistema sistema){
        this.sistema = sistema;
    }

    public void exibe(){

        System.out.println("1) Cadastrar Motorista\n2) Exibir Motoristas Cadastrados\n3) Exibir Dados de um Motorista\n4) Deletar um Motorista\n5) Editar Dados de um Motorista\n6) Cadastrar um Passageiro\n7) Exibir Passageiros Cadastrados\n8) Exibir Dados de um Passageiro\n9) Deletar um Passageiro\n10) Editar Dados de um Passageiro\n11) Cadastrar uma Carona\n12) Agendar uma carona\n13) Exibir Agendamentos de Carona\n14) Atualizar Agendamento de Caronas\n15) Verificar status de uma Carona\n16) Exibir Caronas em Andamento\n17) Exibir Caronas Finalizadas\n18) Finalizar");
    }

    public void executa(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a funcionalidade que deseja acessar: ");
        exibe();
        opcao = scanner.nextInt();
        //opcao = scanner.next().charAt(0);

        while(opcao != 18){

            switch (opcao) {
                case 1:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.cadastrarMotorista();
                    exibe();
                    opcao = scanner.nextInt();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 2:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.exibirMotoristas();
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                    
                case 3:{
                    System.out.println("Para voltar ao menu digite 0.");
                    System.out.println("Digite o cpf do motorista: "); //ou então deixar isso dentro de exibirMotorista()
                    String cpf = scanner.next();
                    sistema.exibirMotorista(cpf);
                    System.out.println("\nPressione ENTER para continuar.");
                    scanner.nextLine();
                    break;
                }
                case 4:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.removeMotorista(); //
                    break;
                }
                case 5:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.editaMotorista(); //
                    break;
                }
                case 6:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.cadastrarPassageiro();
                    break;
                }
                case 7:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.exibirPassageiros();
                    break;
                }
                case 8:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.exibirPassageiro();
                    break;
                }
                case 9:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.removePassageiro();
                    break;
                }
                case 10:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.editaPassageiro();
                    break;
                }
                case 11:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.cadastraCarona();
                    break;
                }
                case 12:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.agendaCarona();
                    break;
                }
                case 13:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.exibeAgendamentosCaronas();
                    break;
                }
                case 14:{
                    System.out.println("Para voltar ao menu digite 0.");
                    //sistema.
                    break;
                }
                case 15:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.exibeStatusCarona();
                    break;
                }
                case 16:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.exibirListaAndamento();
                    break;
                }
                case 17:{
                    System.out.println("Para voltar ao menu digite 0.");
                    sistema.exibirListaFinalizadas();
                    break;
                }
                default:{
                    System.out.println("Opção inválida, digite novamente: ");
                    opcao = scanner.nextInt();
                    break;
                }
            }

            System.out.println("Digite a funcionalidade que deseja acessar: ");
            exibe();
            opcao = scanner.nextInt();
            //opcao = scanner.next().charAt(0);
        }

        System.out.print("Programa finalizado com sucesso!");

    }

}
