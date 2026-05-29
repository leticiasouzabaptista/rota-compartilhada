package br.trabalho.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import br.trabalho.model.Endereco;
import br.trabalho.model.Passageiro;
import br.trabalho.util.Leituras;

public class PassageiroService {

    private Map <String, Passageiro> passageiros;
    private Leituras leitura;
    private Scanner scanner;

    public PassageiroService(){
        passageiros = new HashMap<>();
        leitura = new Leituras();
        scanner = new Scanner(System.in);
    }

    public boolean passageiroExiste(String cpf){
        return passageiros.containsKey(cpf);
    }

    public Passageiro buscPassageiro(String cpf){
        return passageiros.get(cpf);
    }

    public void cadastrarPassageiro(){
        System.out.println("\n=== Cadastrar Passageiro ===\n");

        System.out.print("Nome completo (0 para voltar ao menu): ");
        String nome = scanner.nextLine();
        if(nome.equals("0"))
            return;
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Endereco endereco = leitura.lerEnderecoCadastro();

        Passageiro passageiro = new Passageiro(nome, cpf, endereco);
        passageiros.put(cpf,passageiro);

        System.out.println("\nPassageiro cadastrado com sucesso!");
    }

    public void exibirPassageiros(){
        System.out.print("=== Passageiros Cadastrados ===\n");

        if(passageiros.isEmpty()){
            System.out.println("Não existem Passageiros cadastrados.");
            return;
        }

        for(Passageiro passageiro: passageiros.values()){
            System.out.println(passageiro.getNome() + "\n");
        }
    }

    public void exibirPassageiro(){
        System.out.print("=== Exibe Dados de um Passageiro ===");

        System.out.print("\nCPF do passageiro: ");       
        String cpf = scanner.nextLine();
        System.out.print("\n");
        
        if(passageiros.containsKey(cpf))
            passageiros.get(cpf).exibeDados();
        else
            System.out.println("Passageiro não cadastrado.");
    }

    public void removePassageiro(){
        System.out.println("=== Remover Passageiro ===\n");

        System.out.print("CPF (0 para voltar ao menu): ");
        String cpf = scanner.nextLine();
        if(cpf.equals("0"))
            return;

        passageiros.remove(cpf);

        System.out.println("Passageiro removido com sucesso!");
    }

    public void editaPassageiro(){
        System.out.println("=== Edita dados de um Passageiro ===\n");

        System.out.print("CPF (0 para voltar ao menu): ");
        String cpf = scanner.nextLine();
        if(cpf.equals("0"))
            return;

        if(!passageiros.containsKey(cpf)){
            System.out.println("Passageiro não Cadastrado.");
            return;
        }
        
        System.out.println("Passageiro(a): " + passageiros.get(cpf).getNome());
        passageiros.get(cpf).setEndereco();
    }
}