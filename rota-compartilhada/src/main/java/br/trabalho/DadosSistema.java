package br.trabalho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;

public class DadosSistema {
    private Map <String, Motorista> motoristas;
    /* private List <Motorista> motoristas; */
    private Map <String, Passageiro> passageiros;
    private Map <Float, Carona> caronaAndamento;
    private Map <Float, Carona> caronasAgendadas;
    private Map <Float, Carona> caronasFinalizadas;

    private Scanner scanner;

    public DadosSistema(){
        motoristas = new HashMap<>();
        passageiros = new HashMap<>();
        caronaAndamento = new HashMap<>();
        caronasFinalizadas = new HashMap<>();

        scanner = new Scanner(System.in);
    }

   /*  private Endereco insereEnderecoCdastro(){

        System.out.println("\nEndereco");
        System.out.print("Tipo do Logadouro: ");
        String tipoLogadouro = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouro = scanner.nextLine();
        System.out.print("Nº: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Pais: ");
        String pais = scanner.nextLine();


    } */

    public void cadastrarMotoritsa(){
        
        System.out.println("\n=== Cadastro de Motorista ===\n");

        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("\nEndereco");
        System.out.print("Tipo do Logadouro: ");
        String tipoLogadouro = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouro = scanner.nextLine();
        System.out.print("Nº: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Pais: ");
        String pais = scanner.nextLine();

        boolean criadoEnd = false;
        Endereco endereco = null;
        while(!criadoEnd){

            try{
                endereco = new Endereco(tipoLogadouro, logadouro, numero, bairro, cidade, estado, cep, pais);
                criadoEnd = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nEndereço não aceito.");
                System.out.println(e.getMessage());

                System.out.println("Digite novamente o tipo de Logadouro: ");
                tipoLogadouro = scanner.nextLine();
                //System.out.println("Digite novamente o endereço");
                //insereDadosEndereco();
            }
        }

        System.out.println("\nVeiculo");
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Chassi: ");
        String chassi = scanner.nextLine();
        System.out.print("Ano de Fabricação: ");
        int anoFabricacao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        boolean criadoVei = false;
        Veiculo veiculo = null;
        while(!criadoVei){

            try{
                veiculo = new Veiculo(modelo, placa, chassi, cor,  anoFabricacao);
                criadoVei = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nVeículo não aceito.");
                System.out.println(e.getMessage());

                System.out.println("Digite novamente o ano de Fabricação: ");
                anoFabricacao = scanner.nextInt();
            }
        }
        
        Motorista motorista = new Motorista(nome, cpf, endereco, veiculo);
        motoristas.put(cpf,motorista);
        /* motoristas.put(cpf,motorista); */

        System.out.println("\nMotorista cadastrado com sucesso!");
    }

    public void exibirMotorista(){
        
        System.out.print("\nCPF do motorista: ");       
        String cpf = scanner.nextLine();
        System.out.print("\n");
        
        if(motoristas.containsKey(cpf))
            motoristas.get(cpf).exibeDados();
        else
            System.out.println("Motorista não cadastrado.");
        
        /* boolean cadastrado = false;
        for(Motorista motorista: motoristas){
            if(motorista.getCpf().equals(cpf)){
                motorista.exibeDados();
                cadastrado = true;
                break;
            }
        }
        if(!cadastrado)
            System.out.println("Motorista não cadastrado."); */
    }

    public void exibirMotoristas(){
        System.out.println("\nMotoristas Cadastrados: ");
        for(Motorista motorista: motoristas.values()){
            System.out.println(motorista.getNome());
            System.out.println("\n");
        }
    }

    public void removeMotorista(){
        System.out.println("CPF do motorista: ");
        String cpf = scanner.nextLine();
        //motoristas.removeIf(motorista->motorista.getCpf().equals(cpf));
        motoristas.remove(cpf);
    }

    public void editaMotorista(){
        System.out.println("CPF do motorista: ");
        String cpf = scanner.nextLine();

        System.out.println("O que deseja alterar:\n1) Endereço\n2)Veículo");
        int op= scanner.nextInt();
        scanner.nextLine();

        if(op == 1){
            motoristas.get(cpf).setEndereco();
            /* for(Motorista motorista: motoristas){
                if(motorista.getCpf().equals(cpf)){
                    motorista.setEndereco();
                }
            } */
        }

        if(op == 2){
            motoristas.get(cpf).setVeiculo();
            /* for(Motorista motorista: motoristas){
                if(motorista.getCpf().equals(cpf)){
                    motorista.setVeiculo();
                }
            } */
        }
    }

    public void cadastrarPassageiro(){

        System.out.println("=== Cadastrar Passageiro ===\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        //insereDadosEndereco();
        System.out.println("\nEndereco");
        System.out.print("Tipo do Logadouro: ");
        String tipoLogadouro = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouro = scanner.nextLine();
        System.out.print("Nº: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Pais: ");
        String pais = scanner.nextLine();

        boolean criadoEnd = false;
        Endereco endereco = null;
        while(!criadoEnd){

            try{
                endereco = new Endereco(tipoLogadouro, logadouro, numero, bairro, cidade, estado, cep, pais);
                criadoEnd = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nEndereço não aceito.");
                System.out.println(e.getMessage());

                System.out.println("Digite novamente o tipo de Logadouro: ");
                tipoLogadouro = scanner.nextLine();
                //System.out.println("Digite novamente o endereço");
                //insereDadosEndereco();
            }
        }

        Passageiro passageiro = new Passageiro(nome, cpf, endereco);
        passageiros.put(cpf,passageiro);
        System.out.println("\nPassageiro cadastrado com sucesso!");
    }

    public void exibirPassageiros(){

        System.out.println("Passageiros Cadastrados");
        for(Passageiro passageiro: passageiros.values()){
            System.out.println(passageiro.getNome() + "\n");
        }
    }

    public void exibirPassageiro(){

        System.out.print("\nCPF do Passageiro: ");       
        String cpf = scanner.nextLine();
        System.out.print("\n");
        
        if(passageiros.containsKey(cpf))
            passageiros.get(cpf).exibeDados();
        else
            System.out.println("Passageiro não cadastrado."); */

        /*  boolean cadastrado = false;
        for(Passageiro passageiro: passageiros){
            if(passageiro.getCpf().equals(cpf)){
                passageiro.exibeDados();
                cadastrado = true;
                break;
            }
        }
        if(!cadastrado)
            System.out.println("Passageiro não cadastrado."); */
    }

    public void removePassageiro(){
        System.out.println("CPF do Passageiro: ");
        String cpf = scanner.nextLine();
        passageiros.remove(cpf);
        //passageiros.removeIf(passageiros->passageiros.getCpf().equals(cpf));
    }

    public void editaPassageiro(){

        System.out.println("CPF do Passageiro: ");
        String cpf = scanner.nextLine();

        passageiros.get(cpf).setEndereco();
        /* for(Passageiro passageiro: passageiros){
                if(passageiro.getCpf().equals(cpf)){
                    passageiro.setEndereco();
                }
        } */
    }

    public Endereco insereEnderecoViagem(String tipo){

        System.out.println(tipo);
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouro = scanner.nextLine();
        System.out.print("Numero: ");
        int numero = scanner.nextInt();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        return new Endereco(cidade, logadouro, numero, bairro);
    }

    public void cadastraCarona(){

        System.out.print("=== Cadastrar Carona ===");
        System.out.print("\nCPF do passageiro: ");
        String cpfPassageiro = scanner.nextLine();

        /* for(Carona carona: caronasAgendadas.values()){
            if(carona.getCpfPassageiro().equals(cpfPassageiro))
                if()
        }
 */
        for(Carona carona: caronaAndamento.values()){
            if(carona.getCpfPassageiro().equals(cpfPassageiro)){
                System.out.println("Erro: passageiro já esta em carona.");
                break;
            }
        }

        Endereco origem = insereEnderecoViagem("\nOrigem da Viagem");
        LocalDateTime inicio = LocalDateTime.now();
        Endereco destino = insereEnderecoViagem("\nDestino da Viagem");
        
        String cpfMotorista;        
        for(Motorista motorista: motoristas.values()){
            if(motorista.getStatus()){
                cpfMotorista = motorista.getCpf();
                break;
            }
        }
        
        Carona carona = new Carona(passageiros.get(cpfPassageiro), motoristas.get(cpfMotorista), origem, destino, inicio, "Em andamento");
        caronas.add(carona);

        System.out.println("Carona cadastrada com sucesso!");
    }

    public void agendaCarona(){

        System.out.print("=== Agendar Carona ===");
        System.out.print("\nCPF do passageiro: ");
        String cpfPassageiro = scanner.nextLine();

        Endereco origem = insereEnderecoViagem("\nOrigem da Viagem");
        System.out.print("Dia: ");
        int dia = scanner.nextInt();
        System.out.print("Mes");
        int mes = scanner.nextInt();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("\nHora: ");
        int hora = scanner.nextInt();
        System.out.print("Minuto: ");
        int minuto = scanner.nextInt();
        LocalDateTime inicio = LocalDateTime.of(ano, mes, dia, hora, minuto);
        Endereco destino = insereEnderecoViagem("\nDestino da Viagem");
        
        String cpfMotorista;        
        for(Motorista motorista: motoristas.values()){
            if(motorista.getStatus()){
                cpfMotorista = motorista.getCpf();
                break;
            }
        }
        
        Carona carona = new Carona(passageiros.get(cpfPassageiro), motoristas.get(cpfMotorista), origem, destino, inicio, "Aguardando Inicio");
        caronasAgendadas.add(carona);

        System.out.println("Carona cadastrada com sucesso!");
    }

    public void exibeAgendamentosCaronas(){

        for(Carona carona: caronasAgendadas){
            System.out.printf("Carona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeStatusCarona(){
        System.out.println("\nCodigo da carona: ");
        float codigo = scanner.nextFloat();
        if(caronasAgendadas.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
        if(caronaAndamento.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
        if(caronasFinalizadas.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
    }

    public void exibeCaronasAndamento(){

        System.out.println("=== Caronas em Andamento ===");
        for(Carona carona: caronaAndamento.values()){
            System.out.printf("\nCarona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeCaronasFinalizadas(){
        System.out.print("=== Caronas Finalizadas ===");
        for(Carona carona: caronasFinalizadas.values()){
            System.out.printf("\nCarona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Fim: " + carona.exibeFim() + "\n");
        }
    }
}

