/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumerios.combatt;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lois Blazer
 */
public class MetodosVistos {
    private Evaluar Eva;
    private Derivar Deri;
    private Derivar2 DER;
    

    public MetodosVistos() {
    }
    
    
     public MetodosVistos(String Funcion, String Funcion2, String Fun2) {
        Eva = new Evaluar(Funcion);
        Deri = new Derivar(Funcion2);
        DER = new Derivar2(Fun2);
    }
  
        
     public void setEvaluar(String Funcion){
     Eva = new Evaluar(Funcion);
    
    }
     
    public void setDerivar(String Funcion2){
     Deri = new Derivar(Funcion2);
    
    }
    
     public void setDerivar2(String Fun2){
     DER = new Derivar2(Fun2);
    
    }
     
    //-------------------------------------------------------------------------- 
     // 1) Método De Bisección
  
    public String MetodoBiseccion(double a, double b, int i){
    String Mensaje = "";
    String Mensaje2="";
    String line="";
    String MensajeFinal = "";
    int Cont = 0;
    double Xi = 0;
    double Xianterior = 0;
    double Fa= 0;
    double Fb = 0;
    double FXi = 0;
    double Error = 0;
  
    // Esto sirve para limitar numero de decimales 
    DecimalFormat Df= new DecimalFormat();
    
    
    
    if (Eva.Evaluar(a) * Eva.Evaluar(b) >0 ){
         JOptionPane.showMessageDialog(null, "Signos Iguales, Prueba Con Otros Intervalo");
    }else{
         
       
         do {             
            Cont++;
             
           
            // Xi al pricipio vale 0, por lo Xianterior vale 0
            Xianterior = Xi;
             
            //Evaluamos a.
            Fa = Eva.Evaluar(a);// -5
             
            //Evaluamos b.
            Fb = Eva.Evaluar(b);// 14
             
            // aquí encontramos Xi.
            Xi = (a + (b - a) / 2);// 1.5
             
            //Posteriormente Evaluamos Xi en la función.
            FXi = Eva.Evaluar(Xi);//2.375
             
            // Encontramos el Error%.
            Error = Math.abs(Xi - Xianterior);//1.5-0 = 1.5 
             
            // Mostramos En Pantalla.
            Mensaje = "Ite" + "\t|  a  " + "\t|  b  " + "\t|  F(a)  " + "\t|  F(b)  " + "\t|  Xi " + "\t|  F(xi) " + "\t|  Xi -Xi-1" + "\n";
            line ="________________________________________________________________________________________________________________________"+ "\n";
            
            Mensaje2 +=""+ Cont + "\t" + Df.format(a) + "\t" + Df.format(b) + "\t"  + Df.format(Fa)+ "\t" + Df.format(Fb)+ "\t" + Df.format(Xi)+ "\t"  + Df.format(FXi)+ "\t"    +Df.format(Error)+" %" +"\n";

            // Condició Intercambio
            if (FXi > 0){b = Xi;}else {a=Xi;}
           
                      
         } while (Error > 0.001 && Cont < i);
         
         MensajeFinal = line +Mensaje+ line + Mensaje2+ line;
    }
        return MensajeFinal;
    }
     
  //----------------------------------------------------------------------------    
    // 2) Regla Falsa
      
    public String Reglafalsa(double a, double b, int i){
    String Mensaje = "";
    String MensajeFinal="";
    String Mensaje2 = "";
    String line = "";
     
    int Cont = 0;
    double Fa = 0;
    double Fb = 0;
    double Xi = 0;
    double Fxi = 0;
    double Xianterior;
    double Error = 0;
      
    // Esto sirve para limitar numero de decimales.
    DecimalFormat Df = new DecimalFormat();
      
    if (Eva.Evaluar(a) * Eva.Evaluar(b) >0 ){
            JOptionPane.showMessageDialog(null, "Prueba Con Otros Intervalos");
     
     }else {
           
             do {                 
                 Cont++;
                // Xi al pricipio vale 0, por lo Xianterior vale 0
                 Xianterior = Xi;
                
                //Evaluamos a.
                 Fa =Eva.Evaluar(a);
                 
                 //Evaluamos b.
                 Fb =Eva.Evaluar(b);
               
                // aquí encontramos Xi. 
                Xi = (((a * (Fb)) - (b * (Fa))) / ((Fb) - (Fa)));
                
                //Posteriormente Evaluamos Xi en la función.
                Fxi =Eva.Evaluar(Xi);
                 
                Error = Math.abs(Xi - Xianterior);
        
                // Muestro En Pantalla                 
                Mensaje = "Ite" + "\t|  a  " + "\t|  b  " + "\t|  F(a)  " + "\t|  F(b)  " + "\t|  Xi " + "\t|  F(xi) " + "\t|  Xi -Xi-1" + "\n";
            line ="________________________________________________________________________________________________________________________"+ "\n";
            
            Mensaje2 +=""+ Cont + "\t" + Df.format(a) + "\t" + Df.format(b) + "\t"  + Df.format(Fa)+ "\t" + Df.format(Fb)+ "\t" + Df.format(Xi)+ "\t"  + Df.format(Fxi)+ "\t"   +Df.format(Error)+" %" +"\n";
    
                // Condició Intercambio
                if (Fxi > 0){ b = Xi; }else {a=Xi;}
                 
    } while (Error > 0.001 && Cont < i);
             
            MensajeFinal = line +Mensaje+ line + Mensaje2+ line;

        
    }
         return MensajeFinal;
    }
      
    //--------------------------------------------------------------------------
      
      // 3) Método del Secante
    
    public String Secante(double X0, double X1, int i){
    String Mensaje = "";
    String Mensaje2 = "";
    String line = "";
    String MensajeFinal = "";
    double Fx0 = 0;
    double Fx1 = 0;
    double Fxi = 0;
    double XiRecu = 0;
    double Xianterior = 0;
    double Error = 0;
    int Cont = 1;
        // Esto sirve para limitar numero de decimales.
        DecimalFormat Df = new DecimalFormat();
    
        if (i == 1){
        JOptionPane.showMessageDialog(null, "Los Valores Están Dados" +"X0 = "+Df.format(X0) + " y " +"X1 = "+Df.format(X1) );
        
        
        }else{
        
        do {  
                 Cont ++;
                 // Xi al pricipio vale 0, por lo Xianterior vale 0
                 
                 
                 // Xi al pricipio vale 0, por lo Xianterior vale 0
                 Xianterior = XiRecu;
           
                 // Evaluo fx0
                 Fx0 = Eva.Evaluar(X0);
                 
                 // Evaluo fx1
                 Fx1 = Eva.Evaluar(X1); 
                 // aquí encontramos Xi.
                 XiRecu = (X1 - (X1-X0)/(Fx1-Fx0) * Fx1);
                 //Posteriormente Evaluamos Xi en la función.
                 Fxi = Eva.Evaluar(XiRecu);
                 if(Cont ==2){
                 Error = Math.abs(XiRecu - X1);
                }else{
                 Error = Math.abs(XiRecu - Xianterior);
                 
                }
                // Muestro En Pantalla      
                
                 Mensaje = "Ite" + "\t|  X0  " + "\t|  X1  " + "\t|  F(X0)  " + "\t|  F(X1)  " + "\t|  Xi " + "\t|  F(xi) " + "\t|  Xi -Xi-1" + "\n";
            line ="________________________________________________________________________________________________________________________"+ "\n";
            
            Mensaje2 +=""+ Cont + "\t" + Df.format(X0) + "\t" + Df.format(X1) + "\t"  + Df.format(Fx0)+ "\t" + Df.format(Fx1)+ "\t" + Df.format(XiRecu)+ "\t"  + Df.format(Fxi)+ "\t"   +Df.format(Error)+" %" +"\n";
                 
                // Intercambio.
                X0 = X1;
                X1 = XiRecu;
                
        } while (Error > 0.001 && Cont < i);
           MensajeFinal = line +Mensaje+ line + Mensaje2+ line;
        
        }
        return MensajeFinal;
        }
    
    // Método Newton Raphson
    
   public String DerivandoLafuncion(String Fun){
   String Mensaje = "";
   Mensaje = Deri.Derivar(Fun);
        return Mensaje;
   
   
   }
   
    public String NRaphson(double X0, int i){
    String Mensaje = "";
    String Mensaje2 = "";
    String line = "";
    String MensajeFinal = "";
    
    double FDerix0 = 0;
    double XiRecu = 0;
    double Fx0 = 0;
    double FDx0 = 0;
    
    double Xianterior = 0;
    double Error = 0;
    String FuncionDeri = "";
    int Cont = 0;
        // Esto sirve para limitar numero de decimales.
        DecimalFormat Df = new DecimalFormat();
    
       
        
        do {  
                 Cont ++;
                 // Xi al pricipio vale 0, por lo Xianterior vale 0
                 
                 
                 // Xi al pricipio vale 0, por lo Xianterior vale 0
                 Xianterior = XiRecu;
           
                 // Evaluo X0 en la funcion
                 Fx0 = Eva.Evaluar(X0);
                 
                 //evalo x0 en la funcion derivada:
                 
                 
                 FDerix0 = DER.Derivada2(X0);
                 
                 if(Cont == 1){
                 XiRecu = X0;
                 
                 }else if (Cont>1){
                 XiRecu = X0 - ((Fx0) / (FDerix0));
                 }
                Error = Math.abs(XiRecu - Xianterior);
                // Muestro En Pantalla      
                
                 Mensaje = "Ite" + "\t|  Xi  " + "\t|  FXi  " + "\t|  F´xi  " + "\t|  Xi -Xi-1" + "\n";
            line ="________________________________________________________________________________________________________________________"+ "\n";
            
            Mensaje2 +=""+ Cont + "\t" + Df.format(XiRecu) + "\t" + Df.format(Fx0) + "\t"  + Df.format(FDerix0)+ "\t" + Df.format(Error)+" %" +"\n";
                 
                X0 = XiRecu;
                
                
        } while (Error > 0.001 && Cont < i);
           MensajeFinal = line +Mensaje+ line + Mensaje2+ line;
        
        
        return MensajeFinal;
        }
    
   
    
}
