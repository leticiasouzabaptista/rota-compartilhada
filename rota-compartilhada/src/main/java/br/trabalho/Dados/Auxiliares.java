public class Auxiliares {


     public Endereco lerEnderecoCadastro() {

        boolean enderecoEhvalido = false;
        while(!enderecoEhvalido){

            try {
                System.out.println("\nEndereco");
                System.out.print("Tipo do Logradouro: ");
                String tipoLogradouro = scanner.nextLine();
                System.out.print("Logradouro: ");
                String logradouro = scanner.nextLine();
                System.out.print("Nº: ");
                int numero = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Bairro: ");
                String bairro = scanner.nextLine();
                System.out.print("CEP: ");
                String cep = scanner.nextLine();
                System.out.print("Cidade: ");
                String cidade = scanner.nextLine();
                System.out.print("Estado: ");
                String estado = scanner.nextLine();
                System.out.print("Pais: ");
                String pais = scanner.nextLine();

                Endereco endereco = new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, estado, cep, pais);
                enderecoEhvalido = true;
                return endereco;
            }
            catch(IllegalArgumentException e){
                System.out.println("\nEndereço não aceito.");
                System.out.println(e.getMessage());
                System.out.println("\nTente novamente:\n");
            }
        }
    }


    public Endereco insereEnderecoViagem(String tipo){

        System.out.println(tipo);
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Logadouro: ");
        String logadouro = scanner.nextLine();
        System.out.print("Numero: ");
        int numero = scanner.nextInt();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();

        return new Endereco(cidade, logadouro, numero, bairro);
    }

        public boolean passageiroDisponivel(String cpfPassageiro, LocalDateTime inicio, LocalDateTime fim){

        for(Carona carona : caronaAndamento.values()){
            if(carona.getCpfPassageiro().equals(cpfPassageiro)){
                System.out.println(carona.getNomePassageiro() + " já esta em carona.");
                return false;
            }
        }

        for(Carona carona : caronasAgendadas.values()){
            if(carona.getCpfPassageiro().equals(cpfPassageiro)){
                if(temConflito(inicio, fim, carona.getInicio(), carona.getFim()))
                    return false;
            }
        }
        return true;
    }

    public boolean temConflito(LocalDateTime inicio1, LocalDateTime fim1, LocalDateTime inicio2,  LocalDateTime fim2){
        return inicio1.isBefore(fim2) && fim1.isAfter(inicio2);
    }




}
