/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logika.HerniPlan;
import utils.Observer;


/**
 * Panel zobrazující list s východy uprostřed
 *
 * @author Tsoy Nadezhda
 */

public class PanelVychody implements Observer
{

    private HerniPlan plan;
    ListView<String> list;
    ObservableList<String> data;
    
    private TextArea centralText;
    private TextField zadejPrikazTextArea;

     /**
     * Konstruktor, který inicializuje panel, zaregistruje ho jako pozorovatele
     * u herního plánu
     *
     * @param plan herní plán
     */
    
   public PanelVychody(HerniPlan plan, TextArea text,TextField field)
      {
        this.plan = plan;
        plan.registerObserver(this);

        centralText = text;
        zadejPrikazTextArea = field;
        
        init();
      }

    /**
     * Metoda pro inicializaci komponent kliknutí mýši v panelu.
     */
    
    private void init()
      {
        list = new ListView<>();
        data = FXCollections.observableArrayList();
        list.setItems(data);
        list.setPrefSize(100, 100);
        
        list.setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override
            public void handle(MouseEvent click)
            {
                if (click.getClickCount() == 2) 
                {
                    String vstupniPrikaz = "jdi "+list.getSelectionModel().getSelectedItem();
                    String odpovedHry = plan.getHra().zpracujPrikaz("jdi "+list.getSelectionModel().getSelectedItem());

                getCentralText().appendText("\n"+vstupniPrikaz + "\n");
                getCentralText().appendText("\n"+odpovedHry + "\n");
            //    zadejPrikazTextArea.setText("");
                    
                    if (plan.getHra().konecHry()) 
                    {
                    zadejPrikazTextArea.setEditable(false);
                    centralText.appendText(plan.getHra().vratEpilog());
                    }
                    
                    
                    plan.notifyObservers();
                }
            }
        });
        update();
      }

    public ListView<String> getList()
      {
        return list;
      }

    /**
     * metoda pro aktulizaci panelu 
     */
    
    @Override
    public void update()
      {
        String vychody = plan.getAktualniProstor().seznamVychoduProPanely();
        data.clear();
        String[] oddeleneVychody = vychody.split(" ");
        for (int i = 1; i < oddeleneVychody.length; i++) {
            data.add(oddeleneVychody[i]);
        }
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

   public TextArea getCentralText() {
        return centralText;
    }
}
