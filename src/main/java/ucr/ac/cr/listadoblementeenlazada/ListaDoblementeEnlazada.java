/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ucr.ac.cr.listadoblementeenlazada;

/**
 *
 * @author Stephanie
 */
public class ListaDoblementeEnlazada {

    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    public ListaDoblementeEnlazada() {
    }

    public void suprime(int posicion) {
        longitud--;
        if (!this.esVacia() && posicion >0) {

            if (posicion == 0) {
                
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            } else if (posicion == longitud) {
                
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            } else if (posicion < longitud) {
                
                Nodo indiceNodo = primero;
                int indice = 0;
                while (indiceNodo != null) {
                    
                    if (indice == posicion) {
                        
                        Nodo nodoAnterior = indiceNodo.getAnterior();
                        Nodo nodoSiguiente = indiceNodo.getSiguiente();
                        nodoAnterior.setSiguiente(nodoSiguiente);
                        nodoSiguiente.setAnterior(nodoAnterior);

                        break;
                    }
                    indice++;
                    indiceNodo = indiceNodo.getSiguiente();
                }
            } else if (posicion > longitud) {
                
                longitud++;
            }

        } else {
        
            primero = null;
            ultimo = null;

        }

    }

    public void insertar(int posicion, int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (!this.esVacia()  && posicion >0) {

            if (posicion == 0) {

                primero.setAnterior(nuevoNodo);
                nuevoNodo.setSiguiente(primero);
                primero = nuevoNodo;

            }

            if (posicion >= longitud) {

                ultimo.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(ultimo);
                ultimo = nuevoNodo;

            }

            if (posicion < longitud) {

                Nodo indiceNodo = primero;
                int indice = 0;
                while (indiceNodo != null) {
                    if (indice == posicion) {
                        indiceNodo.getAnterior().setSiguiente(nuevoNodo);
                        nuevoNodo.setSiguiente(indiceNodo);
                        nuevoNodo.setAnterior(indiceNodo.getAnterior());
                        indiceNodo.setAnterior(nuevoNodo);
                        break;
                    }
                    indice++;
                    indiceNodo = indiceNodo.getSiguiente();
                }
            }

        } else {

            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }
        longitud++;
    }

    public String recupera(int posicion) {
        if (!this.esVacia()) {

            if (posicion < longitud) {

                Nodo indiceNodo = primero;
                int indice = 0;
                while (indiceNodo != null) {
                    if (indice == posicion) {
                        return " " + indiceNodo.getDato();
                    }
                    indice++;
                    indiceNodo = indiceNodo.getSiguiente();
                }
            } else {
                return "La posicion excede el tamaño de la lista";
            }

        }
        return "La lista esta vacia";

    }

    public String localiza(int dato) {
        if (!this.esVacia()) {

            Nodo indiceNodo = primero;
            int indice = 0;
            while (indiceNodo != null) {
                if (indiceNodo.getDato() == dato) {
                    return "" + indiceNodo.getDato();
                }
                indice++;
                indiceNodo = indiceNodo.getSiguiente();
            }
            return "El dato no se encontro";

        }
        return "La lista esta vacia";
    }

    public boolean esVacia() {
        if (primero == null) {
            return true;
        }
        return false;
    }

    public String imprimirLista() {
        Nodo indice = primero;
        String mensaje = "";
        while (indice != null) {
            mensaje += "[" + indice.getDato() + "] ";
            indice = indice.getSiguiente();
        }
        return mensaje;
    }

    public void anula() {
        primero = null;
        ultimo = null;
    }

    public String primero() {
        try {
            return "" + primero.getDato();
        } catch (NullPointerException e) {
            return "La lista se encuentra vacia.";
        }
    }
}
