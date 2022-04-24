/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumerios.combatt;

import org.nfunk.jep.JEP;


public class Evaluar {
     private String Funcion;
     private String Derivar2;
     
      public Evaluar(String Funcion) {
        this.Funcion = Funcion;
    }
      
      
      
         public double Evaluar (double x){
    JEP j = new JEP(); // clase JEP
    j.addStandardFunctions(); // esto nos permite tener todas las expresiones como son seno, coseno tangente, etc
    j.addStandardConstants(); // esto nos permite usar constantes como pi, x , etc.
    j.addVariable("x", x);
    j.parseExpression(Funcion);// parseamos expresion que el usuario escribe.
    
        if (!j.hasError()) { // si no hay errores
            return j.getValue(); // obtenemos el resultado de la expresion.
        } else { // de lo contrario;
            return x; // Retornar cero;
        }
    }
}
