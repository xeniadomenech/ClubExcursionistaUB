package prog2.model;

import prog2.vista.ExcepcioClub;

/**
 *
 * 
 */
public class SociEstandard extends Soci {

    private Assegurances assegurança;
    
    
    private final String tipus = "Estandard";
    
    
    /**
    * Constructor de Soci Estandard
     * @param nomComplet
     * @param dni
     * @param tipusAsseg
     * @param preu
     * @throws prog2.vista.ExcepcioClub
    */
    
    public SociEstandard(String nomComplet, String dni, String tipusAsseg, int preu) throws ExcepcioClub{
        super(nomComplet, dni);
        
        this.assegurança = new Assegurances(tipusAsseg, preu);
        
        if (!"Basica".equals(assegurança.getTipus()) && !"Completa".equals(assegurança.getTipus())){
            throw new ExcepcioClub("El tipus d'assegurança no és correcte.");
        }
    }
    

    /**
    * Mètode tipus
     * @return la informació de l'assegurança del soci
    */
    
    @Override
    public String toStringInfoSoci(){
        return assegurança.toString();
    }
    
    
     /**
    * Mètode tipus
     * @return el tipus de soci que tenim
    */
    
    @Override
    public String toStringTipus(){
        return "Estandard";
    }
    
    
    /**
    * Mètode modifica el tipus d'assegurança
     * @return el tipus d'assegurança
    */
    
    public String getTipusAsseg(){
        return assegurança.getTipus();
    }
    
    
    /**
    * Mètode modifica el tipus d'assegurança
     * @param tipus
    */
    
    public void setTipusAsseg(String tipus){
        assegurança.setTipus(tipus);
    }
    
    
    /**
    * Calcula el preu de les excursions del soci estandard
     * @param preuExcursioBase
     * @return preu excursions
     * @throws prog2.vista.ExcepcioClub
    */
    
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{
        return preuExcursioBase + assegurança.getPreu();
    }
    
    
    /**
    * Calcula el preu de la quota mensual del soci estàndar
     * @param quotaBase
     * @return preu quota mensual
     * @throws prog2.vista.ExcepcioClub
    */
    
    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub{
        return quotaBase;
    }
    
}

