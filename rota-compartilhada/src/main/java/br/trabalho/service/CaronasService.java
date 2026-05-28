package br.trabalho.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import br.trabalho.model.Carona;
import br.trabalho.model.Endereco;
import br.trabalho.model.Motorista;
import br.trabalho.util.*;
import java.util.Iterator;

public class CaronasService {

    private Map <Integer, Carona> caronasAndamento;
    private Map <Integer, Carona> caronasAgendadas;
    private Map <Integer, Carona> caronasFinalizadas;
    private MotoristaService motoristaService;
    private PassageiroService passageiroService;
    private Leituras leitura;

    private Random random;
    private Scanner scanner;

    public CaronasService(MotoristaService motoristaService, PassageiroService passageiroService){
        
        this.motoristaService = motoristaService;
        this.passageiroService = passageiroService;

        caronasAndamento = new HashMap<>();
        caronasAgendadas = new HashMap<>();
        caronasFinalizadas = new HashMap<>();
        leitura = new Leituras();

        random = new Random();
        scanner = new Scanner(System.in);
    }

    public boolean passageiroEstaEmCarona(String cpf){
        for(Carona carona : caronasAndamento.values()){
            if(carona.getPassageiro().getCpf().equals(cpf)){
                return false;
            }
        }
        return true;
    }

    public boolean conflitaHorario(LocalDateTime inicio1, LocalDateTime fim1, LocalDateTime inicio2, LocalDateTime fim2){
        return inicio1.isBefore(fim2) && fim1.isAfter(inicio2); 
    }

    public boolean passageiroConflitaHorario(String cpf, LocalDateTime inicio, LocalDateTime fim){
        for(Carona carona : caronasAgendadas.values()){
            if(carona.getPassageiro().getCpf().equals(cpf))
                return conflitaHorario(inicio, fim, carona.getInicio(), carona.getFim());
        }
        return false;
    }

    public Motorista selecionarMotorista(LocalDateTime inicio, LocalDateTime fim) {

        List <Motorista> disponiveis = new ArrayList<>();

        for(Motorista motorista: motoristaService.getMotoristas().values()){
            if(motorista.estaDisponivel()){
                boolean conflito = false;
                for(Carona carona: caronasAgendadas.values()){
                    if(carona.getMotorista().getCpf().equals(motorista.getCpf())){
                        if(conflitaHorario(carona.getInicio(), carona.getFim(), inicio, fim)){
                            conflito = true;
                            break;
                        }
                    }
                }
                if(!conflito)
                    disponiveis.add(motorista);
            }
        }

        if(disponiveis.isEmpty()){
            return null;
        }

        int indice = random.nextInt(disponiveis.size());

        disponiveis.get(indice);

        return disponiveis.get(indice);
    }

    public void cadastraCarona(){

        System.out.println("\n=== Cadastrar Carona ===\n");
        System.out.print("CPF do passageiro (0 para voltar ao menu): ");
        String cpfPassageiro = scanner.nextLine();
        if(cpfPassageiro.equals("0"))
            return;

        if(!passageiroService.passageiroExiste(cpfPassageiro)){
            System.out.println("Passageiro não cadastrado.");
            return;
        }

        if(!passageiroEstaEmCarona(cpfPassageiro)){
            System.out.println(passageiroService.buscPassageiro(cpfPassageiro).getNome() + " ja esta em Carona.");
        }

        LocalDateTime inicio = LocalDateTime.now();
        int duracao = random.nextInt(2)+1;
        LocalDateTime fim = inicio.plusHours(duracao);

        if(passageiroConflitaHorario(cpfPassageiro, inicio, fim)){
            System.out.println("Passageiro possui conflito de horário com carona Agendada Anteriormente.");
            return;
        }

        Motorista motorista = selecionarMotorista(inicio, fim);
        motorista.ocuparMotorista();

        Carona carona = null;
        while(true){
            try{
                Endereco origem = leitura.insereEnderecoViagem("\nOrigem da Viagem");
                Endereco destino = leitura.insereEnderecoViagem("\nDestino da Viagem");
                
                carona = new Carona(passageiroService.buscPassageiro(cpfPassageiro), motorista, origem, destino, inicio, fim, duracao, "Em andamento");
                caronasAndamento.put(carona.getCodigo(), carona);
                passageiroService.buscPassageiro(cpfPassageiro).ocupaPassageiro();

                break;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nCarona não aceita.");
                System.out.println(e.getMessage());
                System.out.println("\nTente novamente:\n");
            }
        }

        System.out.println("\nCodigo da carona: " + carona.getCodigo());
        System.out.println("Carona cadastrada com sucesso!");
    }

    public void agendaCarona(){

        System.out.print("=== Agendar Carona ===\n");
        System.out.print("CPF do passageiro (0 para voltar ao menu): ");
        String cpfPassageiro = scanner.nextLine();
        if(cpfPassageiro.equals("0"))
            return;

        System.out.print("Dia: ");
        int dia = scanner.nextInt();
        System.out.print("Mes");
        int mes = scanner.nextInt();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("\nHora: ");
        int hora = scanner.nextInt();
        System.out.print("Minuto: ");
        int minuto = scanner.nextInt();
        LocalDateTime inicio = LocalDateTime.of(ano, mes, dia, hora, minuto);
        LocalDateTime agora = LocalDateTime.now();

        if(inicio.isBefore(agora) || inicio.isEqual(agora)){
            System.out.println("Erro: Carona não pode ser agendada para o momento atual.");
            return;
        }

        int duracao = random.nextInt(2)+1;
        LocalDateTime fim = inicio.plusHours(duracao);
        
        Motorista motorista = selecionarMotorista(inicio, agora);
        
        while(true){
            try{
                Endereco origem = leitura.insereEnderecoViagem("\nOrigem da Viagem");
                Endereco destino = leitura.insereEnderecoViagem("\nDestino da Viagem");

                Carona carona = new Carona(passageiroService.buscPassageiro(cpfPassageiro), motorista, origem, destino, inicio, fim, duracao, "Em andamento");
                caronasAgendadas.put(carona.getCodigo(), carona);

                break;
            }

            catch(IllegalArgumentException e){
                System.out.println("\nCarona não aceita.");
                System.out.println(e.getMessage());
                System.out.println("\nTente novamente:\n");
            }
        }
        
        System.out.println("Carona agendada com sucesso!");
    }

    public void exibeAgendamentosCaronas(){
        System.out.println("=== Caronas Agendadas ===\n");

        if(caronasAgendadas.isEmpty()){
            System.out.println("Não existem caronas em andamento.");
            return;
        }

        for(Carona carona: caronasAgendadas.values()){
            System.out.printf("Carona de %s\n", carona.getPassageiro().getNome());
            carona.exibeOrigem();
            carona.exibeDestino();
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeStatusCarona(){
        System.out.println("=== Verificar status de uma Carona ===\n");

        System.out.println("Codigo da carona: ");
        int codigo = scanner.nextInt();

        if(caronasAgendadas.containsKey(codigo))
            System.out.println("Carona de " + caronasAgendadas.get(codigo).getPassageiro().getNome() + "\nStatus da carona: " + caronasAgendadas.get(codigo).exibeStatus() + "\n");
        else if(caronasAndamento.containsKey(codigo))
            System.out.println("Carona de " + caronasAndamento.get(codigo).getPassageiro().getNome() + "\nStatus da carona: " + caronasAgendadas.get(codigo).exibeStatus() + "\n");
        else if(caronasFinalizadas.containsKey(codigo))
            System.out.println("Carona de " + caronasFinalizadas.get(codigo).getPassageiro().getNome() + "\nStatus da carona: " + caronasAgendadas.get(codigo).exibeStatus() + "\n");
        else
            System.out.println("\nCarona não existe ou código esta errado.");

    }

    public void exibeCaronasAndamento(){
        System.out.println("=== Caronas em Andamento ===\n");

        if(caronasAndamento.isEmpty()){
            System.out.println("Não existem caronas agendadas.");
            return;
        }

        for(Carona carona: caronasAndamento.values()){
            System.out.printf("Carona de %s\n", carona.getPassageiro().getNome());
            carona.exibeOrigem();
            carona.exibeDestino();
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeCaronasFinalizadas(){
        System.out.print("=== Caronas Finalizadas ===\n");

        if(caronasFinalizadas.isEmpty()){
            System.out.println("Não existem caronas finalizadas.");
            return;
        }

        for(Carona carona: caronasFinalizadas.values()){
            System.out.printf("Carona de %s\n", carona.getPassageiro().getNome());
            carona.exibeOrigem();
            carona.exibeDestino();
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void atualizaSistema(){
        LocalDateTime agora = LocalDateTime.now();

        Iterator<Carona> itAgendadas = caronasAgendadas.values().iterator();
        while (itAgendadas.hasNext()) {
            Carona carona = itAgendadas.next();

            if (carona.getInicio().isEqual(agora) || carona.getInicio().isBefore(agora)){
                itAgendadas.remove();

                caronasAndamento.put(carona.getCodigo(), carona);

                carona.getMotorista().ocuparMotorista();
                carona.getPassageiro().ocupaPassageiro();
            }
        }

        Iterator<Carona> itAndamento = caronasAndamento.values().iterator();
        while (itAndamento.hasNext()) {
            Carona carona = itAndamento.next();

            if (carona.getFim().isEqual(agora) || carona.getFim().isBefore(agora)) {
                itAndamento.remove();

                carona.getMotorista().liberarMotorista();
                carona.getPassageiro().liberaPassageiro();

                caronasFinalizadas.put(carona.getCodigo(), carona);
            }
        }
    }
}
