

public class GerenciadorCarona {
    private Map <Integer, Carona> caronaAndamento;
    private Map <Integer, Carona> caronasAgendadas;
    private Map <Integer, Carona> caronasFinalizadas;
    private Scanner scanner;


    public GerenciadorCarona(){
        caronaAndamento = new HashMap<>();
        caronasAgendadas = new HashMap<>();
        caronasFinalizadas = new HashMap<>();

        scanner = new Scanner(System.in);
    }


     public void cadastraCarona(){

        System.out.print("=== Cadastrar Carona ===\n");
        System.out.print("CPF do passageiro: ");
        String cpfPassageiro = scanner.nextLine();
        if(!passageiros.containsKey(cpfPassageiro)){
            System.out.println("Passageiro não cadastrado.");
            return;
        }

        Endereco origem = insereEnderecoViagem("\nOrigem da Viagem");
        Endereco destino = insereEnderecoViagem("\nDestino da Viagem");

        LocalDateTime inicio = LocalDateTime.now();
        Random random = new Random();
        int duracao = random.nextInt(2)+1;
        LocalDateTime fim = inicio.plusHours(duracao);

        if(!passageiroDisponivel(cpfPassageiro, inicio, fim)){
            System.out.println("Passageiro possui conflito de horário.");
            return;
        }
    }
        
        String cpfMotorista = null;        
        for(Motorista motorista: motoristas.values()){
            if(motorista.getStatus()){
                cpfMotorista = motorista.getCpf();
                break;
            }
        }
        if(cpfMotorista == null){
            System.out.println("Nenhum motorista disponível.");
            return;
        }
        
        Carona carona = new Carona(passageiros.get(cpfPassageiro), motoristas.get(cpfMotorista), origem, destino, inicio, "Em andamento");
        caronas.add(carona);

        System.out.println("Carona cadastrada com sucesso!");
    }

    public void agendaCarona(){

        System.out.print("=== Agendar Carona ===\n");
        System.out.print("CPF do passageiro: ");
        String cpfPassageiro = scanner.nextLine();

        Endereco origem = insereEnderecoViagem("\nOrigem da Viagem");
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
            System.out.println("Carona agendada para o momento atual.");
            return;
        }

        Endereco destino = insereEnderecoViagem("\nDestino da Viagem");
        
        String cpfMotorista;        
        for(Motorista motorista: motoristas.values()){
            if(motorista.getStatus()){
                cpfMotorista = motorista.getCpf();
                break;
            }
        }
        
        Carona carona = new Carona(passageiros.get(cpfPassageiro), motoristas.get(cpfMotorista), origem, destino, inicio, fim, "Aguardando Inicio");
        caronasAgendadas.put(carona.getCodigo(),carona);

        System.out.println("Carona cadastrada com sucesso!");
    }

    public void exibeAgendamentosCaronas(){
        System.out.println("=== Caronas Agendadas ===\n");
        for(Carona carona: caronasAgendadas.values()){
            System.out.printf("Carona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeStatusCarona(){
        System.out.println("=== Verificar status de uma Carona ===\n");
        System.out.println("Codigo da carona: ");
        float codigo = scanner.nextFloat();
        if(caronasAgendadas.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
        if(caronaAndamento.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
        if(caronasFinalizadas.containsKey(codigo))
            System.out.println("Status da carona: " + caronaAndamento.get(codigo).getStatus());
    }

    public void exibeCaronasAndamento(){

        System.out.println("=== Caronas em Andamento ===\n");
        for(Carona carona: caronaAndamento.values()){
            System.out.printf("Carona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Previsão de encerramento: " + carona.exibeFim() + "\n");
        }
    }

    public void exibeCaronasFinalizadas(){
        System.out.print("=== Caronas Finalizadas ===\n");
        for(Carona carona: caronasFinalizadas.values()){
            System.out.printf("Carona de %s\n", carona.getNomePassageiro());
            System.out.println("Origem: " + carona.exibeOrigem());
            System.out.println("Destino: " + carona.exibeDestino());
            System.out.println("Inicio: " + carona.exibeInicio());
            System.out.println("Fim: " + carona.exibeFim() + "\n");
        }
    }

  
}
