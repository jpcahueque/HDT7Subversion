/*
 * Jorge Mario Tezen 15417
 * Juan Pablo Cahueque 15396
 * Hoja de Trabajo 7 
 */
package hdt7;
public class Nodo
{
    private int freq;
    private char ch;
    private Nodo left;
    private Nodo right;
    private String cadena; 
    
    public Nodo(int frequency, char c, Nodo left, Nodo right)
    {
        this.freq = frequency;
        this.ch = ch;
        this.left = left;
        this.right = right;
    }
    
    public Nodo()
    {
        ch=0;
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

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
}
