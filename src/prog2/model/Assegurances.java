
package prog2.model;

import java.io.Serializable;


public class Assegurances implements Serializable {
    
    private String tipus;
    private int preu;
    
    /**
    * Constructor de assegurances
     * @param tipus
     * @param preu 
    */
    
    public Assegurances(String tipus, int preu) {
        this.tipus = tipus;
        this.preu = preu;
    }
    
    
    //Setters
    
    /**
    * Setter setTipus de
     * @param tipus
    */
    
    public void setTipus(String tipus) {
        this.tipus= tipus;
    }
    
    
    /**
    * Setter setPreu de
     * @param preu
    */
    
    public void setPreu(int preu) {
        this.preu= preu;
    }
    
    
    //Getters
    
    /**
    * Getter getTipus de
     * @return el tipus d'assegurança
    */
    
    public String getTipus() {
        return tipus;
    }
    
    
    /**
    * Getter getPreu de
     * @return preu de l'assegurança
    */
    
    public int getPreu() {
        return preu;
    }
    
    
    /**
    * Retorna la informació de la assegurança
     * @return String amb informació de l'assegurança
    */
    
    @Override
    public String toString(){
        String infoAssegurança = "Assegurança: Tipus=" + tipus + ", Preu="+preu;        
        return infoAssegurança;
    } 
    
}

