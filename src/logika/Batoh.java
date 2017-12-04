/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;
import java.util.*;

/*******************************************************************************
 * Instance třídy batoh představují misto kam muzete ukladat veci
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2017/2018
 */
public class Batoh
{
    //== Datové atributy (statické i instancí)======================================
private static final int KAPACITA = 20;
private final Map<String, Vec> veci;



    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Batoh()
    {
        veci = new HashMap<>();
     
        
        
    }
    
    /**
     * vejde se vec
     * @return true false
     */
    public boolean vejdeSeVec () {   
        return ( veci.size() < KAPACITA );
    }
    /**
     * vlozit vec v batoh
     * @return true false
     * @param vec
     */
    public boolean vlozitVecBatoh(Vec vec)
    {
       if (vejdeSeVec()){
            veci.put(vec.getNazev(),vec);
            return true;
        }
        return false;
    
    }
    /**
     * vrati vec
     * @return vec
     * @param nazev
     */
   public Vec getVec(String nazev)
   {
    return veci.get(nazev);
    }
    /**
     * popis veci
     * @return nazvy
     */
public String nazvyVeci () {
        int zbyva = KAPACITA - veci.size();
        String nazvy = ": ";
        if (veci.isEmpty()){
            return nazvy + "nic nemáš v batohu";
        }
        nazvy = veci.keySet().stream().map((nazevVeci) -> nazevVeci + " ").reduce(nazvy, String::concat);
        if (zbyva > 0){
        return nazvy + "\n---> můžeš sebrat ještě " + zbyva + " vec(i)";}
        return nazvy + "\n---> batoh už je plný, chceš-li něco přidat, budeš muset vyhodit jinou věc!!";
    }
    /**
     * vyber vec
     * @return nalezena vec null
     * @param nazev
     */
       public Vec vyberVec (String nazev) {
        Vec nalezenaVec ;
        if (veci.containsKey(nazev)) {
          
            
            nalezenaVec = veci.get(nazev);
         
           veci.remove(nazev);
           return nalezenaVec;

        }
        return null;

    }
    /**
     * je tam vec 
     * @return zda je tam ta vec
     * @param nazev
     */
public boolean jeTamVec (String nazev) {
        return veci.containsKey(nazev);

    }
    /**
     * get Veci
     * @return veci
     * 
     */
    public Map<String, Vec> getVeci() {
        return veci;
    }
//== Soukromé metody (instancí i třídy) ========================================

}
