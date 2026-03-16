
package br.com.rafa.lolmanager;

import br.com.rafa.lolmanager.controller.ChampionController;
import br.com.rafa.lolmanager.view.ChampionView;

public class Main {

    public static void main(String[] args) {

        ChampionController controller = new ChampionController();

        ChampionView view = new ChampionView(controller);

        view.start();

    }

}
