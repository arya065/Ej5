package com.mycompany.ej5;

import java.util.*;
import java.time.*;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exit = true;

        System.out.println("Introduce nombre de empresa");//crear empresa
        String cif = in.nextLine();
        System.out.println("Introduce cif de empresa");
        String nomEmpresa = in.nextLine();
        Empresa emp = new Empresa(cif, nomEmpresa);
        PersonaCatalogo catalogoPers = emp.getClientes();
        VehiculosCatalogo catalogoCoches = emp.getCars();
        do {
            System.out.println("Introduce opcion");//menu principal
            System.out.println("""
                           1- Anadir Cliente
                           2- Anadir Vehiculo
                           3- Alquiler
                           4- SALIR
                           """);
            int menu1 = in.nextInt();

            if (menu1 == 1) {//crear cliente
                System.out.println("Introduce nombre de cliente");
                in.nextLine();
                String nombre = in.nextLine();
                System.out.println("Introduce edad de cliente");
                int edad = in.nextInt();
                Persona pers = new Persona(nombre, edad);
                emp.anadirCliente(pers);
                System.out.println("NIF de cliente");
                System.out.println(pers.getNif());
                System.out.println("Cliente registrado");
                System.out.println(emp.getClientes().imprimCatalogo());

            } else if (menu1 == 2) {// crear coche

                System.out.println("Introduce marka de coche");
                in.nextLine();
                String marka = in.nextLine();
                System.out.println("Introduce nombre de coche");
                String nombre = in.nextLine();
                System.out.println("Introduce color de coche");
                String color = in.nextLine();
                System.out.println("Introduce bastitud de coche");
                String bastitud = in.nextLine();
                System.out.println("Introduce volumen de coche");
                int volumen = in.nextInt();
                System.out.println("Introduce tarifa de coche");
                int tarifa = in.nextInt();

                Vehiculos car = new Vehiculos(marka, volumen, nombre, color, tarifa, bastitud);
                emp.anadirCar(car);
                System.out.println("Coche registrado");
                System.out.println(emp.getCars().imprimCatalogo());

            } else if (menu1 == 3) {//crear alquiler
                Persona persBuscar = new Persona();
                Vehiculos carBuscar = new Vehiculos();
                System.out.println("Introduce nif de cliente");
                in.nextLine();
                String nif = in.nextLine();
                System.out.println("El nif es "+nif);
                try {
                    persBuscar = emp.buscarCliente(nif);

                    System.out.println("Introduce bastitud de coche");
                    String bastitud = in.nextLine();
                    try {
                        carBuscar = emp.buscarVehiculo(bastitud);
                        System.out.println("Introduce numero de dias de alquiler");
                        int numdias = in.nextInt();
                        LocalTime time = LocalTime.now();
                        Alquiler alquiler = new Alquiler(persBuscar, carBuscar, numdias, time);
                        System.out.println(alquiler.toString());
                    } catch (java.lang.NullPointerException e) {
                        System.out.println("No hay este vehiculo o bastitud incorrecto");
                    }

                } catch (java.lang.NullPointerException e) {
                    System.out.println("No hay este cliente o nif incorrecto");
                }

            } else if (menu1 == 4) {
                exit = false;
            }
        } while (exit);
    }
}
