
package prog2.vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import prog2.model.ClubUB;

public class VistaClubUB {
    
    private ClubUB club;
    
    /* Constructor de la Vista*/
    /**
    * Constructor de Vista Club UB
     * @param nomClub
     * @param size
    */
    public VistaClubUB(String nomClub, int size) {
        this.club = new ClubUB(nomClub, size);
    }
    
    /**
    * Escriu les opcions del menu
     * @return 
    */

    public static String[] getDescMenu() {
        return descMenu;
    }
    
    /**
    * Inicialitza el scanner
    */
    
    public void gestioClubUB() {
        try {
            // Creació d'un objete per llegir l'input des del teclat
            Scanner sc = new Scanner(System.in);
            // Cridar a la funció que gestiona el menu
            gestioMenu(sc);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /* ******************************************** */
    /* Gestió, Opcions i Descripció del Menu (M) */
    /* ******************************************** */
   
    /**
    * Enumera les opcions del menu
    */
    private static enum OpcionesMenu {
        M_Opcion_1_DonarAltaNouSoci,
        M_Opcion_2_MostrarLlistaSocis,
        M_Opcion_3_EliminarSoci,
        M_Opcion_4_MostrarFactura,
        M_Opcion_5_ModificarNomSoci,
        M_Opcion_6_ModificarTipusAssegurançaSoci,
        M_Opcion_7_GuardarLlista,
        M_Opcion_8_RecuperarLlista,
        M_Opcion_9_Sortir
    };
    
    /**
    * Dona les descripcions de les opcions del menú principal
    */
    
    private static final String[] descMenu = {
        "Donar d'alta un nou soci", // Opcion 1
        "Mostrar llista socis",  // Opcion 2
        "Eliminar soci",  // Opcion 3
        "Mostrar factura",  // Opcion 4
        "Modificar nom soci",  // Opcion 5
        "Modificar tipus assegurança soci",  // Opcion 6
        "Guardar llista",  // Opcion 7
        "Recuperar llista",  // Opcion 8
        "Sortir",  // Opcion 9
    };
    
    /**
    * Gestiona el menu
     * @param sc
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
    */
   
    public void gestioMenu(Scanner sc) throws FileNotFoundException, ClassNotFoundException {
        
        // Creació de l'objeto que representa el menú. El primer argument del constructor és el nom del menu
        Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + club.getNom(), OpcionesMenu.values());
        
        menuEstacio.setDescripcions(descMenu);
        
        // Variable (de tipus enumerat igual a les opcions del menú) que contié l'opció triada
        OpcionesMenu opcionMenu;

        //Variables utils
        String tipusSoci;
        String nomComplet;
        String dni;
        String tipusAsseg;
        String federacio;
        String opcio;
        int preu;
        int posicio;
        int excursions;
        int size;
        
        //Primer demanem la mida de la llista de socis
        do{
            System.out.print("Per defecte es podran introduir maxim 100 socis.\nVol reduir la capacitat? (S o N): ");
            opcio = sc.nextLine();
        }while(!opcio.equals("S") && !opcio.equals("N"));
                
        //En cas afirmatiu, modifiquem la mida de la llista
        if(opcio.equals("S")){
            do{
                System.out.print("Com a maxim, quants socis hi haura al club? (maxim 100): ");
                size = sc.nextInt();
            }while(size>100 || size<=0);
            this.club = new ClubUB(club.getNom(), size);
        }
        
        // Lança el bucle principal de la aplicació
        do {
            menuEstacio.mostrarMenu();
            opcionMenu = menuEstacio.getOpcio(sc);
            
            switch(opcionMenu) {
                case M_Opcion_1_DonarAltaNouSoci:
                    System.out.print("Quin tipus de soci vol afegir? (Federat (F), "
                            + "Estandard (E) o Junior (J))\n[En cas d'opcio erronia es "
                            + "tornara al menú anterior]: ");
                    tipusSoci = sc.nextLine();
                    
                    if(tipusSoci.equals("F") || tipusSoci.equals("E") || 
                            tipusSoci.equals("J")){
                        
                            System.out.print("Doni el nom complet del soci: ");
                            nomComplet = sc.nextLine();
                            
                            do{
                                System.out.print("Doni el dni del soci (el dni ha de tenir 9 digits): ");
                                dni = sc.nextLine();
                            }while(dni.length()!=9);
                            
                            switch(tipusSoci){
                                case "F":
                                    
                                    System.out.print("A quina federacio pertany? ");
                                    federacio = sc.nextLine();
                                    
                                    do{
                                        System.out.print("Quin preu te la federacio? ");
                                        preu = sc.nextInt();
                                    }while(preu<0);
                                    
                                    try{
                                        club.donarAltaFederat(nomComplet, dni, federacio, preu);
                                    }catch(Exception ex){
                                        System.out.println("Excepcio :: " + ex.getMessage ());
                                    }
                                    break;
                                case "E":
                                    
                                    System.out.print("Quina assegurança vol? (Basica o Completa) ");
                                    tipusAsseg = sc.nextLine();
                                   
                                    do{
                                        System.out.print("Quin preu te l'assegurança? ");
                                        preu = sc.nextInt();
                                    }while(preu<0);
                                    
                                    try{
                                        club.donarAltaEstandard(nomComplet, dni, tipusAsseg, preu);
                                    }catch(Exception ex){
                                        System.out.println("Excepcio :: " + ex.getMessage ());
                                    }
                                    
                                    break;
                                case "J":
                                    
                                    try{
                                        club.donarAltaJunior(nomComplet,dni);
                                    }catch(Exception ex){
                                        System.out.println("Excepcio :: " + ex.getMessage ());
                                    }
                                    
                                    break;
                                default:
                                    System.out.println("No hem pogut afegir el soci.");
                                    break;
                            }
                    }
                    
                    break;
                case M_Opcion_2_MostrarLlistaSocis:
                    
                    System.out.println(club.mostraLlista());
                    
                    break;
                case M_Opcion_3_EliminarSoci:
                    
                    System.out.println("Quina posicio de la llista vol eliminar? ");
                    posicio = sc.nextInt();
                    try {
                        club.eliminaSoci(posicio);
                    } catch (ExcepcioClub ex) {
                        System.out.println("Excepcio :: " + ex.getMessage ()); 
                    }
                    
                    break;
                case M_Opcion_4_MostrarFactura:
                    
                    System.out.println("Doni el dni del soci: ");
                    dni=sc.nextLine();
                    
                    do{
                        System.out.println("Quantes excursions ha fet? ");
                        excursions=sc.nextInt();
                    }while(excursions<0);
                    
                    System.out.println("Calculant factura...");
                    try{
                        System.out.println("Ha de pagar " + club.calcularFactura(dni, excursions) + "€");
                    }catch(ExcepcioClub ex){
                        System.out.println("Excepcio :: " + ex.getMessage ());
                    }
                    
                    break;
                case M_Opcion_5_ModificarNomSoci:
                    
                    System.out.println("Doni el dni del soci que vol modificar: ");
                    dni=sc.nextLine();
                    
                    System.out.println("Quin nom li vol posar? ");
                    nomComplet=sc.nextLine();
                    
                    try {
                        System.out.println(club.modificarNom(dni, nomComplet));
                    } catch (ExcepcioClub ex) {
                        System.out.println("Excepcio :: " + ex.getMessage ());
                    }
                    
                    break;
                case M_Opcion_6_ModificarTipusAssegurançaSoci:
                    
                    System.out.println("Doni el dni del soci que vol modificar: ");
                    dni=sc.nextLine();
                    
                    try {
                        System.out.println(club.modificarAsseg(dni));
                    } catch (ExcepcioClub ex) {
                        System.out.println("Excepcio :: " + ex.getMessage ());
                    }
                    
                    break;
                case M_Opcion_7_GuardarLlista:
                    
                    try {
                        club.guardemInformacio();
                        System.out.println("\nDades guardades amb exit.\n");
                    } catch (IOException ex) {
                         System.out.println("Excepcio :: " + ex.getMessage ());
                    }
                    
                    break;
                case M_Opcion_8_RecuperarLlista:
                    
                    try {
                        club=ClubUB.carregarInformacio();
                        System.out.println("\nDades descarregades amb exit.\n");
                    } catch (IOException ex) {
                         System.out.println("Excepcio :: " + ex.getMessage ());
                    }
                    
                    break;
                case M_Opcion_9_Sortir:
                    
                    System.out.println("Fins la propera.");    
                    
                    break;
                default:
                    break;
            }  
        } while(opcionMenu != OpcionesMenu.M_Opcion_9_Sortir);
    }
}


