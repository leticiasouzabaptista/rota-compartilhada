package br.trabalho;
public class Motorista {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private Veiculo veiculo;

    public Motorista(String nome, String cpf, Endereco endereco, Veiculo veiculo){

        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.veiculo = veiculo;
    }

    public void setEndereco(String tipoLogadouro, String logadouro, int numero, String bairro, String cidade, String estado, String cep, String pais){
        
        if(!Endereco.tipoLogadouroEhValido(tipoLogadouro))
            throw new IllegalArgumentException("Tipo de Logadouro inválido.");
        endereco.setEndereco(tipoLogadouro, logadouro, numero, bairro, cidade, estado, cep, pais);
    }

    public void setVeiculo(String modelo, String placa, String chassi, String cor, int anoFabricacao){

        if(anoFabricacao < Veiculo.LIMITE_ANO_FABRICACAO)
            throw new IllegalArgumentException("Ano de fabricação não aceito.");
        veiculo.setVeiculo(modelo, placa, chassi, cor, anoFabricacao);
    }

}
