package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondScenePrincipal {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Button btnTeste, btnCalcCoefLinear; //Button representa botoes

    //Label representa rótulos
    private Label labelP1X;
    private Label labelP1Y;

    private Label labelP2X;
    private Label labelP2Y;

    private Label labelCoefAng;  //apresenta o coeficiente angular
    private Label labelCoefLin;  //apresenta o coeficiente linear

    //TextField Representa áreas de texto
    private TextField textFieldP1X; //campo de entrada do P1X
    private TextField textFieldP1Y;  //campo de entrada do P1Y

    private TextField textFieldP2X;  //campo de entrada do P2X
    private TextField textFieldP2Y; //campo de entrada do P2Y

    private TextField textFieldCoefAng;  //campo que mostra o resultado do coeficiente angular da reta
    private TextField textFieldCoefLin;  //campo que mostra o coeficiente linear da reta

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void criaScenePrincipal(Stage stage) {

        //Criando os labels para os pontos e os campos de texto para os dados
        labelP1X = new Label("Digite P1X: "); //rótulo
        textFieldP1X = new TextField(); //Área de texto para digitar P1X

        labelP1Y = new Label("Digite P1Y: ");
        textFieldP1Y = new TextField();  //Área de texto para digitar P1Y

        labelP2X = new Label("Digite P2X: ");
        textFieldP2X = new TextField();  //Área de texto para digitar P2X

        labelP2Y = new Label("Digite P2Y: ");
        textFieldP2Y = new TextField(); // Área de texto para digitar P2Y

        labelCoefAng = new Label("Coeficiente angular: ");  //apresenta o coeficiente angular

        labelCoefLin = new Label("Coeficiente linear: ");  //apresenta o coeficiente linear


        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal1 = new HBox(labelP1X, textFieldP1X); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal2 = new HBox(labelP1Y, textFieldP1Y);
        HBox grupoHorizontal3 = new HBox(labelP2X, textFieldP2X);
        HBox grupoHorizontal4 = new HBox(labelP2Y, textFieldP2Y);
        HBox grupoHorizontalCoefAng = new HBox(labelCoefAng, textFieldCoefAng);
        HBox grupoHorizontalCoefLin = new HBox(labelCoefLin, textFieldCoefLin);

///////////////////////////////////////////////////////////////////////////////////////


        Reta reta = new Reta();
        String p1x = textFieldP1X.getText();  //Recebendo como String
        String p1y = textFieldP1Y.getText();
        String p2x = textFieldP2X.getText();
        String p2y = textFieldP2Y.getText();

        reta.ponto1.x = Integer.parseInt(p1x);  //Transformando em int
        reta.ponto1.y = Integer.parseInt(p1y);
        reta.ponto2.x = Integer.parseInt(p2x);
        reta.ponto2.y = Integer.parseInt(p2y);




////////////////////////////////////////////////////////////////////////////////////////



        //Criamos o botão
        btnTeste = new Button("Executar Ação");
        //Criamos a ação que o botão responderá as ser pressionado
        btnTeste.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão

            //Calculando os coeficientes angular e linear
            double coeficienteAngular = reta.coeficienteAngular(reta.ponto1, reta.ponto2);
            double coeficienteLinear = reta.coeficienteLinear(reta.ponto1, reta.ponto2);


            textFieldCoefAng.setEditable(false);
            textFieldCoefLin.setEditable(false);

            //Exibindo valor convertido para String
            textFieldCoefAng.setText(String.valueOf(coeficienteAngular));
            textFieldCoefLin.setText(String.valueOf(coeficienteLinear));



        });

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(grupoHorizontal1,grupoHorizontal2,grupoHorizontal3,grupoHorizontal4, btnTeste, grupoHorizontalCoefAng, grupoHorizontalCoefLin);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300, 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

}
