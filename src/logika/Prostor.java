package logika;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class Prostor {

    private final String nazev;
    private final String popis;
    private final Set<Prostor> vychody; 

    private final Map<String,Vec> veci;
    private HerniPlan plan;
    private final double posLeft;
    private final double posTop;
    
 
    /**
     * Vytvoření prostoru se zadaným popisem, např. "Zoo", "Město", "Pláž"
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     * @param posTop
     * @param posLeft
     */
    public Prostor(String nazev, String popis, double posTop,double posLeft) {
        this.nazev = nazev;
        this.popis = popis;
        this.posLeft=posLeft;
        this.posTop=posTop;
       
        vychody = new HashSet<>();
        veci = new HashMap<>();
       
    
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
    @Override
    public boolean equals(Object o) {
      
        if (this == o) {
            return true;
        }
        
        if (!(o instanceof Prostor)) {
            return false;  
        }
     
        Prostor druhy = (Prostor) o;

      

        return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     * @return 
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + popis + ".\n"
        + popisVychodu()+ "\n"
        + popisVeci()+"\n"+"Na začatku hry nepotřebuješ od Lovce schovavat\n";
    }
    /**
     * Vrací "dlouhý" popis prostoru
     *
     * @return Dlouhý popis2 prostoru
     */
     public String dlouhyPopis2() {
        return "Jsi v mistnosti/prostoru " + popis + ".\n"
        + popisVychodu()+ "\n"
        + popisVeci();
    }
    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: Měst ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "východy:";
        vracenyText = vychody.stream().map((sousedni) -> " " + sousedni.getNazev()).reduce(vracenyText, String::concat);
        return vracenyText;
    }
/**
 * metoda popis veci
 * @return vracenytext
 */
    private String popisVeci(){
     
        String vracenyText = "Věci: ";
        vracenyText = veci.keySet().stream().map((nazevVeci) -> " " + nazevVeci).reduce(vracenyText, String::concat);
        return vracenyText;
        
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
            .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
        .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /**
     * metoda vloz vec
     * @return true false
     * @param neco
     */
    public boolean vlozVec(Vec neco){
        if(veci.containsKey(neco.getNazev())){
            return false;
        }
        else{
            veci.put(neco.getNazev(),neco);
            return true;
        }
    }
    /**
     * metoda je v Prostoru
     * @param nazev
     * @return obsahuje nazev 
     * 
     */
    public boolean jeVecVProstoru(String nazev){
        return veci.containsKey(nazev);
    }
    
    
/**
 * metoda odeber Vec
 * @param nazev
 * @return smaze vec
 */
    public Vec odeberVec(String nazev){
        return veci.remove(nazev);
    }

    /**
     * @return the posLeft
     */
    public double getPosLeft() {
        return posLeft;
    }

    /**
     * @return the posTop
     */
    public double getPosTop() {
        return posTop;
    }
    
     /**
     * @return the vracenyText
     */
    

 public String seznamVychoduProPanely() 
    {
        String vracenyText = "vychody:";
        vracenyText = vychody.stream().map((sousedni) -> " " + sousedni.getNazev()).reduce(vracenyText, String::concat);
        return vracenyText;
    }
  /**
     * @return the veci
     */
 
   public Map<String,Vec> getVeci()
     {
         return this.veci;
     }
}
