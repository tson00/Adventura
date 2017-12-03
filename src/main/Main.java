/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.Mapa;
import GUI.MenuLista;
import GUI.PanelBatohu;
import GUI.PanelSchovat;
import GUI.PanelSeber;
import GUI.PanelVeci;
import GUI.PanelVychody;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import logika.*;
import uiText.TextoveRozhrani;

/**
 *
 * @author Tsoy Nadezhda
 * 
 * 
 */
public class Main extends Application {
    
    private TextArea centralText;// smazat TextArea
    private IHra hra; //smazat IHra
    private TextField zadejPrikazTextArea;//smazat TextField
    private Mapa mapa;
    private MenuLista menuLista;
    private Stage stage;


    @Override
    public void start(Stage primaryStage) {
        this.stage=primaryStage;
        setHra(new Hra()); //smazat IHra smazano
      mapa =new Mapa(hra);
      menuLista=new MenuLista(this);
    
        BorderPane borderPane = new BorderPane();
        
        
 
        
        
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
        borderPane.setBottom(dolniLista);

  
        borderPane.setTop(menuLista);
      
        
      Scene scene = new Scene(borderPane, 1000, 500);
      
        primaryStage.setTitle("Adventura");

        primaryStage.setScene(scene);
        primaryStage.show();
        zadejPrikazTextArea.requestFocus();//nemusim klikat na text
        
        centralText = new TextArea();//smazat TextArea
 
        getCentralText().setText(hra.vratUvitani());
        getCentralText().setEditable(false);
        borderPane.setCenter(getCentralText());
               
        Label lVychod = new Label("Východy:");
        lVychod.setFont(Font.font("Arial", FontWeight.BOLD, 15));  
        
        Label lVeci = new Label("\n "+"Najez v káždém prostoru!");
        lVeci.setFont(Font.font("Arial", FontWeight.BOLD, 15));   
        
        Label lBatoh = new Label("\n"+"Batoh:");
        lBatoh.setFont(Font.font("Arial", FontWeight.BOLD, 15));  
       
        
          Label lSchovat = new Label("Musis se schovat!");
        lSchovat.setFont(Font.font("Arial", FontWeight.BOLD, 15)); 
        
        
             Label lSeber = new Label("Mužeš tohle sebrat:");
        lSeber.setFont(Font.font("Arial", FontWeight.BOLD, 15)); 
        
        

        BorderPane levy = new BorderPane();
        BorderPane pravy= new BorderPane();
        
        FlowPane l1 = new FlowPane();
                 
        FlowPane l2 = new FlowPane();
                FlowPane l3 = new FlowPane();
                FlowPane l4 = new FlowPane();
                 FlowPane l5 = new FlowPane();
                

      
           
               PanelVychody vychody = new PanelVychody(hra.getHerniPlan(),centralText,zadejPrikazTextArea);
      PanelVeci panelVeci = new PanelVeci(hra.getHerniPlan(),centralText);  
         PanelBatohu panelBatohu = new PanelBatohu(hra.getHerniPlan(),centralText);
             PanelSchovat panelSchovat = new PanelSchovat(hra.getHerniPlan(),centralText);
                  PanelSeber panelSeber = new PanelSeber(hra.getHerniPlan(),centralText);
                    
               l1.setPrefWidth(10);
                                l2.setPrefWidth(10);
                                                l3.setPrefWidth(10);
                                                                l4.setPrefWidth(10);
                                                                                l5.setPrefWidth(10);
         
        l1.getChildren().addAll(lVychod,vychody.getList());
        l2.getChildren().addAll(lVeci,panelVeci.getList());
       l3.getChildren().addAll(lBatoh,panelBatohu.getList());
        l4.getChildren().addAll(lSchovat,panelSchovat.getList());
          l5.getChildren().addAll(lSeber,panelSeber.getList());
   
        
       
          
                levy.setTop(mapa);
                levy.setRight(l4);
                levy.setLeft(l2);
                pravy.setTop(l1);
                 pravy.setLeft(l5);
                 pravy.setRight(l3);
                 
                
              
           
        
     borderPane.setLeft(levy);
     borderPane.setRight(pravy);
     
   

    }

    public Mapa getMapa() {
        return mapa;
    }
    
    

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
      public void novaHra() {
        start(stage);
    }
    

}