package com.mycompany.ej5;

public class PersonaCatalogo {

    private Persona[] lista;
    private int numPers;

    public PersonaCatalogo(int numPers) { //создание католога
        numPers = Math.abs(numPers);
        this.lista = new Persona[numPers];
        for (int i = 0; i < lista.length; i++) {
            this.lista[i] = new Persona();
        }
    }

    public String imprimCatalogo() {
        System.out.println("Catalogo de personas:");
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println(this.lista[i].toString());
        }
        String line = "_________________________________________________________";
        return line;
    }

    private Persona[] copy(Persona[] array) { // копирование католога c +1 индексом
        Persona[] copied = new Persona[array.length + 1];
        for (int i = 0; i < copied.length; i++) {
            copied[i] = array[i + 1];
        }
        return copied;
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

    public Persona buscarConNif(String nif) {
        for (int i = 0; i < lista.length; i++) {
            Persona persMethod = lista[i];
            if (persMethod.getNif().equalsIgnoreCase(nif)){
                return persMethod;
            }
        }
        return null;
    }

    public void anadirPers(Persona pers) {
        if (this.lista[lista.length - 1] != null) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i].getAge() == 0) {
                    lista[i] = pers;
                    break;
                }
            }
        } else {
            this.lista = copy(lista);
            lista[lista.length - 1] = pers;
        }
    }

    public int getNumPers() { //получение размера каталога 
        return numPers;
    }
}
