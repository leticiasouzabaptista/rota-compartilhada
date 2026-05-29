package br.trabalho.model;

import java.util.Scanner;

public class Passageiro {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private boolean status;

    private Scanner scanner;

    public Passageiro(String nome, String cpf, Endereco endereco){

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        status = false;

        //em carona
        //não esta em carona

        scanner = new Scanner(System.in);
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void exibeStatus(){
        if(status)
            System.out.println("Passageiro esta em carona.");
        else
            System.out.println("Passageiro não esta em carona");
    }

    public void ocupaPassageiro(){
        status = false;
    }

    public void liberaPassageiro(){
        status = true;
    }

    public void exibeDados(){
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Cpf: %s\n", cpf);

        String disponivel;
        if(status)
            disponivel = "Não esta em carona.";
        else
            disponivel = "Esta em carona";

        System.out.println("Status do passageiro: " + disponivel);
        endereco.exibeEnderecoCadastrado();
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
}