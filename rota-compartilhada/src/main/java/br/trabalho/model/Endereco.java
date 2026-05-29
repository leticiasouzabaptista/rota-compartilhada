package br.trabalho.model;

public class Endereco {

    private String tipoLogadouro;
    private String logadouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    public Endereco(String tipoLogadouro, String logadouro, int numero, String bairro, String cidade, String estado, String cep, String pais){

        if(!tipoLogadouroEhValido(tipoLogadouro))
            throw new IllegalArgumentException("Tipo de Logadouro Inválido.");

        this.tipoLogadouro = tipoLogadouro;
        this.logadouro = logadouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
    }

    public Endereco(String cidade, String tipoLogadouro, String logadouro, int numero, String bairro){
        this(tipoLogadouro, logadouro, numero, bairro, cidade, null, null, null);
    }

    public void exibeEnderecoCadastrado(){
        System.out.printf("Endereco: %s %s, %d - %s, %s, %s, %s, %s\n", tipoLogadouro, logadouro, numero, bairro, cidade, estado, cep, pais);
    }

    public void exibeEnderecoViagem(String tipo){
        System.out.printf("%s: %s %s, %d - %s\n", tipo, cidade, logadouro, numero, bairro);
    }

    public void setEndereco(String tipoLogadouro, String logadouro, int numero, String bairro, String cidade, String estado, String cep, String pais){

        if(!Endereco.tipoLogadouroEhValido(tipoLogadouro))
            throw new IllegalArgumentException("Tipo de Logadouro inválido.");
        
        this.tipoLogadouro = tipoLogadouro;
        this.logadouro = logadouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
    }

    public static boolean tipoLogadouroEhValido(String tipoLogadouro){
        
        String minuscula = tipoLogadouro.toLowerCase();

        switch(minuscula){

            case "rua":
                return true;

            case "avenida":
                return true;

            case "alameda":
                return true;

            case "praça":
                return true;

            case "travessa":
                return true;

            case "rodovia":
                return true;

            case "estrada":
                return true;

            case "beco":
                return true;

            case "balneário":
                return true;

            case "bosque":
                return true;

            case "cais":
                return true;

            case "calçada":
                return true;

            case "largo":
                return true;

            case "viaduto":
                return true;

            case "viela":
                return true;

            case "passarela":
                return true;

            default:
                return false; 
        }
    }
}
