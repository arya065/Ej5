package com.mycompany.ej5;

public class Empresa {

    private String cif;
    private String name;
    private Persona[] clientes;
    private Vehiculos[] cars;
    private String[] alquileres;

    public Empresa(String cif, String name) {
        this.cif = cif;
        this.name = name;
        this.clientes = new Persona[10];
        this.cars = new Vehiculos[10];
        this.alquileres = new String[10];
    }
    public void andirCliente(Persona pers){
        pers.anadirPers(pers);
    }
    public int buscarCliente(Persona cliente) {
        int index = cliente.buscarPers(cliente);
        return index;

        /*public int buscarPers(Persona pers) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].equals(pers)) {
                return i;
            }
        }
        return -1;
        }*/
    }

    public int buscarVehiculo(Vehiculos car) {
        int index = car.buscarCar(car);
        return index;
        
        /*
        public int buscarCar(Vehiculos car) {
        for (int i = 0; i < listaCars.length; i++) {
            if (listaCars[i].equals(car)) {
                return i;
            }
        }
        return -1;
        }
         */
    }
}
