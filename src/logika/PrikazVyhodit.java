/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 * Instance třídy PrikazVyhodit vyhodi vec do aktualniho prostoru
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class PrikazVyhodit implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
private static final String NAZEV = "vyhodit";

public HerniPlan plan;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     * @param batoh
     * @param plan
     */
    public PrikazVyhodit(Batoh batoh, HerniPlan plan)
    {
        this.plan=plan;
      
    }

/**
 * vraci nazev
 * @return nazev
 */
    //== Nesoukromé metody (instancí i třídy) ======================================
 @Override
 public String getNazev(){
    return NAZEV;}
    /**
     * provede prikazy
     * @return text
     * @param parametry
     * 
     */
 @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            return "Co se má vyhodit? Musíš zadat jméno věci.";
        }
        if (parametry.length >= 2) {
            return "Můžeš vyhodit pouze jednu věc najednou!!";
        }

        String nazev = parametry[0];
        Batoh batoh = plan.getBatoh();

        if (batoh.jeTamVec("buben") && parametry[0].equals("buben")){
            return "Nemůžeš jen tak vyhodit buben! \n";}

        if (batoh.jeTamVec(nazev) ){   

           
            Vec vyhozena=batoh.vyberVec(nazev);
            plan.getAktualniProstor().vlozVec(vyhozena);
         


            return "věc: " + nazev +", jsi právě vyhodil z batohu\n";
           
            
        }

        return "Tato věc v batohu není!! \n";

    }
    //== Soukromé metody (instancí i třídy) ========================================

}
