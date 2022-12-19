package com.mycompany.ej5;

public class VehiculosCatalogo {

    private Vehiculos[] listaCars;
    private int numCars;

    public VehiculosCatalogo(int numCars) { //конструктор каталога
        numCars = Math.abs(numCars);
        this.listaCars = new Vehiculos[numCars];
        for (int i = 0; i < listaCars.length; i++) {
            this.listaCars[i] = new Vehiculos();
        }
    }

    public int getNumCars() {
        return numCars;
    }

    public String imprimCatalogo() {
        System.out.println("Catalogo de vehiculos:");
        for (int i = 0; i < this.listaCars.length; i++) {
            System.out.println(this.listaCars[i].toString());
        }
        String line = "_________________________________________________________";
        return line;
    }

    public Vehiculos[] copy(Vehiculos[] array) {
        Vehiculos[] copied = new Vehiculos[array.length + 1];
        for (int i = 0; i < copied.length; i++) {
            copied[i] = array[i + 1];
        }
        return copied;
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
        if (this.listaCars[listaCars.length - 1] != null) {
            for (int i = 0; i < listaCars.length; i++) {
                if (listaCars[i].getVolumen() == 0) {
                    listaCars[i] = car;
                    break;
                }
            }
        } else {
            this.listaCars = copy(listaCars);
            listaCars[listaCars.length - 1] = car;
        }
    }

    public Vehiculos buscarConBastid(String bastitud) {
        for (int i = 0; i < listaCars.length; i++) {
            Vehiculos carMethod = listaCars[i];
            if (carMethod.getBastitud().equalsIgnoreCase(bastitud)) {
                return carMethod;
            }
        }
        return null;
    }

}
