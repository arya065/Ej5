package com.mycompany.ej5.subclases;

import java.time.*;
import java.util.*;

public class Empresa {

    private String cif;
    private String name;
    private Catalogo listClientes;
    private Catalogo listCars;
    private Catalogo listContracts;

    public Empresa(String cif, String name) {
        this.cif = cif;
        this.name = name;
        this.listClientes = new PersonaCatalogo();
        this.listCars = new VehiculosCatalogo();
        this.listContracts = new AlquilerCatalogo();
    }

    public void anadirCliente(Persona cliente) {//добавление клиента
        this.listClientes.anadir(cliente);
    }

    public Persona buscarClienteNif(String nif) {//поиск  клиента по ниф
        return (Persona) listClientes.buscarConNif(nif);
    }

    public Persona buscarCliente(int index) {
        return (Persona) listClientes.buscar(index);
    }

    public int buscarCliente(Persona tmp) {
        return listClientes.buscar(tmp);
    }

    public void anadirCar(Vehiculos car) {//добавление машины
        listCars.anadir(car);
    }

    public Vehiculos buscarVehiculoBastitud(String bastitud) {//поиск машины
        return (Vehiculos) listCars.buscarConBastitud(bastitud);
    }

    public Vehiculos buscarVehiculo(int index) {
        return (Vehiculos) listCars.buscar(index);
    }

    public int buscarVehiculo(Vehiculos tmp) {
        return listCars.buscar(tmp);
    }

    public void anadirAlquiler(Alquiler contract) {
        listContracts.anadir(contract);
    }

    public int buscarAlquiler(Alquiler contract) {
        return listContracts.buscar(contract);
    }

    public Alquiler buscarAlquiler(int index) {
        return (Alquiler) listContracts.buscar(index);
    }

    public void printPers() {
        System.out.println(listClientes.imprimir());
    }

    public void printCars() {
        System.out.println(listCars.imprimir());
    }

    public void printContracts() {
        System.out.println(listContracts.imprimir());
    }

    public ArrayList getClientes() {
        return listClientes.getCatalogo();
    }

    public ArrayList getCars() {
        return listCars.getCatalogo();
    }

    public ArrayList getAlquileres() {
        return listContracts.getCatalogo();
    }

    public ArrayList getAlquileresNif(String nif) {
        ArrayList<Alquiler> volver = new ArrayList<>();
        int numContracts = 0;
        ArrayList<Alquiler> tmp = listContracts.getCatalogo();
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).getPers().getNif().equalsIgnoreCase(nif)) {
                volver.add(tmp.get(i));
                numContracts++;
            }
        }
        if (numContracts == 0) {
            return null;
        }
        volver.trimToSize();
        return volver;

    }

    public ArrayList getAlquileresBastitud(String bastitud) {
        ArrayList<Alquiler> volver = new ArrayList<>();
        int numContracts = 0;
        ArrayList<Alquiler> tmp = listContracts.getCatalogo();
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).getCar().getBastitud().equalsIgnoreCase(bastitud)) {
                volver.add(tmp.get(i));
                numContracts++;
            }
        }
        if (numContracts == 0) {
            return null;
        }
        volver.trimToSize();
        return volver;
    }

    public void borrarAlquiler(int id) {
        listContracts.remove(id);
    }

    public void borrarPersNoAlquila(Persona tmp) {
        String tmpNif = tmp.getNif();
        ArrayList<Alquiler> numContracts = getAlquileresNif(tmpNif);
        if (numContracts.equals(null)) {
        } else {
            System.out.println("Cliente tiene alquileres");
        }
    }

    public void borrarVehuculoNoAlquila(Vehiculos tmp) {
        String tmpBastitud = tmp.getBastitud();
        ArrayList<Alquiler> numContracts = getAlquileresBastitud(tmpBastitud);
        if (numContracts.equals(null)) {
        } else {
            System.out.println("Vehiculo tiene alquileres");
        }
    }

    public ArrayList getVehiculosLocalDate(LocalDateTime fecha) {
        ArrayList<Alquiler> tmp = listContracts.getCatalogo();
        ArrayList<Vehiculos> volver = new ArrayList<>();
        int dayAlquiler;
        int yearAlquiler;
        int dayFecha = fecha.getDayOfYear();
        int yearFecha = fecha.getYear();
        for (int i = 0; i < tmp.size(); i++) {
            dayAlquiler = tmp.get(i).getTimeBack().getDayOfYear();
            yearAlquiler = tmp.get(i).getTimeBack().getYear();
            if (dayAlquiler == dayFecha && yearAlquiler == yearFecha) {
                volver.add(tmp.get(i).getCar());
            }
        }
        return volver;
    }

    public void borrarPers(Persona tmp) {
        listClientes.remove(tmp);
    }

    public void borrarCar(Vehiculos tmp) {
        listCars.remove(tmp);
    }

    @Override
    public String toString() {
        return "Empresa{" + "cif=" + cif + ", name=" + name + ", listClientes=" + listClientes + ", listCars=" + listCars + ", listContracts=" + listContracts + '}';
    }

}
