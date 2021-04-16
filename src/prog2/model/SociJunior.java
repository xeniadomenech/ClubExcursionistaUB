package prog2.model;

import prog2.vista.ExcepcioClub;


public class SociJunior extends Soci{

    private final String tipus = "Junior";
    
    /**
    * Constructor de soci junior
     * @param nomComplet
     * @param dni 
    */
    
    public SociJunior(String nomComplet, String dni){
        super(nomComplet, dni);
    }
    
    /**
    * Mètode tipus
     * @return la informació del soci
    */
    
    @Override
    public String toStringInfoSoci(){
        return "";
    }
    
    
    /**
    * Mètode tipus
     * @return el tipus de soci
    */
    
    @Override
    public String toStringTipus(){
        return "Junior";
    }
    
    
    /**
    * Calcula el preu de les excursions del soci federat
     * @param preuExcursioBase
     * @return preu excursions
    */
    
    @Override
    public float calculaPreuExcursio(float preuExcursioBase){
        return 0;
    }
    
    /**
    * Calcula el preu de la quota mensual del soci junior
     * @param quotaBase
     * @return preu quota mensual
     * @throws prog2.vista.ExcepcioClub
    */
    
    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub{
        return quotaBase + calculaPreuExcursio(ClubUB.PREU_EXCURSIO);
        //return quotaBase
    }
}
