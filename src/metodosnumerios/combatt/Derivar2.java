

package metodosnumerios.combatt;

import org.nfunk.jep.JEP;


public class Derivar2 {
  private String Fun2;
  
  
  public Derivar2(String Fun2) {
        this.Fun2 = Fun2;
    }
  
  
  public double Derivada2(double x) {
        JEP jep = new JEP();
        jep.addStandardFunctions(); // esto nos permite tener todas las expresiones como son seno, coseno tangente, etc
        jep.addStandardConstants(); // esto nos permite usar constantes como pi, x , etc.
        jep.addVariable("x", x);
        jep.parseExpression(Fun2);// parseamos expresion que el usuario escribe.

        if (!jep.hasError()) { // si no hay errores
            return jep.getValue(); // obtenemos el resultado de la expresion.
        } else { // de lo contrario;
            return Double.NaN;
        }

    }
    
}

