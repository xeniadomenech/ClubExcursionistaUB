
package prog2.vista;

import java.util.Scanner;

public class IniciadorClubUB {

    
    public static void main(String[] args) {
        
        String nom = "Club excursionista UB";
        int size;
        
        // Creem un objecte de la vista i li passem el nom del club
        VistaClubUB vistaClub = new VistaClubUB(nom, 100);
     
        // Inicialitzem l'execució de la vista
        vistaClub.gestioClubUB();
    }
    
}