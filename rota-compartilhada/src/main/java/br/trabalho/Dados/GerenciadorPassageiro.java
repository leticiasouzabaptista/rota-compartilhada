import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import br.trabalho.Passageiro;
import br.trabalho.Endereco;


public class GerenciadorPassageiro {
 private Map <String, Passageiro> passageiros;
 private Scanner scanner;
 private Auxiliares auxiliares;

    public GerenciadorPassageiro(){
        passageiros = new HashMap<>();
        scanner = new Scanner(System.in);
        auxiliares =  new Auxiliares();
    }

    public void cadastrarPassageiro(){
        System.out.println("=== Cadastrar Passageiro ===\n");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Endereco endereco = auxiliares.lerEnderecoCadastro();

        Passageiro passageiro = new Passageiro(nome, cpf, endereco);
        passageiros.put(cpf,passageiro);

        System.out.println("\nPassageiro cadastrado com sucesso!");
    }

    public void exibirPassageiros(){
        System.out.print("=== Passageiros Cadastrados ===\n");
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
        System.out.println("CPF do Passageiro: ");
        String cpf = scanner.nextLine();
        passageiros.remove(cpf);
    }

    public void editaPassageiro(){
        System.out.println("=== Edita dados de um Passageiro ===\n");
        System.out.print("CPF do Passageiro: ");
        String cpf = scanner.nextLine();

        passageiros.get(cpf).setEndereco();
    }

}
