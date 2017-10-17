/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;
import java.util.*;
import java.util.stream.Collectors;

/*******************************************************************************
 * Instance třídy batoh představují misto kam muzete ukladat veci
 *
 *@author     Tsoy Nadezhda
 *@version    pro školní rok 2016/2017
 */
public class Batoh
{
    //== Datové atributy (statické i instancí)======================================
private static final int KAPACITA = 3;
private Map<String, Vec> veci;



    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Batoh()
    {
        veci = new HashMap<String, Vec>();
     
        
        
    }
    
    /**
     * vejde se vec
     * @return true false
     */
    public boolean vejdeSeVec () {   
        if (( veci.size() < KAPACITA ) ){
            return true;
        }
        return false;
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
        for (String nazevVeci : veci.keySet()){

            nazvy += nazevVeci + " " ;
        }
        if (zbyva > 0){
        return nazvy + "\n---> můžeš sebrat ještě " + zbyva + " vec(i)";}
        return nazvy + "\n---> batoh už je plný, chceš-li něco přidat, budeš muset vyhodit jinou věc!!";
    }
    /**
     * vyber vec
     * @return nalezena vec
     * @return null
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
//== Soukromé metody (instancí i třídy) ========================================

}
