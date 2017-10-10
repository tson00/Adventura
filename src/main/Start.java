/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package main;


import logika.*;
import uiText.TextoveRozhrani;

/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2016/2017
 */
public class Start
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {

        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        if(args.length == 0){
            ui.hraj();
        }
        else{
           
            ui.hrajZeSouboru(new java.io.File(args[0]));
        }
    }
}
