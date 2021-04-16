
package prog2.vista;
import java.lang.Exception;


public class ExcepcioClub extends Exception{
    /**
    * Retorna l'excepcio corresponent
     * @param msg 
    */
    public ExcepcioClub(String msg){
        super(msg);
    }
}
