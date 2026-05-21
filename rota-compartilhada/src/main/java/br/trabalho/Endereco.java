package br.trabalho;

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

    public void setEndereco(String tipoLogadouro, String logadouro, int numero, String bairro, String cidade, String estado, String cep, String pais){

        this.tipoLogadouro = tipoLogadouro;
        this.logadouro = logadouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
    }
}
