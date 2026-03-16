
package br.com.rafa.lolmanager.view;

import br.com.rafa.lolmanager.controller.ChampionController;
import br.com.rafa.lolmanager.model.Champion;

import java.util.List;
import java.util.Scanner;

public class ChampionView {

    private ChampionController controller;
    private Scanner scanner = new Scanner(System.in);

    public ChampionView(ChampionController controller) {
        this.controller = controller;
    }

    public void start(){

        int option;

        do{

            System.out.println("\n1 Criar");
            System.out.println("2 Atualizar");
            System.out.println("3 Buscar por ID");
            System.out.println("4 Listar");
            System.out.println("5 Remover");
            System.out.println("0 Sair");

            option = scanner.nextInt();

            switch(option){

                case 1 -> criar();
                case 2 -> atualizar();
                case 3 -> buscar();
                case 4 -> listar();
                case 5 -> remover();

            }

        }while(option != 0);

    }

    private void criar(){

        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Classe (1. MAGO 2. LUTADOR 3. ATIRADOR 4. TANK 5. SUPORTE ): ");
        int classe = scanner.nextInt();

        System.out.print("Dano: ");
        int dano = scanner.nextInt();

        System.out.print("Vida: ");
        int vida = scanner.nextInt();

        System.out.print("Dificuldade: ");
        int dif = scanner.nextInt();

        Champion c = controller.criarChampion(nome,classe,dano,vida,dif);

        System.out.println(c);
    }

    private void atualizar(){

        System.out.print("ID: ");
        Long id = scanner.nextLong();

        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Classe(1. MAGO 2. LUTADOR 3. ATIRADOR 4. TANK 5. SUPORTE ): ");
        int classe = scanner.nextInt();

        System.out.print("Dano: ");
        int dano = scanner.nextInt();

        System.out.print("Vida: ");
        int vida = scanner.nextInt();

        System.out.print("Dificuldade: ");
        int dif = scanner.nextInt();

        Champion c = controller.updateChampion(id,nome,classe,dano,vida,dif);

        System.out.println(c);
    }

    private void buscar(){

        System.out.print("ID: ");
        Long id = scanner.nextLong();

        Champion c = controller.getChampionById(id);

        System.out.println(c);
    }

    private void listar(){

        List<Champion> list = controller.listChampions();

        for(Champion c : list){
            System.out.println(c);
        }

    }

    private void remover(){

        System.out.print("ID: ");
        Long id = scanner.nextLong();

        controller.deleteChampion(id);

    }

}
