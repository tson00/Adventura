/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazSnist sni jidlo a smaze z prostoru
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2016/2017
 */
public class PrikazSnist implements IPrikaz
{
    private static final String NAZEV = "snist";
     private HerniPlan plan;

   private Prostor prostor;

  
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazSnist(HerniPlan plan) {
        this.plan = plan;
    
     this.prostor=plan.getAktualniProstor();
    
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            
            return "Co mám sníst?";
        }

        String nazevVeci = parametry[0];

       
        Prostor aktualniProstor = plan.getAktualniProstor();
        // potřebuju i "batoh"
        Vec sbirana = aktualniProstor.odeberVec(nazevVeci);
        if (sbirana == null) {
            return "To tu není!"+"možná máte něco v batohu\n použijte přikaz: seznam";
        }
        
        else {
            
            
           if(sbirana.jeJeJidlo()){
               if(plan.getNajezena()){
                   
                aktualniProstor.vlozVec(sbirana);
                return "Už jste najedená";
                
                }else
                {
                    plan.najezSe();
              return "Jidlo "+sbirana.getNazev()+ " jsi snedl(a)";
                
                
                }
        
            }
            else{
                
               
                aktualniProstor.vlozVec(sbirana);
                return "Věc "+sbirana.getNazev()+" to nemůžeš sjíst";
       
            }
        }
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
