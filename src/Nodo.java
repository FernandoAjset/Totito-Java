/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Nodo {
    public int dato;
    public Nodo sig;
    
    Nodo(int pDato)
    {
        dato=pDato;
        sig=null;
    }
    
    public int DarDato()
    {
        return dato;
    }
    
    public Nodo DarSig()
    {
        return sig;
    }
    
    public void setDato(int dato)
    {
        this.dato=dato;
    }
    
    public void setSig(Nodo sig)
    {
        this.sig=sig;
    }
    
    public boolean novacio()
    {
        return sig!=null;
    }
}
