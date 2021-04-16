
package prog2.model;

import java.io.Serializable;


public class Federacio implements Serializable {
    
    private String nom;
    private int preu;
    
    /**
    * Constructor de federacio
     * @param nom
     * @param preu 
    */
    public Federacio(String nom, int preu) {
        this.nom = nom;
        this.preu = preu;
    }
    
    //Setters
    /**
    * Setter setNom de
     * @param nom
    */
    
    public void setNom(String nom) {
        this.nom = nom;
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
    * Getter getNom de
     * @return el nom de la federació
    */
    
    public String getNom() {
        return nom;
    }
    
    
    /**
    * Getter getPreu de
     * @return preu de la federació
    */
    
    public int getPreu() {
        return preu;
    }
    
    
    /**
    * Retorna la informació de la federació
     * @return String amb informació de la federació
    */
    
    @Override
    public String toString(){
        String infoFederació = "Federació: Nom=" + nom + ", Preu= " + preu;        
        return infoFederació;
    }
    
}
