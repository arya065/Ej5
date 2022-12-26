package com.mycompany.ej5;

public class AlquilerCatalogo {

    private Alquiler[] lista;
    int numContractos;

    public AlquilerCatalogo() {
    }
    
    
    public AlquilerCatalogo(int numContractos) {
        this.lista = new Alquiler[numContractos];
    }

    public void anadirAlquiler(Alquiler contracto) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getNumDias() == 0) {
                lista[i] = contracto;
            }
        }
    }

    
    public Alquiler[] copy(Alquiler[] array){
        Alquiler[] copied = new Alquiler[array.length+1];
        for (int i = 0; i < copied.length; i++) {
            copied[i] = array[i+1];
        }
        return copied;
    }
    public int buscarContracto(Alquiler contracto) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(contracto)) {
                return i;
            }
        }
        return -1;
    }
    public boolean borrarPers(Alquiler contracto) {
        int tmp = buscarContracto(contracto);
        if (tmp != -1) {
            this.lista[tmp] = null;
            this.numContractos--;
            return true;
        }
        return false;
    }
}
