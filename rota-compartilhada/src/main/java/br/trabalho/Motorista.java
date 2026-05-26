package br.trabalho;

import java.util.Scanner;

public class Motorista {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private Veiculo veiculo;
    private boolean status;

    private Scanner scanner;

    public Motorista(String nome, String cpf, Endereco endereco, Veiculo veiculo){

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.veiculo = veiculo;

        scanner = new Scanner(System.in);
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public boolean getStatus(){
        return status;
    }

    public void exibeDados(){
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Cpf: %s\n", cpf);
        endereco.exibeEnderecoCadastrado();
        veiculo.exibeVeiculo();
    }

    public void setEndereco(){
       
        boolean alteracaoValida = false;
        while(!alteracaoValida){
            try{
                System.out.println("\nNovo Endereco");
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

                endereco.setEndereco(tipoLogadouro, logadouro, numero, bairro, cidade, estado, cep, pais);
                System.out.println("Endereço alterado com sucesso!");
                alteracaoValida = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nErro ao alterar endereco.\n");
                System.out.println(e.getMessage());
                System.out.println("Tente novamente:\n ");
            }
        }
    }

    public void setVeiculo(){

        boolean alteracaoValida = false;
        while(!alteracaoValida){
            try{
                System.out.println("\nNovo veiculo");
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
                veiculo.setVeiculo(modelo, placa, chassi, cor, anoFabricacao);
                System.out.println("Veículo alterado com sucesso!");
                alteracaoValida = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nErro ao alterar veiculo.\n");
                System.out.println(e.getMessage());
                System.out.println("Tente novamente:\n");
            }
        }   
    }
}
