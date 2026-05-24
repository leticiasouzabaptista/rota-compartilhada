package br.trabalho;

public class Main {
    public static void main(String[] args) {
        
        DadosSistema sistema = new DadosSistema();
        Menu menu = new Menu(sistema);

        menu.executa();
    }
}