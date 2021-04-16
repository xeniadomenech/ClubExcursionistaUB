
package prog2.model;

import java.io.Serializable;
import prog2.vista.ExcepcioClub;
import java.util.ArrayList;


public class LlistaSoci implements InSociList, Serializable{
    private ArrayList<Soci> llista;
    private int size;
    private int index;
    
    /**
    * Constructor de Llista Soci
     * @param size 
    */
    
    public LlistaSoci(int size) {
        this.size = size;
        this.index=0;
        this.llista = new ArrayList<>(size);
    }
    
    
    /**
     * Retorn la mida de l'Arraylist
     * @return la mida
     */
    
    @Override
    public int getSize() {
        return size;
    }
    
    
    /**
    * Retorna fins a quina posicio de l'array hi ha socis
     * @return la posicio maxima on hi ha un soci
    */
    
    public int getIndex() {
        return index;
    }
    
    
    /**
    * Afegeix un soci
     * @param soci
     * @throws ExcepcioClub 
    */

    @Override
    public void addSoci(Soci soci) throws ExcepcioClub {
        if(!isFull()){
            llista.add(soci);
            index++;
        }
        else
            throw new ExcepcioClub("Llista plena"); 
    }

    
    /**
    * Borra un soci
     * @param soci
     * @throws ExcepcioClub 
    */
    
    @Override
    public void removeSoci(Soci soci) throws ExcepcioClub {
        if(!isEmpty()){
            llista.remove(llista.indexOf(soci));
            index--;
        }else
            throw new ExcepcioClub("Llista buida"); 
    }

    
    /**
    * Torna el soci que esta en la posicio indicada
     * @param position
     * @return el soci
     * @throws ExcepcioClub 
    */
    
    @Override
    public Soci getAt(int position) throws ExcepcioClub {
        if(position>=0 && position<=index+1 && !isEmpty())
            return llista.get(position-1);
        else{
            if(isEmpty())
                throw new ExcepcioClub("Cua buida"); 
            else
                throw new ExcepcioClub("La posicio no es correcte"); 
        }
    }

    
    /**
    * Torna un soci indicat
     * @param dni
     * @return el soci
     * @throws ExcepcioClub 
    */
    
    @Override
    public Soci getSoci(String dni) throws ExcepcioClub {
        for (Soci soci : this.llista) {
            if(soci.getDNI().equals(dni))
                return soci;
        }
        throw new ExcepcioClub("No exiteix cap soci amb aquest dni");
    }

    
    /**
     * Borra tota la llista
     * @throws ExcepcioClub 
     */
    
    @Override
    public void clear() throws ExcepcioClub {
        this.llista.clear();
        index=0;
    }

    
    /**
    * Comprova si esta plena la llista
     * @return un booleà que indica si la llista es plena o no
     * @throws ExcepcioClub 
    */
    
    @Override
    public boolean isFull() throws ExcepcioClub {
        return index==size;
    }

    
    /**
    * Comprova si està buida la llista
     * @return un booleà que indica si la llista es buida o no
     * @throws ExcepcioClub 
    */
    
    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return index==0;
    }
    
    /**
    * Comprova si el soci està a la llista
     * @param soci
     * @return un booleà que indica si està a la llista o no
    */
    
    public boolean contains(Soci soci) throws ExcepcioClub{
        for(Soci aux : this.llista){
            if(aux.getDNI().equals(soci.getDNI())){
                return true;
            }
        }
        return false;
    }
    
    
    /**
    * Imprimeix la informacio de la llista
     * @return un String amb tota la informació dels socis
    */
    
    @Override
    public String toString(){
        int i=1;
        String informacioLlista="\nLlista Socis\n=========\n";
        for (Soci soci : this.llista){
            informacioLlista += "[" + i + "] " + soci.toString() + "\n";
            i++;
        }
        return informacioLlista;
    }

} 
