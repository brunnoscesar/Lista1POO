package br.inatel.cdg.algebra;

import br.inatel.cdg.algebra.scene.SecondScenePrincipal;
import javafx.application.Application;
import javafx.stage.Stage;
//Nao precisa se preocupar com essa classe
public class Main extends Application {

    //Não precisa alterar nada dessa classe
    @Override
    public void start(Stage stage) throws Exception {
        new SecondScenePrincipal().criaScenePrincipal(stage);
    }

    //Não precisa alterar nada dessa classe
    public static void main(String[] args) {
        launch();
    }
}
