/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import logika.IHra;
import main.Main;
import utils.Observer;

/*******************************************************************************
 * Instance třídy Mapa po ktere jde tečka
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class Mapa extends AnchorPane implements Observer {
  public IHra hra;
  private Circle tecka;

  /****  
  *
  * @param hra hra
  */
  public Mapa(IHra hra){
   
  this.hra=hra;
  hra.getHerniPlan().registerObserver(this);
  init();
  }    
  
  /**
   * init
   */
  
  private void init(){
    

        ImageView obrazekImageView= new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/mapa.png"), 200,200,false,true) );
        tecka= new Circle(9, Paint.valueOf("red"));
    
       
        this.getChildren().addAll(obrazekImageView,tecka);
        
       update();
       
  
  }
  /***
   * 
   * @param novaHra nova Hra
   */
  public void newGame(IHra novaHra){
      hra.getHerniPlan().removeObserver(this);
      hra=novaHra;
      hra.getHerniPlan().registerObserver(this);
      update();
      
  
  
  }
  
  /****
   * update
   */

    @Override
    public void update() {
        Mapa.setTopAnchor(tecka, hra.getHerniPlan().getAktualniProstor().getPosTop());
        Mapa.setLeftAnchor(tecka, hra.getHerniPlan().getAktualniProstor().getPosLeft());
    
        
    }
    
    
    }

