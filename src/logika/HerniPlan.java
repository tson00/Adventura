package logika;

import java.util.*;
import java.util.stream.Collectors;
/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Prostor vyherniProstor;
    private Batoh batoh;
    private boolean najezena=true;
    private boolean schovana=true;
    private Hra hra;
    private Prostor prostor;
    private Map<String,Postava> seznamPostav;
    private Postava postava;

     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     *  @param hra
     */
    public HerniPlan(Hra hra) {
        zalozProstoryHry();
        batoh = new Batoh();
   this.hra=hra;
       

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
     
        Prostor zoo = new Prostor("Zoo","Zoo a chcete dostat domu do džungle");
        Prostor mesto = new Prostor("Mesto", "Město tady musíte tančit");
        Prostor lod = new Prostor("Lod","Lod nezapomente na vestu");
        Prostor plaz = new Prostor("Plaz","Pláž tady je horko");
        Prostor dzungle = new Prostor("Dzungle","Džungle tady je vaši rodina");
        Postava lovec1=new Postava("Lovec1","\nMusíš se schovat!",plaz);
        Postava lovec2=new Postava("Lovec2","\nMusíš se schovat!",mesto);
        Postava lovec3=new Postava("Lovec3","\nMusíš se schovat!",lod);
         Postava lovec4=new Postava("Lovec4","",zoo);
        
    
        zoo.setVychod(mesto);
        mesto.setVychod(lod);
       
        
        lod.setVychod(plaz);
        lod.setVychod(mesto);
        
        plaz.setVychod(dzungle);
     
        
     
       lovec1.pridejProstory(mesto);
         lovec2.pridejProstory(plaz);
           lovec3.pridejProstory(zoo);
             lovec4.pridejProstory(lod);
       
       seznamPostav = new HashMap<String,Postava>();
      
        seznamPostav.put(lovec1.getJmeno(),lovec1);
             seznamPostav.put(lovec2.getJmeno(),lovec2);
                  seznamPostav.put(lovec3.getJmeno(),lovec3);
                       seznamPostav.put(lovec4.getJmeno(),lovec4);
     Vec stul = new Vec("stul",false,false,false);
       Vec lavicka = new Vec("lavicka", false,false,true);
         Vec kos = new Vec("kos", false,false,false);
          Vec strom = new Vec("strom", false,false,true);
           Vec dira = new Vec("dira", false,false,true);
            Vec krovi = new Vec("krovi", false,false,false);
             Vec palma = new Vec("palma", false,false,true);
         
        Vec banan1 =  new Vec("banan1",true,true,false);
          Vec banan2 =  new Vec("banan2",true,true,false);
          Vec banan3 = new Vec("banan3",true,true,false);
        Vec kokos = new Vec ("kokos", false,true,false);
         Vec jablko = new Vec ("jablko", false,true,false);
         Vec houska = new Vec ("houska", false,true,false);
       Vec ananas = new Vec ("ananas", false,true,false);
        Vec jahoda = new Vec ("jahoda", false,true,false);
        Vec paprika = new Vec ("paprika", false,true,false);
      Vec salat = new Vec ("salat", false,true,false);
       Vec chleb = new Vec ("chleb", false,true,false);
  
         Vec lahev = new  Vec("lahev", true,false,false);
         Vec klobasa = new  Vec("vesta", true,false,false);
         Vec sacek = new Vec("sacek",true,false,false);
       
        zoo.vlozVec(banan1);
         zoo.vlozVec(banan2);
         zoo.vlozVec(banan3);
   
        
      zoo.vlozVec(lavicka);
      
        mesto.vlozVec(kos);
         mesto.vlozVec(strom);
         mesto.vlozVec(sacek);
         mesto.vlozVec(jablko);
          mesto.vlozVec(ananas);
          mesto.vlozVec(jahoda);
         
         
        lod.vlozVec(houska);
        lod.vlozVec(klobasa);
         lod.vlozVec(dira);
          lod.vlozVec(krovi);
           lod.vlozVec(paprika);
         
            plaz.vlozVec(kokos);
             plaz.vlozVec(stul);
             plaz.vlozVec(palma);
             plaz.vlozVec(salat);
                  plaz.vlozVec(chleb);
       
           
                
        aktualniProstor = zoo;  
        vyherniProstor = dzungle;
        prostor=zoo;
 
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda vrací odkaz na aktuální postavu
     *
     *@return     postava
     */ 
    
      public Postava getPostava()
    {
    return postava;
    }
 
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
     
    }
      /**
     *  Metoda jeVyhra
     *
     *
     */
    
    public boolean jeVyhra(){
        return aktualniProstor == vyherniProstor;
    }
      /**
     *  Metoda batoh
     *
     *@return batoh
     */
    public Batoh getBatoh()
    {return batoh;
    }
      /**
     *  Metoda najez se
     *
     *
     */
    public void najezSe(){
    this.najezena=true;
    
    }
    
      /**
     *  Metoda hlad
     *
     *
     */
    public void hlad(){
    
        this.najezena=false;
    }
      /**
     *  Metoda najezena
     *
     *
     */
   public boolean getNajezena(){
    return this.najezena;
    }
      /**
     *  Metoda schovana
     *
     *
     */
   public void schovana(){
    this.schovana=true;
    }
      /**
     *  Metoda nechovana
     *
     *
     */
    public void neschovana(){
    this.schovana=false;
    }
      /**
     *  Metoda schovana
     *
     *@return schovana
     */
    public boolean getSchovana(){
    return this.schovana;
    }
  /**
     *  Metoda Hra
     *
     *@return hra
     */
    public Hra getHra()
    {
    return this.hra;
    }
      /**
     *  Metoda prostor
     *
     *@return prostor
     */
    public Prostor getProstor()
    {
    return this.prostor;
    }
      /**
     *  Metoda popis Postav v Prostoru
     *
     *@return vysledek
     */
    public String popisPostavVProstoru() {
        String vysledek = "";
        for (Postava postava : seznamPostav.values()) {
            if (postava.getAktualniProstor() == aktualniProstor) {
                vysledek += " " + postava.getJmeno()+postava.getProslov();
            }
        }
        if (vysledek.length() == 0) {
            vysledek = "Ve prostoru nikdo není";
        }
        else {
            vysledek = "Ve prostoru jsi uviděl postavy:"+vysledek;
        }
        return vysledek;
    }
      /**
     * Metoda popis
     *
     *@return popis
     */
    public String popis(){
    
    return popisPostavVProstoru();
    }
    
    /**
     *  Metoda je postava v Prostory     *
     *@param  jmeno
     *@return true nebo false
     */
     public boolean jePostavaVProstoru(String jmeno) {
        return seznamPostav.containsKey(jmeno)
           && seznamPostav.get(jmeno).getAktualniProstor() == aktualniProstor;
    }
      /**
     *  Metoda vrací postavu
     *  @return null
     *  @return postavu
     *
     *
     */
    public Postava vratPostavuVProstoru(String jmeno) {
        if (jePostavaVProstoru(jmeno)) {
            return seznamPostav.get(jmeno);
        }
        else {
            return null;
        }
    }
      /**
     *  Metoda přesunu postavy
     *
     *
     */
    public void presunPostavy() {
        for (Postava postava : seznamPostav.values()) {
            postava.prejdi();
        }
    }
  

    
}
