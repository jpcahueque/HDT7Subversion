/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt7;
import java.util.*;
/**
 *
 * @author JuanPablo
 */
public class HuffmanTree {
    private Nodo root;
    private ArrayList listaFinal;
    private  ArrayList listaInicial;
    
    public HuffmanTree()
    {
        listaFinal = new ArrayList();
        listaInicial = new ArrayList();
        root = new Nodo();
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public void setListaFinal(ArrayList listaFinal) {
        this.listaFinal = listaFinal;
    }

    public void setListaInicial(ArrayList listaInicial) {
        this.listaInicial = listaInicial;
    }

    public Nodo getRoot() {
        return root;
    }

    public ArrayList getListaFinal() {
        return listaFinal;
    }

    public ArrayList getListaInicial() {
        return listaInicial;
    }
    //Se crea el arbol Requisito> de mas de 2 letras
    public void createTree(ArrayList inicial){
        //Se inicializa el nodo raiz
        root = new Nodo();
        //Se toma a la izquierda del root el primer nodo minimo
        listaInicial = inicial;
        Nodo nodoMinimo = min(listaInicial);
        Nodo nodoTemporal;
        //Se remueve de la lista inicial para no volver a contarlo
        listaInicial.remove(nodoMinimo);
        //Se anade a una lista final en orden
        listaFinal.add(nodoMinimo);
        root.setLeft(nodoMinimo);
        //Se encuentra el siguiente minimo de la lista inicial
        nodoMinimo = min(listaInicial);
        //se remueve de la lista inicial
        listaInicial.remove(nodoMinimo);
        //Se agrega a la lista final
        listaFinal.add(nodoMinimo);
        //se agrega a la derecha del root
        root.setRight(nodoMinimo);
        //Se encuentra la frecuencia del nodo root
        root.setFreq((root.getLeft()).getFreq()+root.getRight().getFreq());
        boolean isDone = false;
        //Realizar hasta que ya no queden mas nodos en la lista inicial
        while (isDone == false){
            //Agregar el nodo root actual a la derecha de un nuevo nodo root
                nodoTemporal = new Nodo();
                nodoTemporal.setRight(root);
                root = nodoTemporal;
                nodoMinimo = new Nodo();
                nodoMinimo = min(listaInicial);
                //Agregar a la lista final, quitar de la lista inicial
                listaFinal.add(nodoMinimo);
                listaInicial.remove(nodoMinimo);
                //Agregar a la izquierda del nuevo nodo un nuevo nodo minimo
                root.setLeft(nodoMinimo);
                //Encontrar la nueva frecuencia del nodo root
                root.setFreq((root.getLeft()).getFreq()+root.getRight().getFreq());
            if (listaInicial.size()==0){
                isDone = true;
            }      
        }
    }
    //Metodo que devuelve el nodo con la frecuencia mas baja y que aparece primero
    public Nodo min(ArrayList inicial){
        //Inicializamos un iterador para recorrer facilmente
        Iterator itr = inicial.iterator();
        //Tomamos como minimo el primer valor encontrado de la lista
        int minimo = ((Nodo)inicial.get(0)).getFreq();
        Nodo nodoMinimo = (Nodo)inicial.get(0);
        boolean encontroMinimo = false;
        //Se recorre la lista
        while (itr.hasNext()){
            Nodo element = (Nodo) itr.next();
            //Se cambia de nodo hasta que se encuentra uno con frecuencia minima
            if (element.getFreq()<minimo){
                minimo = element.getFreq();
                nodoMinimo = element;
                encontroMinimo = true;
            }
        }
        //System.out.println(nodoMinimo.getCh());
        return nodoMinimo;
    }
}
