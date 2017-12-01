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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logika.IHra;
import utils.Observer;

/**
 *
 * @author acer
 */
public class Prostory extends VBox implements Observer {

    public IHra hra;

    VBox vbox = new VBox();

    public Prostory(IHra hra) {

        this.hra = hra;
        hra.getHerniPlan().registerObserver(this);
        init();
    }

    private void init() {

        this.setPadding(new Insets(10));
        this.setSpacing(8);
        Label vychody= new Label("Vychody: ");
          vychody.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        Image image1 = new Image(getClass().getResourceAsStream("/zdroje/zoo.jpg"), 100, 50, false, true);
        Image image2 = new Image(getClass().getResourceAsStream("/zdroje/mesto.jpg"), 100, 50, false, true);
        Image image3 = new Image(getClass().getResourceAsStream("/zdroje/lod.jpg"), 100, 50, false, true);
        Image image4 = new Image(getClass().getResourceAsStream("/zdroje/plaz.jpg"), 100, 50, false, true);
        Image image5 = new Image(getClass().getResourceAsStream("/zdroje/dzungle.jpg"), 100, 50, false, true);

        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();

        button1.setGraphic(new ImageView(image1));
        button2.setGraphic(new ImageView(image2));
        button3.setGraphic(new ImageView(image3));
        button4.setGraphic(new ImageView(image4));
        button5.setGraphic(new ImageView(image5));

        this.getChildren().addAll(vychody,button1, button2, button3, button4, button5);
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
