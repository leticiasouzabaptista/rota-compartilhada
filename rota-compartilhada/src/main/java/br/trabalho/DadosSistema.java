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
    private Map <String, Passageiro> passageiros;
    private Map <Integer, Carona> caronaAndamento;
    private Map <Integer, Carona> caronasAgendadas;
    private Map <Integer, Carona> caronasFinalizadas;

    private Scanner scanner;

    public DadosSistema(){
        motoristas = new HashMap<>();
        passageiros = new HashMap<>();
        caronaAndamento = new HashMap<>();
        caronasFinalizadas = new HashMap<>();

        scanner = new Scanner(System.in);
    }


    private Endereco lerEnderecoCadastro() {

        boolean enderecoEhvalido = false;
        while(!enderecoEhvalido){

            try {
                System.out.println("\nEndereco");
                System.out.print("Tipo do Logradouro: ");
                String tipoLogradouro = scanner.nextLine();
                System.out.print("Logradouro: ");
                String logradouro = scanner.nextLine();
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

                Endereco endereco = new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, estado, cep, pais);
                enderecoEhvalido = true;
                return endereco;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nEndereço não aceito.");
                System.out.println(e.getMessage());
                System.out.println("\nTente novamente:\n");
            }
        }
    }

    public void cadastrarMotoritsa(){
        
        System.out.println("\n=== Cadastro de Motorista ===\n");

        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Endereco endereco = lerEnderecoCadastro();

        boolean veiculoEhValido = false;
        Veiculo veiculo = null;
        while(!veiculoEhValido){

            try{
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
                veiculo = new Veiculo(modelo, placa, chassi, cor,  anoFabricacao);
                veiculoEhValido = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nVeículo não aceito.");
                System.out.println(e.getMessage());
                System.out.println("\nTente novamente:\n");
            }
        }
        
        Motorista motorista = new Motorista(nome, cpf, endereco, veiculo);
        motoristas.put(cpf,motorista);

        System.out.println("\nMotorista cadastrado com sucesso!");
    }

    public void exibirMotorista(){
        System.out.println("=== Exibe Dados de um Motorista ===");
        System.out.print("\nCPF do motorista: ");       
        String cpf = scanner.nextLine();
        System.out.print("\n");
        
        if(motoristas.containsKey(cpf))
            motoristas.get(cpf).exibeDados();
        else
            System.out.println("Motorista não cadastrado.");
    }

    public void exibirMotoristas(){
        System.out.println("\n=== Motoristas Cadastrados ===");
        for(Motorista motorista: motoristas.values()){
            System.out.println(motorista.getNome());
        }
    }

    public void removeMotorista(){
        System.out.println("=== Remover Motorista ===");
        System.out.println("CPF do motorista: ");
        String cpf = scanner.nextLine();
        motoristas.remove(cpf);
    }

    public void editaMotorista(){
        System.out.println("=== Edita dados de um Motorista ===\n");
        System.out.print("CPF do motorista: ");
        String cpf = scanner.nextLine();

        System.out.println("O que deseja alterar:\n1) Endereço\n2) Veículo");
        int op= scanner.nextInt();
        scanner.nextLine();

        if(op == 1)
            motoristas.get(cpf).setEndereco();
        if(op == 2)
            motoristas.get(cpf).setVeiculo();
    }

    public void cadastrarPassageiro(){
        System.out.println("=== Cadastrar Passageiro ===\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Endereco endereco = lerEnderecoCadastro();

        Passageiro passageiro = new Passageiro(nome, cpf, endereco);
        passageiros.put(cpf,passageiro);

        System.out.println("\nPassageiro cadastrado com sucesso!");
    }

    public void exibirPassageiros(){
        System.out.print("=== Passageiros Cadastrados ===\n");
        for(Passageiro passageiro: passageiros.values()){
            System.out.println(passageiro.getNome() + "\n");
        }
    }

    public void exibirPassageiro(){
        System.out.print("=== Exibe Dados de um Passageiro ===");
        System.out.print("\nCPF do passageiro: ");       
        String cpf = scanner.nextLine();
        System.out.print("\n");
        
        if(passageiros.containsKey(cpf))
            passageiros.get(cpf).exibeDados();
        else
            System.out.println("Passageiro não cadastrado.");
    }

    public void removePassageiro(){
        System.out.println("=== Remover Passageiro ===\n");
        System.out.println("CPF do Passageiro: ");
        String cpf = scanner.nextLine();
        passageiros.remove(cpf);
    }

    public void editaPassageiro(){
        System.out.println("=== Edita dados de um Passageiro ===\n");
        System.out.print("CPF do Passageiro: ");
        String cpf = scanner.nextLine();

        passageiros.get(cpf).setEndereco();
    }

    private Endereco insereEnderecoViagem(String tipo){

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

    private boolean passageiroDisponivel(String cpfPassageiro, LocalDateTime inicio, LocalDateTime fim){

        for(Carona carona : caronaAndamento.values()){
            if(carona.getCpfPassageiro().equals(cpfPassageiro)){
                System.out.println(carona.getNomePassageiro() + " já esta em carona.");
                return false;
            }
        }

        for(Carona carona : caronasAgendadas){
            if(carona.getCpfPassageiro().equals(cpfPassageiro)){
                if(temConflito(inicio, fim, carona.getInicio(), carona.getFim()))
                    return false;
            }
        }
        return true;
    }

    private boolean temConflito(LocalDateTime inicio1, LocalDateTime fim1, LocalDateTime inicio2,  LocalDateTime fim2){
        return inicio1.isBefore(fim2) && fim1.isAfter(inicio2);
    }

    public void cadastraCarona(){

        System.out.print("=== Cadastrar Carona ===\n");
        System.out.print("CPF do passageiro: ");
        String cpfPassageiro = scanner.nextLine();
        if(!passageiros.containsKey(cpfPassageiro)){
            System.out.println("Passageiro não cadastrado.");
            return;
        }

        Endereco origem = insereEnderecoViagem("\nOrigem da Viagem");
        Endereco destino = insereEnderecoViagem("\nDestino da Viagem");

        LocalDateTime inicio = LocalDateTime.now();
        Random random = new Random();
        int duracao = random.nextInt(2)+1;
        LocalDateTime fim = inicio.plusHours(duracao);

        if(!passageiroDisponivel(cpfPassageiro, inicio, fim)){
            System.out.println("Passageiro possui conflito de horário.");
            return;
        }
    }
        
        String cpfMotorista = null;        
        for(Motorista motorista: motoristas.values()){
            if(motorista.getStatus()){
                cpfMotorista = motorista.getCpf();
                break;
            }
        }
        if(cpfMotorista == null){
            System.out.println("Nenhum motorista disponível.");
            return;
        }
        
        Carona carona = new Carona(passageiros.get(cpfPassageiro), motoristas.get(cpfMotorista), origem, destino, inicio, "Em andamento");
        caronas.add(carona);

        System.out.println("Carona cadastrada com sucesso!");
    }

    public void agendaCarona(){

        System.out.print("=== Agendar Carona ===\n");
        System.out.print("CPF do passageiro: ");
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
        LocalDateTime agora = LocalDateTime.now();
        if(inicio.isBefore(agora) || inicio.isEqual(agora)){
            System.out.println("Carona agendada para o momento atual.");
            return;
        }

        Endereco destino = insereEnderecoViagem("\nDestino da Viagem");
        
        String cpfMotorista;        
        for(Motorista motorista: motoristas.values()){
            if(motorista.getStatus()){
                cpfMotorista = motorista.getCpf();
                break;
            }
        }
        
        Carona carona = new Carona(passageiros.get(cpfPassageiro), motoristas.get(cpfMotorista), origem, destino, inicio, fim, "Aguardando Inicio");
        caronasAgendadas.put(carona.getCodigo(),carona);

        System.out.println("Carona cadastrada com sucesso!");
    }

    public void exibeAgendamentosCaronas(){
        System.out.println("=== Caronas Agendadas ===\n");
        for(Carona carona: caronasAgendadas){
            System.out.printf("Carona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeStatusCarona(){
        System.out.println("=== Verificar status de uma Carona ===\n");
        System.out.println("Codigo da carona: ");
        float codigo = scanner.nextFloat();
        if(caronasAgendadas.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
        if(caronaAndamento.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
        if(caronasFinalizadas.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
    }

    public void exibeCaronasAndamento(){

        System.out.println("=== Caronas em Andamento ===\n");
        for(Carona carona: caronaAndamento.values()){
            System.out.printf("Carona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeCaronasFinalizadas(){
        System.out.print("=== Caronas Finalizadas ===\n");
        for(Carona carona: caronasFinalizadas.values()){
            System.out.printf("Carona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Fim: " + carona.exibeFim() + "\n");
        }
    }
}

