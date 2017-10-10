/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 * Instance třídy PrikazSeznamVeci veci ktere mas v batohu
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2016/2017
 */
public class PrikazSeznamVeci implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
 private static final String NAZEV = "seznam";
    private HerniPlan plan;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazSeznamVeci(HerniPlan plan)
    {
        this.plan=plan;
    }
        /**
     * provede prikazy
     * @return veci 
     * @param parametry
     */
     @Override
    public String provedPrikaz(String... parametry)
    {
    return plan.getBatoh().nazvyVeci();
    }
    /**
     * vraci nazev
     * @return nazev
     */
      @Override
    public String getNazev() {
    return NAZEV;
    }

    
    
    //== Nesoukromé metody (instancí i třídy) ======================================


    //== Soukromé metody (instancí i třídy) ========================================

}
