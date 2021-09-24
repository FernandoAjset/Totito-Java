/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Pila extends Lista{

    Pila()
     {
         Inicio=null;
     }
    
  
   public void Apilar(int pDato){
        IngresarInicio(pDato); 
    }
    
 /*   public Nodo  retirar(){
        if (Inicio!=null){
            Nodo aux = Inicio; 
            Inicio = Inicio.DarSig();            
            return aux;
        }
        else {
            return null;
        }
    } */
   
   public void retirar()
   {
       EliminarInicio();
   }
   
   public void Mostrar()
   {
       Recorrer();
   }
   
    public int Cima(){
        int num=0;
        if (Inicio !=null){
            num=Inicio.DarDato(); 
        }
        return num;
    }
    
    public static void main(String args[]){
        int x;
        Pila p1 = new Pila(); 
        Pila p2 = new Pila();
        p1.Apilar(1);
        p1.Apilar(2);
        p1.Apilar(3);
        p1.Apilar(8);
        p1.Apilar(4);
        p1.Apilar(20);
        
        p2.Apilar(100);
        p2.Apilar(150);
        p2.Apilar(200);
    
        System.out.println("CIMA:"+p2.Cima());
        System.out.println("\nDatos en pila: ");
        p2.Mostrar();
    } 
}
