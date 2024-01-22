/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public class Lista<T> {

    protected ArrayList<T> lista;

    public Lista() {// constructor
        lista = new ArrayList();
    }

    public int getSize() {
        // TO-BE-DONE
        return lista.size();
        // DONE
    }

    public void add(T t) {
        // TO-BE-DONE
        lista.add(t);
        // DONE
    }

    public void borrar(T t) {
        // TO-BE-DONE
        lista.remove(t);
        // DONE
    }

    public T getAt(int position) {
        // TO-BE-DONE
        return lista.get(position);
        // DONE
    }

    public void clear() {
        // TO-BE-DONE
        lista.clear();
        // DONE

    }

    public boolean isEmpty() {
        // TO-BE-DONE
        return lista.isEmpty();
        // DONE
    }

    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList(lista);
        return arrlist;
    }
}
