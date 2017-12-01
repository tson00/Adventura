/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logika.IHra;
import utils.Observer;

/**
 *
 * @author acer
 */
public class AktualniVeci extends VBox implements Observer {

    public IHra hra;

    VBox vbox = new VBox();

    public AktualniVeci(IHra hra) {

        this.hra = hra;
        hra.getHerniPlan().registerObserver(this);
        init();
    }

    private void init() {

        this.setPadding(new Insets(10));
        this.setSpacing(8);
        Label akt= new Label("Aktualni veci: ");
          akt.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        Image image1 = new Image(getClass().getResourceAsStream("/zdroje/stul.jpg"), 50, 50, false, true);
        Image image2 = new Image(getClass().getResourceAsStream("/zdroje/lavicka.jpg"), 50, 50, false, true);
        Image image3 = new Image(getClass().getResourceAsStream("/zdroje/kos.jpg"), 50, 50, false, true);
    //    Image image4 = new Image(getClass().getResourceAsStream("/zdroje/strom.jpg"), 5, 5, false, true);
        Image image5 = new Image(getClass().getResourceAsStream("/zdroje/dira.jpg"), 50, 50, false, true);

        /*Image image11 = new Image(getClass().getResourceAsStream("/zdroje/krovi.jpg"), 5, 5, false, true);
        Image image22 = new Image(getClass().getResourceAsStream("/zdroje/palma.jpg"), 5, 5, false, true);
        Image image33 = new Image(getClass().getResourceAsStream("/zdroje/sacek.jpg"), 5, 5, false, true);
        Image image44 = new Image(getClass().getResourceAsStream("/zdroje/banan1.jpg"), 5, 5, false, true);
        Image image55 = new Image(getClass().getResourceAsStream("/zdroje/banan2.jpg"), 5, 5, false, true);

        Image image111 = new Image(getClass().getResourceAsStream("/zdroje/banan3.jpg"), 5, 5, false, true);
        Image image222 = new Image(getClass().getResourceAsStream("/zdroje/kokos.jpeg"), 5, 5, false, true);
        Image image333 = new Image(getClass().getResourceAsStream("/zdroje/jablko.jpg"), 5, 5, false, true);
        Image image444 = new Image(getClass().getResourceAsStream("/zdroje/houska.jpg"), 5, 5, false, true);
        Image image555 = new Image(getClass().getResourceAsStream("/zdroje/ananas.jpg"), 5, 5, false, true);

        Image image1111 = new Image(getClass().getResourceAsStream("/zdroje/jahoda.jpg"), 5, 5, false, true);
        Image image2222 = new Image(getClass().getResourceAsStream("/zdroje/paprika.jpg"), 5, 5, false, true);
        Image image3333 = new Image(getClass().getResourceAsStream("/zdroje/salat.jpg"), 5, 5, false, true);
        Image image4444 = new Image(getClass().getResourceAsStream("/zdroje/chleb.jpg"), 5, 5, false, true);
       */
        
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
   //     Button button4 = new Button();
        Button button5 = new Button();
        
           /*
        Button button11 = new Button();
        Button button22 = new Button();
        Button button33 = new Button();
        Button button44 = new Button();
        Button button55 = new Button();
        
           
        Button button111 = new Button();
        Button button222 = new Button();
        Button button333 = new Button();
        Button button444 = new Button();
        Button button555 = new Button();
        
           
        Button button1111 = new Button();
        Button button2222 = new Button();
        Button button3333 = new Button();
        Button button4444 = new Button();
       
        */

        button1.setGraphic(new ImageView(image1));
        button2.setGraphic(new ImageView(image2));
        button3.setGraphic(new ImageView(image3));
    //    button4.setGraphic(new ImageView(image4));
        button5.setGraphic(new ImageView(image5));
/*        
        button11.setGraphic(new ImageView(image11));
        button22.setGraphic(new ImageView(image22));
        button33.setGraphic(new ImageView(image33));
        button44.setGraphic(new ImageView(image44));
        button55.setGraphic(new ImageView(image55));

        button111.setGraphic(new ImageView(image111));
        button222.setGraphic(new ImageView(image222));
        button333.setGraphic(new ImageView(image333));
        button444.setGraphic(new ImageView(image444));
        button555.setGraphic(new ImageView(image555));

        button1111.setGraphic(new ImageView(image1111));
        button2222.setGraphic(new ImageView(image2222));
        button3333.setGraphic(new ImageView(image3333));
        button4444.setGraphic(new ImageView(image4444));
       
*/
/*
        this.getChildren().addAll(akt,button1, button2, button3, button4, button5,
               button11, button22, button33, button44, button55,
               button111, button222, button333, button444, button555,
               button1111, button2222, button3333, button4444);
        */
           this.getChildren().addAll(akt,button1, button2, button3,  button5);
        update();
    }

    public void newGame(IHra novaHra) {

        hra.getHerniPlan().removeObserver(this);
        hra = novaHra;
        hra.getHerniPlan().registerObserver(this);
        update();

    }

    @Override
    public void update() {
        //  if(hra.getHerniPlan().getAktualniProstor() instanceof prostor)

        //   {}
    }

}
