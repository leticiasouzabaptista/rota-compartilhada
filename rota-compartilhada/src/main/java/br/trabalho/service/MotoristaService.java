package br.trabalho.service;

import br.trabalho.model.*;
import br.trabalho.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MotoristaService {

    private Map <String, Motorista> motoristas;
    private Leituras leitura;
    private Scanner scanner;

    public MotoristaService(){
        motoristas = new HashMap<>();
        leitura = new Leituras();
        scanner = new Scanner(System.in);
    }

    public Motorista buscMotorista(String cpf){
        return motoristas.get(cpf);
    }

    public boolean motoristaExiste(String cpf){
        return motoristas.containsKey(cpf);
    }

    public Map <String, Motorista> getMotoristas(){
        return motoristas;
    }

    public void cadastrarMotoritsa(){
        System.out.println("\n=== Cadastro de Motorista ===\n");

        System.out.print("Nome completo: (0 para voltar ao menu): ");
        String nome = scanner.nextLine();
        if(nome.equals("0"))
            return;
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Endereco endereco = leitura.lerEnderecoCadastro();

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

        if(motoristas.isEmpty()){
            System.out.println("Não existem Motoristas cadastrados.");
            return;
        }

        for(Motorista motorista: motoristas.values()){
            System.out.println(motorista.getNome());
        }
    }

    public void removeMotorista(){
        System.out.println("=== Remover Motorista ===");

        System.out.print("CPF (0 para voltar ao menu): ");
        String cpf = scanner.nextLine();
        if(cpf.equals("0"))
            return;

        motoristas.remove(cpf);
    }

    public void editaMotorista(){
        System.out.println("=== Edita dados de um Motorista ===\n");

        System.out.print("CPF (0 para voltar ao menu): ");
        String cpf = scanner.nextLine();
        if(cpf.equals("0"))
            return;

        System.out.println("O que deseja alterar:\n1) Endereço\n2) Veículo");
        int op= scanner.nextInt();
        scanner.nextLine();

        if(op == 1)
            motoristas.get(cpf).setEndereco();
        if(op == 2)
            motoristas.get(cpf).setVeiculo();
    }
}
