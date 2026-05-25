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
    private List <Carona> caronaAndamento;
    private List <Carona> caronasFinalizadas;

    private Scanner scanner;

    public DadosSistema(){
        motoristas = new HashMap<>();
        passageiros = new HashMap<>();
        caronaAndamento = new ArrayList<>();
        caronasFinalizadas = new ArrayList<>();

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

    public void cadastraCarona(){

        System.out.print("CPF do passageiro: ");
        String cpfPassageiro = scanner.nextLine();

        System.out.println("\nOrigem da viagem");
        System.out.print("Cidade: ");
        String cidadeO = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouroO = scanner.nextLine();
        System.out.print("Numero: ");
        int numeroO = scanner.nextInt();
        System.out.print("Bairro: ");
        String bairroO = scanner.nextLine();
        Endereco origem = new Endereco(cidadeO, logadouroO, numeroO, bairroO);
        LocalDateTime inicio = LocalDateTime.now();

        System.out.println("\nDestino da viagem");
        System.out.print("Cidade: ");
        String cidadeD = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouroD = scanner.nextLine();
        System.out.print("Numero: ");
        int numeroD = scanner.nextInt();
        System.out.print("Bairro: ");
        String bairroD = scanner.nextLine();
        Endereco destino = new Endereco(cidadeD, logadouroD, numeroD, bairroD);

        String cpfMotorista;        
        for(Motorista motorista: motoristas.values()){
            if(motorista.getStatus()){
                cpfMotorista = motorista.getCpf();
                break;
            }
        }
        
        Carona carona = new Carona(passageiros.get(cpfPassageiro), motoristas.get(cpfMotorista), origem, destino, inicio);
        caronas.add(carona);

        System.out.println("Carona cadastrada com sucesso!");
    }


}
