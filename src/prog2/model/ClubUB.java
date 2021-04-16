
package prog2.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import prog2.vista.ExcepcioClub;

public class ClubUB implements Serializable{
    static final int PREU_EXCURSIO=20;
    static final int QUOTA_MENSUAL=25;
    static final float DESC_EXCURSIO=0.2f;
    static final float DESC_MENSUAL=0.3f;
    
    private String nom;
    private Soci soci;
    private LlistaSoci llista;
    
    File fitxer = new File("clubUB.dat"); 

    /**
    * Constructor de clubUB
     * @param nom
     * @param size 
    */
    
    public ClubUB(String nom, int size) {
        this.nom=nom;
        this.llista = new LlistaSoci(size);
    }

    
    //GETTER
    
    /**
    * Getter de nom
     * @return el nom del club
    */
    
    public String getNom() {
        return nom;
    }

    
    //SETTER
    
    /**
    * Setter de nom
     * @param nom 
    */
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    //OPCIO 1 DEL MAIN
    
    /**
    * Dona d'alta un soci Federat
     * @param nomComplet
     * @param dni
     * @param federacio
     * @param preu
     * @throws ExcepcioClub 
    */
    
    public void donarAltaFederat(String nomComplet, String dni, String federacio, int preu) throws ExcepcioClub{
        soci = new SociFederat (nomComplet, dni, federacio, preu);
        if(!llista.contains(soci))
            llista.addSoci(soci);
        else
            throw new ExcepcioClub ("El dni esta repetit");
    }
    
    /**
    * Dona d'alta un soci estandard
     * @param nomComplet
     * @param dni
     * @param tipusAsseg
     * @param preu
     * @throws ExcepcioClub 
    */
    
    public void donarAltaEstandard(String nomComplet, String dni, String tipusAsseg, int preu) throws ExcepcioClub{
        soci = new SociEstandard (nomComplet, dni, tipusAsseg, preu);
        if(!llista.contains(soci))
            llista.addSoci(soci);
        else
            throw new ExcepcioClub ("El dni esta repetit");

    }
    
    /**
    * Dona d'alta un soci junior
     * @param nomComplet
     * @param dni
     * @throws ExcepcioClub 
    */
    
    public void donarAltaJunior(String nomComplet, String dni) throws ExcepcioClub{
        soci = new SociJunior (nomComplet, dni);
        if(!llista.contains(soci))
            llista.addSoci(soci);
        else
            throw new ExcepcioClub ("El dni esta repetit.");

    }
    
    
    //OPCIO 2 DEL MAIN
    
    /**
    * Mostra la llista de socis
     * @return un String amb la llista de socis
    */
    
    public String mostraLlista(){
        return llista.toString();
    }
    
    
    //OPCIO 3 DEL MAIN
    
    /**
    * Elimina un soci concret
     * @param posicio
     * @throws ExcepcioClub 
    */
    
    public void eliminaSoci(int posicio) throws ExcepcioClub{
        if(llista.contains(llista.getAt(posicio))){
            llista.removeSoci(llista.getAt(posicio));
        }else
            throw new ExcepcioClub("Posicio erronia."); 
    }
    
    
    //OPCIO 4 DEL MAIN
    
    /**
    * Calcula la factura d'un soci
     * @param dni
     * @param excursions
     * @return 
     * @throws prog2.vista.ExcepcioClub 
    */
    
    public float calcularFactura(String dni, int excursions) throws ExcepcioClub{
        float factura;
        factura = llista.getSoci(dni).calculaPreuExcursio(PREU_EXCURSIO)*excursions +
                llista.getSoci(dni).calculaQuota(QUOTA_MENSUAL);
        return factura;
    }
    
    
    //OPCIO 5 MENU
    
    /**
    * Modifica el nom d'un soci
     * @param dni
     * @param nomComplet
     * @return
     * @throws ExcepcioClub 
    */
    
    public String modificarNom(String dni, String nomComplet) throws ExcepcioClub{
        String reanomenem = llista.getSoci(dni).getNom();
        
        llista.getSoci(dni).setNom(nomComplet);
        
        reanomenem += " s'ha modificat a " + llista.getSoci(dni).getNom();
        return reanomenem;
    }
    
    
    //OPCIO 6 MENU
    
    /**
    * Modifica l'assegurança d'un soci estandard
     * @param dni
     * @param tipusAsseg
     * @return
     * @throws ExcepcioClub 
    */
    
    public String modificarAsseg(String dni) throws ExcepcioClub{
        if(!llista.getSoci(dni).toStringTipus().equals("Estandard")){
            throw new ExcepcioClub("Error en el tipus de soci."); 
        }
        SociEstandard aux = (SociEstandard) this.llista.getSoci(dni);
        String canviAsseg = aux.getTipusAsseg();
        if(canviAsseg.equals("Basica")){
            aux.setTipusAsseg("Completa");
        }else if(canviAsseg.equals("Completa")){
            aux.setTipusAsseg("Basica");
        }else{
            throw new ExcepcioClub("Error en el tipus d'assegurança."); 
        }
        
        canviAsseg += " s'ha modificat a " + aux.getTipusAsseg();
        return canviAsseg;
    }
    
    
    //OPCIO 7 MENU
    
    /**
    * Guarda la informacio de la llista en un fitxer
     * @throws FileNotFoundException
     * @throws IOException 
    */
    
    public void guardemInformacio() throws FileNotFoundException, IOException{
        FileOutputStream fout= new FileOutputStream("clubUB.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this);
        oos.close();
    }
    
    
    //OPCIO 8 MENU
    
    /**
    * Carrega la informacio d'una llista de socis d'un fitxer
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
    */
    
    public static ClubUB carregarInformacio() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fin=new FileInputStream("clubUB.dat");
        ObjectInputStream ois = new ObjectInputStream(fin);
        
        ClubUB club = null;
        
        club = (ClubUB) ois.readObject();
        ois.close();
        return club;
    }
    
}
