/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import main.Main;



/**
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class MenuLista extends MenuBar{
    
private final Main main;

/**
 *@param main
 ***/
    
    public MenuLista(Main main){
        this.main = main;
        init();
    }
    /*
    init
    */
  private void init(){
        Menu menuSoubor = new Menu("Advenura");
        
        MenuItem itemNovaHra = new MenuItem("Nová hra");

        itemNovaHra.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        
        MenuItem itemKonec = new MenuItem("Konec");
        
        
        Menu menuHelp = new Menu("Help");
        MenuItem itemOProgramu = new MenuItem("O programu");
        MenuItem itemNapoveda = new MenuItem("Napoveda");
        
        
        menuSoubor.getItems().addAll(itemNovaHra, itemKonec);
        menuHelp.getItems().addAll(itemOProgramu, itemNapoveda);
        
        this.getMenus().addAll(menuSoubor, menuHelp);
        
        itemOProgramu.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("O Adventure");
            alert.setHeaderText("Toto je ma adventura");
            alert.setContentText("Graficka verze adventury");
            alert.initOwner(main.getStage());
            alert.showAndWait();
        });
        
        itemNapoveda.setOnAction((ActionEvent event) -> {
            Stage stage = new Stage();
            stage.setTitle("Napoveda");
            WebView webview = new WebView();
            
            webview.getEngine().load(Main.class.getResource("/zdroje/napoveda.html").toExternalForm());
            
            stage.setScene(new Scene(webview, 500, 500));
            stage.show();
        });
        
        itemKonec.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
       
        itemNovaHra.setOnAction((ActionEvent event) -> {
            try {
                main.novaHra();
                main.getStage().close();
            } catch (InterruptedException ex) {
                Logger.getLogger(MenuLista.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }      
        
}
