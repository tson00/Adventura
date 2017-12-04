package logika;

import java.util.*;
import utils.Subject;
import utils.Observer;
/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 * //herni plan je Subject
 */
public class HerniPlan implements Subject{
    
    private Prostor aktualniProstor;
    private Prostor vyherniProstor;
    private final Batoh batoh;
    private boolean najezena=true;
    private boolean schovana=true;
    private final Hra hra;
    private Prostor prostor;
    private Map<String,Postava> seznamPostav;
    private Postava postava;
    private final List<Observer> listObserveru=new ArrayList<>();
    

     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     *  @param hra hra
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
     
        Prostor zoo = new Prostor("Zoo","Zoo a chcete dostat domu do džungle",10,137);
        Prostor mesto = new Prostor("Mesto", "Město tady musíte tančit",50,137);
        Prostor lod = new Prostor("Lod","Lod nezapomente na vestu",90,137);
        Prostor plaz = new Prostor("Plaz","Pláž tady je horko",130,137);
        Prostor dzungle = new Prostor("Dzungle","Džungle tady je vaši rodina",170,140);
        
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
       
       seznamPostav = new HashMap<>();
      
        seznamPostav.put(lovec1.getJmeno(),lovec1);
             seznamPostav.put(lovec2.getJmeno(),lovec2);
                  seznamPostav.put(lovec3.getJmeno(),lovec3);
                       seznamPostav.put(lovec4.getJmeno(),lovec4);
     Vec stul = new Vec("stul",false,false,false,"/zdroje/stul.jpg");
       Vec lavicka = new Vec("lavicka", false,false,true,"/zdroje/lavicka.jpg");
        // Vec kos = new Vec("kos", false,false,false);
          Vec strom = new Vec("strom", false,false,true,"/zdroje/strom.jpg");
           Vec dira = new Vec("dira", false,false,true,"/zdroje/dira.jpg");
            Vec krovi = new Vec("krovi", false,false,true,"/zdroje/krovi.jpg");
             Vec palma = new Vec("palma", false,false,true,"/zdroje/palma.jpg");
          Vec sacek = new Vec("sacek",true,false,false,"/zdroje/sacek.jpg");
       
        Vec banan1 =  new Vec("banan1",true,true,false,"/zdroje/banan1.jpg");
          Vec banan2 =  new Vec("banan2",true,true,false,"/zdroje/banan2.jpg");
          Vec banan3 = new Vec("banan3",true,true,false,"/zdroje/banan3.jpg");
        Vec kokos = new Vec ("kokos", true,true,false,"/zdroje/kokos.jpeg");
         Vec jablko = new Vec ("jablko", true,true,false,"/zdroje/jablko.jpg");
         Vec houska = new Vec ("houska", true,true,false,"/zdroje/houska.jpg");
       Vec ananas = new Vec ("ananas", true,true,false,"/zdroje/ananas.jpg");
        Vec jahoda = new Vec ("jahoda", true,true,false,"/zdroje/jahoda.jpg");
        Vec paprika = new Vec ("paprika", true,true,false,"/zdroje/paprika.jpg");
      Vec salat = new Vec ("salat", true,true,false,"/zdroje/salat.jpg");
       Vec chleb = new Vec ("chleb", true,true,false,"/zdroje/chleb.jpg");
  
         
        
        
        zoo.vlozVec(banan1);
         zoo.vlozVec(banan2);
         zoo.vlozVec(banan3);
   
        
      zoo.vlozVec(lavicka);
      

         mesto.vlozVec(strom);
         mesto.vlozVec(sacek);
         mesto.vlozVec(jablko);
          mesto.vlozVec(ananas);
          mesto.vlozVec(jahoda);
         
         
        lod.vlozVec(houska);
      
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
     * notify observers
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
       notifyObservers();
     
    }
      /**
     *  Metoda jeVyhra
     *@return aktualniProstor vyherniProstor
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
     *nastavi true
     */
    public void najezSe(){
    this.najezena=true;
    
    }
    
      /**
     *  Metoda hlad
     *nastavi false
     *
     */
    public void hlad(){
    
        this.najezena=false;
    }
      /**
     *  Metoda najezena
     *
     *@return najezena
     */
   public boolean getNajezena(){
    return this.najezena;
    }
      /**
     *  Metoda schovana
     *schovana true
     *
     */
   public void schovana(){
    this.schovana=true;
    }
      /**
     *  Metoda nechovana
     *necshovana false
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
        vysledek = seznamPostav.values().stream().filter((P) -> (P.getAktualniProstor() == aktualniProstor)).map((p) -> " " + p.getJmeno()+p.getProslov()).reduce(vysledek, String::concat);
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
     *@return popisPostavVProstoru
     */
    public String popis(){
    
    return popisPostavVProstoru();
    }
    
    /**
     *  Metoda je postava v Prostory     *
     *@param  jmeno jmeno
     *@return true nebo false
     */
     public boolean jePostavaVProstoru(String jmeno) {
        return seznamPostav.containsKey(jmeno)
           && seznamPostav.get(jmeno).getAktualniProstor() == aktualniProstor;
    }
      /**
     *  Metoda vrací postavu
     * @param jmeno jmeno
     *  @return null postava
     * 
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
     *presun postavy
     *
     */
    public void presunPostavy() {
        seznamPostav.values().forEach((p) -> {
            p.prejdi();
        });
    }
   /**
     *  
     *register observer
     *
     * @param observer observer
     */
    @Override
   
    public void registerObserver(utils.Observer observer) {
        listObserveru.add(observer);
    }
   /**
     *  
     *removeObserver
     *
     * @param observer observer
     */
    @Override
   
    public void removeObserver(utils.Observer observer) {
       listObserveru.remove(observer);
               }
      /**
     *notify Observer
     *
     */
    @Override

    public void notifyObservers() {
        listObserveru.forEach((listObserveruItem) -> {
            listObserveruItem.update();
        });
      
    }
  

    
}
