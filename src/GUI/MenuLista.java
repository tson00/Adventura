/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import logika.Hra;
import logika.IHra;
import main.Main;

/**
 *
 * @author acer
 */
public class MenuLista extends MenuBar{
    private IHra hra;
    private Main main;
    public MenuLista(IHra hra,Main main){
        this.hra=hra;
        this.main=main;
    init();
    }
    private void init(){
    Menu novysoubor= new Menu("Adventura");
    Menu napoveda = new Menu("Help");
    MenuItem novaHra=new MenuItem("Nová hra");
       
   // MenuItem novaHra=new MenuItem("Nova hra",new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/mapa.png"))));
    novaHra.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
    MenuItem konecHry=new MenuItem("Konec hry");
    novysoubor.getItems().addAll(novaHra,konecHry);
    
    MenuItem oProgramu = new MenuItem("O mě");
     MenuItem napovedaItem = new MenuItem("Napověda");
     napoveda.getItems().addAll(oProgramu,napovedaItem);
    this.getMenus().addAll(novysoubor,napoveda);
    
   konecHry.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    });
   novaHra.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            hra =new Hra();     
        main.getMapa().newGame(hra);
        main.setHra(hra);
        main.getCentralText().setText(hra.vratUvitani());
      //  main.getTextArea().zadejPrikazTextArea.setEditable(false);
      
        }
    });
   
   oProgramu.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          Alert oProgramuAlert=new Alert(Alert.AlertType.INFORMATION);//misto information dat error
          oProgramuAlert.setTitle("O mě");
          oProgramuAlert.setHeaderText("Тsoy Nadezhda");
          oProgramuAlert.setContentText("tson00 út 09:15");
          oProgramuAlert.initOwner(main.getStage());
          oProgramuAlert.showAndWait();
        }
    });
   
   napovedaItem.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
         Stage stage =new Stage();
         stage.setTitle("Napoveda");
         WebView webView =new WebView();
         webView.getEngine().load(Main.class.getResource("/zdroje/napoveda.html").toExternalForm());
         stage.setScene(new Scene(webView, 500,500));
         stage.show();
        }
    });
}}
    

