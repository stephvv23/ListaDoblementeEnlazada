/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.listadoblementeenlazada;

/**
 *
 * @author Stephanie
 */
public class Principal {
    public static void main(String[] args) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
        lista.insertar(0, 1);
        lista.insertar(1, 2);
        lista.insertar(2, 3);
        lista.insertar(3, 4);
        lista.suprime(3);
        System.out.print(lista.imprimirLista());
    }
}
