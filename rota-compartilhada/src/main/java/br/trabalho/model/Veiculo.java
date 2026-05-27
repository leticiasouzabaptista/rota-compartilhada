package br.trabalho.model;

public class Veiculo {

    private String modelo;
    private String placa;
    private String chassi;
    private int anoFabricacao;
    private String cor;
    public static final int LIMITE_ANO_FABRICACAO = 2016;

    public Veiculo(String modelo, String placa, String chassi, String cor, int anoFabricacao){

        if(!anoEhValido(anoFabricacao))
            throw new IllegalArgumentException("Ano de fabricação não aceito.");
        
        this.anoFabricacao = anoFabricacao;
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
    }

    public boolean anoEhValido(int anoFabricacao){

        if(anoFabricacao < LIMITE_ANO_FABRICACAO)
            return false;
        return true;
    }

    public void exibeVeiculo(){
        System.out.printf("Veiculo: %s, %s, %s, %s, %d\n", modelo, placa, chassi, cor, anoFabricacao);
    }

    public void setVeiculo(String modelo, String placa, String chassi, String cor, int anoFabricacao){

        if(!anoEhValido(anoFabricacao))
            throw new IllegalArgumentException("Ano de fabricação não aceito.");
        
        this.anoFabricacao = anoFabricacao;
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        
    }
}