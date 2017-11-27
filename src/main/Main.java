/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.Mapa;
import GUI.MenuLista;
import GUI.Batoh;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logika.*;
import uiText.TextoveRozhrani;

/**
 *
 * @author xzenj02
 */
public class Main extends Application {
    
    private TextArea centralText;// smazat TextArea
    private IHra hra; //smazat IHra
    private TextField zadejPrikazTextArea;//smazat TextField
    private Mapa mapa;
    private MenuLista menuLista;
    private Stage stage;
    private Batoh batoh;

    @Override
    public void start(Stage primaryStage) {
        this.stage=primaryStage;
        setHra(new Hra()); //smazat IHra smazano
      mapa =new Mapa(hra);
      menuLista=new MenuLista(hra, this);
      batoh=new Batoh(hra);
        BorderPane borderPane = new BorderPane();
        
        
        centralText = new TextArea();//smazat TextArea
        getCentralText().setText(hra.vratUvitani());
        getCentralText().setEditable(false);
        borderPane.setCenter(getCentralText());
        
        Label zadejPrikazLabel = new Label("Zadej prikaz: ");
        zadejPrikazLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
         zadejPrikazTextArea= new TextField("...");//smazzat TextField
        zadejPrikazTextArea.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String vstupniPrikaz = zadejPrikazTextArea.getText();//ulozim prikazy ze hry
                String odpovedHry= hra.zpracujPrikaz(vstupniPrikaz);
                getCentralText().appendText("\n"+vstupniPrikaz + "\n");
                getCentralText().appendText("\n"+odpovedHry + "\n");
                zadejPrikazTextArea.setText("");
                if (hra.konecHry())
                {
                zadejPrikazTextArea.setEditable(false);
                  getCentralText().appendText(hra.vratEpilog());
                    // System.exit(0);
                }

               
            }
        });
        
      
        
        
        FlowPane dolniLista = new FlowPane();
        dolniLista.setAlignment(Pos.CENTER);
        dolniLista.getChildren().addAll(zadejPrikazLabel,zadejPrikazTextArea);
        
        borderPane.setLeft(mapa);
        borderPane.setBottom(dolniLista);
        borderPane.setTop(menuLista);
        borderPane.setRight(batoh);
        
        Scene scene = new Scene(borderPane, 750, 450);

        primaryStage.setTitle("Adventura");

        primaryStage.setScene(scene);
        primaryStage.show();
        zadejPrikazTextArea.requestFocus();//nemusim klikat na text
    }

    public Mapa getMapa() {
        return mapa;
    }
    
    
    public Batoh getBatoh()
    {
    
    return batoh;
    }
/*private AnchorPane nastaveniMapy(){

AnchorPane obrazekPane= new AnchorPane();

        ImageView obrazekImageView= new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/mapa.png"), 200,200,false,true) );
        Circle tecka= new Circle(10, Paint.valueOf("red"));
        obrazekPane.setTopAnchor(tecka,25.0);
         obrazekPane.setLeftAnchor(tecka,100.0);
       
        obrazekPane.getChildren().addAll(obrazekImageView,tecka);
        return obrazekPane;

}*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            launch(args);
        }
        else{
            if (args[0].equals("-txt")) {
                IHra hra = new Hra();
                TextoveRozhrani textHra = new TextoveRozhrani(hra);
                textHra.hraj();
            }
            else{
                System.out.println("Neplatny parametr");
                System.exit(1);
            }
        }
    }

    /**
     * @return the centralText
     */
    public TextArea getCentralText() {
        return centralText;
    }

    /**
     * @param hra the hra to set
     */
    public void setHra(IHra hra) {
        this.hra = hra;
    }

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

}