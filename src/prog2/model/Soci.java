package prog2.model;

import java.io.Serializable;
import prog2.vista.ExcepcioClub;


public abstract class Soci implements InSoci, Serializable{
    private String nom;
    private String dni;

    /**
    * Constructor de soci
     * @param nom
     * @param dni 
    */
    
    public Soci(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }
    
    //Setters
    
    /**
    * Setter setNom de
     * @param nom
    */
    
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    /**
    * Setter setDNI de
     * @param dni
    */
    
    @Override
    public void setDNI(String dni) {
        this.dni = dni;
    }
    
    //Getters

    /**
    * Getter getNom de
     * @return el nom del soci
    */
    @Override
    public String getNom() {
        return nom;
    }
    

    /**
    * Getter getDNI de
     * @return el DNI del soci
    */
    
    @Override
    public String getDNI() {
        return dni;
    }

    
    /**
    * Calcula el preu de la quota d'un soci
     * @return preu quota soci
     * @throws prog2.vista.ExcepcioClub
    */
    
    @Override
    public abstract float calculaQuota(float quotaBase) throws ExcepcioClub;

    
    /**
    * Calcula el preu de les excursions que ha fet un soci
     * @return preu excursions soci
     * @throws prog2.vista.ExcepcioClub
    */
    
    @Override
    public abstract float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub;
    
    
    /**
    * Indica si el soci donat per paràmetre coincideix amb el que utilitza el mètode
     * @param soci
     * @return boolean si el soci té el mateix dni
    */
    
    public boolean equals(Soci soci){
        return this.dni.equals(soci.getDNI());
    }
    
    public abstract String toStringInfoSoci();
    public abstract String toStringTipus();
   
    
    /**
    * toString de la informació del soci
     * @return un String amb la informació ordenada del soci 
    */
    
    @Override
    public String toString(){
        String infoSoci = "Nom=" + this.nom + ", DNI=" + this.dni + ". " +
                toStringInfoSoci();
        return infoSoci;
    }
    
}
