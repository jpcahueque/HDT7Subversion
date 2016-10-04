/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt7;

/**
 *
 * @author JuanPablo
 */
public class Nodo
{
    private int freq;
    private char ch;
    private Nodo left;
    private Nodo right;
    
    public Nodo(int frequency, char c, Nodo left, Nodo right)
    {
        this.freq = frequency;
        this.ch = ch;
        this.left = left;
        this.right = right;
    }
    
    public Nodo()
    {
        //does Nothing
    }

    public void setFreq(int frequency) {
        this.freq = frequency;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public int getFreq() {
        return freq;
    }

    public char getCh() {
        return ch;
    }

    public Nodo getLeft() {
        return left;
    }

    public Nodo getRight() {
        return right;
    }
    
    public Nodo addNodo(Nodo nodo1, Nodo nodo2)
    {
        if(nodo1.getFreq() < nodo2.getFreq())
        {
            left = nodo1;
            right = nodo2;
        }
        else
        {
            right = nodo1;
            left = nodo2;
        }
        freq = nodo1.getFreq() + nodo2.getFreq();
        
        return this;
    }
    
}
    
