/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import logika.IHra;
import main.Main;
import utils.Observer;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author acer
 */
public class Batoh extends AnchorPane implements Observer {
      public IHra hra;
              BorderPane borderPane = new BorderPane();

       
        public Batoh(IHra hra){
  
  this.hra=hra;
  hra.getHerniPlan().registerObserver(this);
  init();
  }
        private void init(){
    

        ImageView obrazekImageView= new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/batoh.jpg"), 200,200,false,true) );
         
         Button button1 =new Button();
     Button button2 =new Button();
      Button button3 =new Button();
       Button button4 =new Button();
        Button button5 =new Button();
       
     //   this.setTopAnchor(tecka,posTop);
     //    this.setLeftAnchor(tecka,posLeft);
       
    //    this.getChildren().addAll(obrazekImageView,button1,button2,button3,button4,button5);
          this.getChildren().addAll(button1,button2,button3,button4,button5);
       
        
        
        update();
  
  }
        public void newGame(IHra novaHra){
      hra.getHerniPlan().removeObserver(this);
      hra=novaHra;
      hra.getHerniPlan().registerObserver(this);
      update();
      
  
  
  }
       

    @Override
    public void update() {
      //veci z batohu  this.setTopAnchor(tecka, hra.getHerniPlan().getAktualniProstor().getPosTop());
        //this.setLeftAnchor(tecka, hra.getHerniPlan().getAktualniProstor().getPosLeft());
    }
    
}
