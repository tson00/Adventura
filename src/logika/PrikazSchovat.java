/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazSchovat. Schova se za vec pokud je to mozny
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class PrikazSchovat implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
private static final String NAZEV = "schovat";
    private final HerniPlan plan;

   private final Prostor prostor;

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     * @param plan plan
     */
    public PrikazSchovat(HerniPlan plan)
    {
        this.plan=plan;

       this.prostor=plan.getProstor();
    }

  
    /**
     * provede prikaz
     * @return text co se deje
     * @param parametry parametry
     */
    
@Override
public String provedPrikaz(String... parametry){

    
    
      if (parametry.length == 0) {
            
            return "Kam se mám schovat, musíš vybrat věc";
        }
        String nazevVeci=parametry[0];
       Prostor aktualniProstor=plan.getAktualniProstor();
        Vec sbirana =aktualniProstor.odeberVec(nazevVeci);
       Postava nalezena=plan.getPostava();
        if(sbirana==null){
            return "To tu není";
        
        }
        else
        {
      
      
          if(sbirana.jeSchovatse())
        { 
            plan.schovana();
            aktualniProstor.vlozVec(sbirana);
       return "Lovec tě nevidí, mužes hrat dal";
            
        
          
       
        }
        else
        {aktualniProstor.vlozVec(sbirana);
       plan.setAktualniProstor(prostor);
       return "Tě chytnul Lovec!!!!! \n"+prostor.dlouhyPopis2();
        }
        
        
        }
        
        
    

  
     
        }
       
        
        /**
         * vrati nazev 
         * @return nazev
         */
        
        
       
        
     @Override
    public String getNazev() {
        return NAZEV;
    }    

}

    //== Soukromé metody (instancí i třídy) ========================================
 

