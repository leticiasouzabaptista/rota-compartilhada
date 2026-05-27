package br.trabalho.util;

import br.trabalho.model.Endereco;
import java.util.Scanner;

public class Leituras {

    private Scanner scanner;

    public Leituras(){
        scanner = new Scanner(System.in);
    }

    public Endereco lerEnderecoCadastro() {
        while(true){
            
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
                return endereco;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nEndereço não aceito.");
                System.out.println(e.getMessage());
                System.out.println("\nTente novamente:\n");
            }
        }
    }

    public Endereco insereEnderecoViagem(String tipo){

        System.out.println(tipo);
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Tipo de Logadouro: ");
        String tipoLogadouro = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouro = scanner.nextLine();
        System.out.print("Numero: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        return new Endereco(cidade, tipoLogadouro, logadouro, numero, bairro);
    }
}