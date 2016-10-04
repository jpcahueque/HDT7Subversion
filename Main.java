/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt7;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author JuanPablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Se le pide al usuario que ingrese la cadena de caracteres
        Scanner teclado = new Scanner(System.in);
        String mensajeUsuario;
        System.out.println("Ingrese su mensaje:");
        mensajeUsuario = teclado.nextLine();
        
        ArrayList inicial = new ArrayList<Nodo>();
        
        boolean valido = true;
        int contador = 0;
        //Se convierte el mensaje a una array de chars
        char [] arrayMensaje = mensajeUsuario.toCharArray();
        //Se cuenta la frecuencia de cada elemento
        for(char i: arrayMensaje){
            valido = true;
            Iterator itr = inicial.iterator();
            //Si el elemento que le toca no fue contado ya, es valido contar su frecuencia
            while (itr.hasNext()&&valido){
                Nodo element = (Nodo) itr.next();
                if (i==element.getCh()){
                    valido = false;
                }
            }
            //Contar la frecuencia del elemento
            if (valido== true){
                Nodo temp = new Nodo();
                temp.setCh(i);
                for (char j:arrayMensaje){
                    if (j==i){
                        contador++;
                    }
                }
                temp.setFreq(contador);
                inicial.add(temp);
                contador = 0;
              
            }
        }
        //Se recorre la lista generada de nodos para mostrar la frecuencia de cada elemento ene el orden en que aparecen
        System.out.println("elemento | frecuencia");
        Iterator itr = inicial.iterator();
        while (itr.hasNext()){
            Nodo element = (Nodo)itr.next();
            System.out.println(element.getCh() + "          "+ element.getFreq());
        }
        
        HuffmanTree huff = new HuffmanTree();
        huff.createTree(inicial);
        //System.out.println(huff.getRoot().getCh()+" "+huff.getRoot().getFreq());
    }
   
    
    
}
