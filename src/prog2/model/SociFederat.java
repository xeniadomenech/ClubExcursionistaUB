package prog2.model;

import prog2.vista.ExcepcioClub;


public class SociFederat extends Soci{
    
    private Federacio federacio;
    
    
    private final String tipus = "Federat";
    
    /**
    * Constructor de soci federat
     * @param nomComplet
     * @param dni
     * @param tipusFederacio
     * @param preu
     * @throws prog2.vista.ExcepcioClub
    */
    public SociFederat(String nomComplet, String dni, String tipusFederacio, int preu) throws ExcepcioClub{
        super(nomComplet, dni);
        this.federacio = new Federacio(tipusFederacio, preu);
        
        if(federacio.getPreu() < 100){
            throw new ExcepcioClub("El preu de la federació no és correcte.");
            
        }
    }

    
    /**
    * Mètode tipus
     * @return la informació de la federació del soci
    */
    
    @Override
    public String toStringInfoSoci(){
        return federacio.toString();
    }
    
    
    /**
    * Mètode tipus
     * @return el tipus del soci
    */
    
    @Override
    public String toStringTipus(){
        return "Federat";
    }
    
    
    /**
    /* Calcula el preu de les excursions del soci federat
     * @return preu excursions
    */
    
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{
        return preuExcursioBase*(1-ClubUB.DESC_EXCURSIO);
    }
    
    
    /**
    /* Calcula el preu de la quota mensual del soci federat
     * @return preu quota mensual
    */
    
    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub{
        return quotaBase*(1-ClubUB.DESC_MENSUAL);
    }
}

