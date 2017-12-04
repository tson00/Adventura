/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

/*******************************************************************************
 * Instance třídy PrikazSeber sebere do batohu
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class PrikazSeber implements IPrikaz
{
    private static final String NAZEV = "seber";
    private final HerniPlan plan;
    private final Batoh batoh;
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
        this.batoh=plan.getBatoh();
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
            
            return "Co mám sebrat? Musíš zadat název věci";
        }

        String nazevVeci = parametry[0];

       
        Prostor aktualniProstor = plan.getAktualniProstor();
        // potřebuju i "batoh"
        Vec sbirana = aktualniProstor.odeberVec(nazevVeci);
        if (sbirana == null) {
            return "To tu není!";
        }
        
        else {
           if(sbirana.jePrenositelna()){
               batoh.vlozitVecBatoh(sbirana);
               return "Věc "+sbirana.getNazev()+ " je v batohu";
               //ověřit, zda ji hráč unese a 
               //vložit do batohu nebo vrátit do prostoru
              
               
               
               
               
               
            }
            else{
                
                if(sbirana.jeJeJidlo())
                { aktualniProstor.vlozVec(sbirana);
                return "Věc "+sbirana.getNazev()+" to nemůžeš vzít se sebou se skazí, ale můžeš to sjíst";
                }
                else{
                   
                    
                    
                    
                aktualniProstor.vlozVec(sbirana);
               return "To nezvedneš"; }
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
