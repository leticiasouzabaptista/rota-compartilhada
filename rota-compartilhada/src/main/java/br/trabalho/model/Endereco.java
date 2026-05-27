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
        
        switch(tipoLogadouro){

            case "Rua":
                return true;

            case "Avenida":
                return true;

            case "Alameda":
                return true;

            case "Praça":
                return true;

            case "Travessa":
                return true;

            case "Rodovia":
                return true;

            case "Estrada":
                return true;

            case "Beco":
                return true;

            case "Balneário":
                return true;

            case "Bosque":
                return true;

            case "Cais":
                return true;

            case "Calçada":
                return true;

            case "Largo":
                return true;

            case "Viaduto":
                return true;

            case "Viela":
                return true;

            case "Passarela":
                return true;

            default:
                return false; 
        }
       
         /*  switch(tipoLogadouro){
            case "Rua" -> return true;
            case "Avenida" -> return true;
            case "Alameda" -> return true;
            case "Praça" -> return true;
            case "Travessa" -> return true;
            case "Rodovia" -> return true;
            case "Estrada" -> return true;
            case "Beco" -> return true;
            case "Balneário" -> return true;
            case "Bosque" -> return true;
            case "Cais" -> return true;
            case "Calçada" -> return true;
            case "Largo" -> return true;
            case "Viaduto" -> return true;
            case "Viela" -> return true;
            case "Passarela" -> return true;
            default -> {
                    System.out.prinln("Logadouro não permitido.");
                    return false;
                }  
            }*/
    }
}
