package com.mycompany.ej5;

public class Persona {

    private String name;
    private int age;
    private String nif;
    private Persona[] lista;
    private int numPers;

    public Persona() {
    }

    public Persona(String name, int age, String nie) {
        this.name = name;
        this.age = age;
        this.nif = nie;
    }

    public Persona(int numeroPers) {
        numeroPers = Math.abs(numeroPers);
        this.numPers = numeroPers;
        this.lista = new Persona[numeroPers];
        for (int i = 0; i < lista.length; i++) {
            this.lista[i] = new Persona();
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "lista=" + lista + '}';
    }

    public Persona[] copy(Persona[] array) {
        Persona[] copied = new Persona[array.length + 1];
        for (int i = 0; i < copied.length; i++) {
            copied[i] = array[i];
        }
        return copied;
    }

    public int getNumPers() {
        return numPers;
    }

    public boolean borrarPers(Persona pers) {
        int tmp = buscarPers(pers);
        if (tmp != -1) {
            this.lista[tmp] = null;
            this.numPers--;
            return true;
        }
        return false;
    }

    public int buscarPers(Persona pers) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(pers)) {
                return i;
            }
        }
        return -1;
    }

    public void anadirPers(Persona pers) {
        if (this.lista[lista.length-1] != null) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i].equals(null)) {
                    lista[i] = pers;
                }
            }
        } else {
            this.lista = copy(lista);
            lista[lista.length - 1] = pers;
        }
    }

}
