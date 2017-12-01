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
public class ObsahBatohu extends VBox implements Observer {

    public IHra hra;

    VBox vbox = new VBox();

    public ObsahBatohu(IHra hra) {

        this.hra = hra;
        hra.getHerniPlan().registerObserver(this);
        init();
    }

    private void init() {

        this.setPadding(new Insets(10));
        this.setSpacing(8);
        Label obsah= new Label("Obsah Batohu: ");
          obsah.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        Image image1 = new Image(getClass().getResourceAsStream("/zdroje/batoh.jpg"),
                10, 10, false, true);
    Button button1= new Button();

        button1.setGraphic(new ImageView(image1));

           this.getChildren().addAll(obsah,button1);
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
