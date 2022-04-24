/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodosnumerios.combatt;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 * 
 * @author Lois Blazer
 */
public class Derivar {
    private String Funcion2;
    
      public Derivar(String Funcion) {
        this.Funcion2 = Funcion2;
    }
      

      
public String Derivar(String Funcion2){

String Mensaje = "";
DJep j = new DJep(); 
j.addStandardFunctions();
j.addStandardConstants();
j.addComplex();
j.setAllowUndeclared(true);
j.setAllowAssignment(true);
j.addStandardDiffRules();

    try {
        Node node = j.parse(Funcion2);
        Node diff = j.differentiate(node, "x");
        Node sim = j.simplify(diff);
        Mensaje = j.toString(sim);
    } catch (ParseException e) {
        e.printStackTrace();
    }
        return Mensaje;
        
        

}
}
