package br.trabalho;

import br.trabalho.menu.Menu;
import br.trabalho.service.SistemaService;

public class Main {
    public static void main(String[] args) {

        SistemaService sistema = new SistemaService();
        Menu menu = new Menu(sistema);

        menu.executa();

    }
}