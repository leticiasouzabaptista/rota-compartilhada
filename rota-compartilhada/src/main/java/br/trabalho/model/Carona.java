package br.trabalho.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Carona {

    private Passageiro passageiro;
    private Motorista motorista;
    private Endereco origem;
    private Endereco destino;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private int duracao;
    private String status;
    private static int proxCodigo = 1;
    private int codigo;

    public Carona(Passageiro passageiro, Motorista motorista, Endereco origem, Endereco destino, LocalDateTime inicio, LocalDateTime fim, int duracao, String status){

        if(origem == destino)
            throw new IllegalArgumentException("Origem e Destino são iguais.");
        
        this.passageiro = passageiro;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.inicio = inicio;
        this.fim = fim;
        this.duracao = duracao;
        this.status = status;

        this.codigo = criaCodigo();
    }

    private static int criaCodigo(){
        return proxCodigo++;
    }

    public Integer getCodigo(){
        return codigo;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String exibeStatus(){
        return status;
    }

    public Passageiro getPassageiro(){
        return passageiro;
    }

    public Motorista getMotorista(){
        return motorista;
    }

    public LocalDateTime getInicio(){
        return inicio;
    }

    public LocalDateTime getFim(){
        return fim;
    }

    public void exibeOrigem(){
        origem.exibeEnderecoViagem("Origem: ");
    }

    public void exibeDestino(){
        destino.exibeEnderecoViagem("Destino: ");
    }

    public String exibeInicio(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String comeco = inicio.format(formato);
        return comeco;
    }

    public String exibeFim(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String comeco = fim.format(formato);
        return comeco;
    }
}
