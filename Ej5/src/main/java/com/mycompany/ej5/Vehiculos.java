package com.mycompany.ej5;

import java.util.*;

public class Vehiculos {

    private String mark;
    private int cubos;
    private String carName;
    private Vehiculos[] listaCars;
    private int numCars;

    public Vehiculos() {
    }

    public Vehiculos(String mark, int cubos, String carName) {
        this.mark = mark;
        this.cubos = cubos;
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "mark=" + mark + ", cubos=" + cubos + ", carName=" + carName + '}';
    }

    public Vehiculos[] copy(Vehiculos[] array) {
        Vehiculos[] copied = new Vehiculos[array.length + 1];
        for (int i = 0; i < copied.length; i++) {
            copied[i] = array[i];
        }
        return copied;
    }

    public int getNumCars() {
        return numCars;
    }

    public boolean borrarCar(Vehiculos car) {
        int tmp = buscarCar(car);
        if (tmp != -1) {
            this.listaCars[tmp] = null;
            this.numCars--;
            return true;
        }
        return false;
    }

    public int buscarCar(Vehiculos car) {
        for (int i = 0; i < listaCars.length; i++) {
            if (listaCars[i].equals(car)) {
                return i;
            }
        }
        return -1;
    }

    public void anadirCars(Vehiculos car) {
        if (this.listaCars[listaCars.length-1] != null) {
            for (int i = 0; i < listaCars.length; i++) {
                if (listaCars[i].equals(null)) {
                    listaCars[i] = car;
                }
            }
        } else {
            this.listaCars = copy(listaCars);
            listaCars[listaCars.length - 1] = car;
        }
    }
}
