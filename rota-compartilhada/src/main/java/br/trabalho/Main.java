package br.trabalho;

import br.trabalho.menu.Menu;
import br.trabalho.model.Motorista;
import br.trabalho.service.SistemaService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        SistemaService sistema = new SistemaService();

        String arquivo = "motoristas.csv";
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

                String linha;

                br.readLine(); 

                while ((linha = br.readLine()) != null) {

                    String[] dados = linha.split(",");

                    String nome = dados[0].trim();
                    String cpf = dados[1].trim();
                    String tipoLogradouro = dados[2].trim();
                    String logradouro = dados[3];
                    int numero = Integer.parseInt(dados[4]);
                    String bairro = dados[5].trim();
                    String cidade = dados[6].trim();
                    String estado = dados[7].trim();
                    String pais = dados[8].trim();
                    String cep = dados[9].trim();
                    String carroNome = dados[10].trim();
                    String modelo = dados[11].trim();
                    String placa = dados[12].trim();
                    String chassi = dados[13].trim();
                    int ano = Integer.parseInt(dados[14]);
                    String cor = dados[15].trim();
                    boolean disponivel = Boolean.parseBoolean(dados[16].trim());


                    sistema.getMotoristaService().cadastrarMotoritsaCsv(nome, cpf, tipoLogradouro, logradouro, numero, bairro, cidade, estado, pais, cep, carroNome, modelo, placa, chassi, ano, cor, disponivel);
                }
            } 
        catch (IOException e){
            e.printStackTrace();
        }

        Menu menu = new Menu(sistema);
        menu.executa(); 

    }
} 
