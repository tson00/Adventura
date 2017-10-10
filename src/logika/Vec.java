/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;


/*******************************************************************************
 * Instance třída Vec 
 * pro vytvareni veci a jake ma atributy prenositelnost zda je to jidll
 * a zda za ni mozne se schovat
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2016/2017
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;

    private boolean prenositelnost;
    private boolean jejidlo;
    private boolean schovatse;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Vec(String nazev, boolean prenositelnost,
    boolean jejidlo,boolean schovatse)
    {
        this.nazev = nazev;

        this.prenositelnost = prenositelnost;
        this.jejidlo=jejidlo;
        this.schovatse=schovatse;

    }

    //== Nesoukromé metody (instancí i třídy) ======================================
/**
 * vraci nazev
 * @return nazev
 */
    public String getNazev(){
        return nazev;
    }
/**
 * overuje prenositelnost
 * @return prenositelnost
 */
    
    public boolean jePrenositelna(){
        return prenositelnost;
    }
/**
 * overuje zda je to jidlo
 * return je jidlo
 */
    public boolean jeJeJidlo(){
        return jejidlo;
    }
/**
 * zda je mozne schovat se
 * @return schovat se
 */
    public boolean jeSchovatse(){
        return schovatse;
    }

    //== Soukromé metody (instancí i třídy) ========================================
}
