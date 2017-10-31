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

/**
 *
 * @author acer
 */
public class Mapa extends AnchorPane implements Observer {
  public IHra hra;
  private Circle tecka;
 // private double posTop=0.0;
 // private double posLeft=0.0;
  public Mapa(IHra hra){
  
  this.hra=hra;
  hra.getHerniPlan().registerObserver(this);
  init();
  }    
  private void init(){
    

        ImageView obrazekImageView= new ImageView(new Image(Main.class.getResourceAsStream("/zdroje/mapa.png"), 200,200,false,true) );
        tecka= new Circle(10, Paint.valueOf("red"));
     //   this.setTopAnchor(tecka,posTop);
     //    this.setLeftAnchor(tecka,posLeft);
       
        this.getChildren().addAll(obrazekImageView,tecka);
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
        this.setTopAnchor(tecka, hra.getHerniPlan().getAktualniProstor().getPosTop());
        this.setTopAnchor(tecka, hra.getHerniPlan().getAktualniProstor().getPosLeft());
        
    }
    
    
    }

