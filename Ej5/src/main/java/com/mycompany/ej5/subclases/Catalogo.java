package com.mycompany.ej5.subclases;

import java.util.*;

public class Catalogo<T> {

    private ArrayList<T> catalogo;

    public Catalogo() {
        this.catalogo = new ArrayList<T>(10);
    }

    public int getSize() {
        return catalogo.size();
    }

    public void remove(int index) {
        catalogo.remove(index);
    }

    public void remove(T object) {
        catalogo.remove(object);
    }

    public String imprimir() {
        T tmp;
        String volver = "";
        for (int i = 0; i < catalogo.size(); i++) {
            tmp = catalogo.get(i);
            volver += tmp.toString() + "\n";
        }
        return volver;
    }

    public void anadir(T tmp) {
        catalogo.add(tmp);
    }

    public int buscar(T tmp) {
        return catalogo.indexOf(tmp);
    }

    public T buscar(int index) {
        return catalogo.get(index);
    }

    public T buscarConNif(String parameter) {
        Persona tmp = new Persona();
        for (int i = 0; i < catalogo.size(); i++) {
            tmp = (Persona) catalogo.get(i);
            if (tmp.getNif().equalsIgnoreCase(parameter)) {
                return catalogo.get(i);
            }
        }
        return null;
    }

    public T buscarConBastitud(String parameter) {
        Vehiculos tmp = new Vehiculos();
        for (int i = 0; i < catalogo.size(); i++) {
            tmp = (Vehiculos) catalogo.get(i);
            if (tmp.getBastitud().equalsIgnoreCase(parameter)) {
                return catalogo.get(i);
            }
        }
        return null;
    }

    public void borrar(T tmp) {
        catalogo.remove(tmp);
    }

    public ArrayList<T> getCatalogo() {
        ArrayList<T> volver = new ArrayList<>(catalogo.size());
        for (int i = 0; i < catalogo.size(); i++) {
            volver.add(catalogo.get(i));
        }
        return volver;
    }
}
