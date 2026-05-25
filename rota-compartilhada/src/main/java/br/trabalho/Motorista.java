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
        endereco.exibeEndereco();
        veiculo.exibeVeiculo();
    }

    public void setEndereco(){
       
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

        boolean alteracaoValida = false;
        while(!alteracaoValida){
            try{
                endereco.setEndereco(tipoLogadouro, logadouro, numero, bairro, cidade, estado, cep, pais);
                alteracaoValida = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("Erro ao alterar endereco.");
                System.out.println(e.getMessage());
                System.out.println("Digite novamente o tipo de Logadouro: ");
                tipoLogadouro = scanner.nextLine();
            }
        }
    }

    public void setVeiculo(){
        
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

        boolean alteracaoValida = false;
        while(!alteracaoValida){
            try{
                veiculo.setVeiculo(modelo, placa, chassi, cor, anoFabricacao);
                alteracaoValida = true;
            }
            catch(IllegalArgumentException e){
                System.out.println("Erro ao alterar veiculo.");
                System.out.println(e.getMessage());
                System.out.println("Digite novamente o ano de fabricação: ");
                anoFabricacao = scanner.nextInt();
                scanner.nextLine();
            }
        }   
    }

}
