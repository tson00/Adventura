/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logika.HerniPlan;
import logika.Vec;
import utils.Observer;

/**
 * Panel zobrazující list s věci, které muzes snist
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */


public class PanelVeci implements Observer{
    
    private HerniPlan plan;
    ListView<Object> list;
    ObservableList<Object> data;
    private final TextArea centralText;

    /**
     * konstruktur
     *
     * @param plan
     * @param text
     */
    
    
    public PanelVeci(HerniPlan plan, TextArea text) {
       this.plan = plan;
       plan.registerObserver(this);
       
       centralText = text;
        init();
    }

     /**
     * Metoda pro inicializaci komponent kliknutí mýši v panelu.
     */
    
    
    private void init() {
        
      
        list = new ListView<>();
        data = FXCollections.observableArrayList();
       list.setItems(data);
        list.setPrefSize(150, 200);
        
        
        list.setOnMouseClicked((MouseEvent click) -> {
            if (click.getClickCount() == 2)
            {
                int index = list.getSelectionModel().getSelectedIndex(); 
                
                Map<String, Vec> seznam;
                seznam = plan.getAktualniProstor().getVeci();
                
                String nazev = "";
                int pomocna = 0;
                for (String x : seznam.keySet())
                {
                    if(pomocna == index) 
                    {
                        if(seznam.get(x).jeJeJidlo())
                        {
                            
                            
                            nazev = x;
                        }
                        else
                        {pomocna--;}
                        
                    }
                    pomocna++;
                }
                
                String vstupniPrikaz = "snist "+nazev;
                String odpovedHry = plan.getHra().zpracujPrikaz("snist "+nazev);
                
                
                centralText.appendText("\n" + vstupniPrikaz + "\n");
                centralText.appendText("\n" + odpovedHry + "\n");
                
                plan.notifyObservers();
            }
        });
        
        
        
        
        update();
    }
    
    /*
    * Metoda vrací list.
    */
    public ListView<Object> getList() {
        return list;
    }

    /**
     * metoda pro aktulizaci panelu
     */
    
    @Override 
    public void update() 
    {        
        Map<String, Vec> seznam;
        seznam = plan.getAktualniProstor().getVeci();
        data.clear();
        seznam.keySet().stream().map((x) -> seznam.get(x)).filter((pomocna) -> (pomocna.jeJeJidlo())).map((pomocna) -> new ImageView(new Image(main.Main.class.getResourceAsStream(pomocna.getObrazek()), 60, 60, false, false))).forEachOrdered((obrazek) -> {
            data.add(obrazek);
        });
    }
    
    /**
     * Metoda zaregistruje pozorovatele k hernímu plánu při spuštění nové hry.
     * @param plan
     */
    public void nastaveniHernihoPlanu (HerniPlan plan){
        this.plan = plan;
        plan.registerObserver(this);
        this.update();
    }
}