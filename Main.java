/*
 * Jorge Mario Tezen 15417
 * Juan Pablo Cahueque 15396
 * Hoja de Trabajo 7 
 */
package hdt7;

import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        
        huff.codificar();
        System.out.println("elemento | frecuencia |   codigo");
        Iterator itrf= huff.getListaH().iterator();
        while(itrf.hasNext()){
            Nodo pivotal = (Nodo)itrf.next();
            System.out.println(pivotal.getCh() + "           "+ pivotal.getFreq()+ "           "+ pivotal.getCadena());           
        }
        
        System.out.println("Ingrese un codigo en base a la tabla anterior, separando por espacios cada nuevo caracter");
        mensajeUsuario = teclado.nextLine();
        mensajeUsuario.indexOf(" ");
        String mensajeFinal = "";
        String letra = " ";
        String[] arrayDecode = mensajeUsuario.split(" ");
        boolean codigoValido = true;
        for (String i: arrayDecode){
            if (codigoValido){
                letra = huff.decodificar(i);
            }
            if (letra.length()>5){
                codigoValido = false;
            }
            else {
                mensajeFinal = mensajeFinal.concat(letra);
            }
        }
        
        if (codigoValido){
            System.out.println(mensajeFinal);
        }
        else {
            System.out.println("El codigo ingresado no es valido");
        }
        
        
    } 
}
