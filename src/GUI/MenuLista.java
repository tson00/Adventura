/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
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
    MenuItem novaHra=new MenuItem("Nova hra");
   // MenuItem novaHra=new MenuItem("Nova hra",new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/mapa.png"))));
    novaHra.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
    MenuItem konecHry=new MenuItem("Konec hry");
    novysoubor.getItems().addAll(novaHra,konecHry);
    this.getMenus().addAll(novysoubor);
    
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
        }
    });
    
}}
    

