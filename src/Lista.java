
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Ajset
 */
public class Lista {
     protected Nodo Inicio;
     
     Lista()
     {
         Inicio=null;
     }
     
     public void IngresarInicio(int pDato)
     {
         if(Inicio==null)
         {
             Inicio= new Nodo(pDato);
         }
         else
         {
             Nodo nuevo = new Nodo(pDato);
             nuevo.setSig(Inicio);
             Inicio=nuevo;
         }
     }
     
     public void IngresarFinal(int pDato)
     {
         if(Inicio==null)
         {
             Inicio= new Nodo(pDato);
         }
         else
         {
             Nodo aux=Inicio;
             while(aux.novacio())
             {
                aux=aux.DarSig();
             }
             aux.setSig(new Nodo(pDato));
         }
     }
     
     public Nodo  EliminarInicio(){
        if (Inicio!=null){
            Nodo aux = Inicio; 
            Inicio = Inicio.DarSig();            
            return aux;
        }
        else {
            return null;
        }
    }

 
     public static void Ingresosi(int Pdato, Lista l1)
     {
         
         System.out.println("Desea agregar el nodo al Inicio o Fin?: ");
         Scanner s = new Scanner(System.in);
         String name = s.nextLine();
         if(name.equalsIgnoreCase("inicio"))
         {
             l1.IngresarInicio(Pdato);
         }
         else
         {
             l1.IngresarFinal(Pdato);
         }
         
     }
             
     /*  PSEUDOCODIGO PARA RECORRER
        aux=inicio;
        Mientras (aux!=nulo) entonces
            imprimir(aux.dato)
            aux=aux.sig;
        Fin Mientras
     */
     public void Recorrer()
     {
         Nodo aux=Inicio;
         //System.out.println("Recorrer Lista: ");
         while(aux!=null)
         {
             System.out.println("Dato: "+aux.DarDato());
             aux=aux.DarSig();
         }
     }
     
     public String DarLista()
     {
         String lista = new String();
         int c=0;
         Nodo aux=Inicio;
         while(aux!=null)
         {
             if(c==9)
             {
               lista+=("\n");
               c=0;
             }
             lista+=String.valueOf(aux.DarDato())+"   ";
             c++;
             aux=aux.DarSig();
         }
         return lista;
     }
     
     public boolean Existe(int pdato)
     {
         boolean respuesta=false;
         Nodo aux=Inicio;
         while(aux!=null)
         {
             if (pdato==aux.DarDato())
             {
             respuesta=true;
             }
             aux=aux.DarSig();
         }
         return respuesta;
     }
     
         public Nodo DarUltimo(){
        Nodo aux = Inicio; 
        try{
            while(aux.DarSig()!=null){
                aux = aux.DarSig(); 
            }
            return aux; 
        }
        catch(Exception ex){
            System.out.println("Error darUltimo(): "+ex.getMessage());
        }
        return null; 
    }

     
        public static void main(String args[])
        {
            Lista l1 = new Lista();
            Lista l2 = new Lista();

            //INGRESO DE DATOS A LISTA 1
            l1.IngresarInicio(1);
            l1.IngresarInicio(2);
            l1.IngresarInicio(3);
            l1.IngresarFinal(8);
            l1.IngresarFinal(9);
            l1.IngresarFinal(10);

            //INGRESO DE DATOS A LISTA 2
            l2.IngresarInicio(7);
            l2.IngresarInicio(8);
            l2.IngresarInicio(9);

            /*AGREGAR DATO CON CONDICIONAL
            int x=20;
            System.out.println("Agregando numero "+x+" A la lista");
            Ingresosi(x, l1);*/
            l1.Recorrer();
            l2.Recorrer();

            /*BUSCAR SI UN NUMERO ESTÁ EN LA LISTA
            x=2;
            System.out.println("BUSCANDO NUMERO "+x+" EN LA LISTA");
            if(l1.Existe(x)==true)
            {    
               System.out.println("El numero "+x+" si está en la lista");
            }
            else
            {
                System.out.println("No se encontró el numero en la lista");
            }
            
        //ELIMINAR DATO DEL INICIO    
        System.out.println("Se eliminó: "+l1.EliminarInicio().DarDato());
     
        //DAR DATO DEL FINAL DE LA LISTA 
        l1.Recorrer();    
        try{
            System.out.println("Ultimo elemento lista1: " + l1.DarUltimo().DarDato()); 
        }
        catch(Exception ex){
            
        }*/
    }
      //  System.out.println("Ultimo elemento lista2: " + l2.DarUltimo().DarDato()); 

    
}
