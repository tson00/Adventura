/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

import java.util.*;

/*******************************************************************************
 * Instance třídy Postava představují popis postavy
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class Postava
{
    //== Datové atributy (statické i instancí)======================================
private final String jmeno;
private final String proslov;
private Prostor aktualniProstor;
private final List<Prostor> prostory;

//private Prostor aktualniProstor;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     * @param jmeno
     * @param proslov
     * @param pocatecni
     */
    public Postava(String jmeno,String proslov,Prostor pocatecni)
    {
        this.jmeno=jmeno;
        this.proslov=proslov;
      aktualniProstor=pocatecni;
      prostory=new ArrayList<>();
        
       
    }
    

    //== Nesoukromé metody (instancí i třídy) ======================================
/**
 * vraci jmeno
 * @return jmeno
 */
public String getJmeno(){
return jmeno;
}
/**
 * vraci proslov 
 * @return proslov
 */
public String getProslov(){
return proslov;
}

/**
 * vraci aktualni prostor
 * @return prostor
 */
public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    /**
     * nastavi prostor
     * @param prostor
     */
public void setAktualniProstor(Prostor prostor){
aktualniProstor=prostor;
}
/**
 * prida prostor 
     * @param dalsiProstory
 */
public void pridejProstory(Prostor...dalsiProstory){
prostory.addAll(Arrays.asList(dalsiProstory));
}
/**
 * prejdi
 */
public void prejdi() {
         if (! prostory.isEmpty()) {
             Collections.shuffle(prostory); // náhodné setřídění
             aktualniProstor = prostory.get(0);
         }
     }
     
     

}
    //== Soukromé metody (instancí i třídy) ========================================


