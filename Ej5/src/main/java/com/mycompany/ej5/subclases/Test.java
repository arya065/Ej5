package com.mycompany.ej5.subclases;

import java.util.*;
import java.time.*;
import java.lang.*;
import java.time.format.*;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean stop = true;
        int count = 0;
        System.out.println("Introduce nombre de la empresa");
        String name = in.nextLine();
        System.out.println("Introduce cif de la empresa");
        String cif = in.nextLine();
        Empresa empresa = new Empresa(cif, name);
        do {
            System.out.println("""
                               1- Registrar cliente
                               2- Registrar vehiculo
                               3- Registrar alquiler
                               4- Salir
                               5- Opciones de empresa
                               """);
            try {
                int answer = in.nextInt();
                if (answer == 1) {
                    count++;
                    System.out.println("Introduce nombre de cliente");
                    in.nextLine();
                    String nombre = in.nextLine();
                    System.out.println("Introduce edad de cliente");
                    try {
                        int edad = in.nextInt();
                        Persona pers = new Persona(nombre, edad);
                        empresa.anadirCliente(pers);
                        System.out.println(pers.toString());
                        System.out.println("Cliente registrado");
                        empresa.printPers();///////////////////////////////////////////////проверка списка
                    } catch (InputMismatchException e) {
                        System.out.println("Introduce edad entero");
                        in.next();
                    }

                } else if (answer == 2) {
                    count++;
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
                    try {
                        int volumen = in.nextInt();
                        System.out.println("Introduce tarifa de coche");
                        try {
                            int tarifa = in.nextInt();

                            Vehiculos car = new Vehiculos(marka, volumen, nombre, color, tarifa, bastitud);
                            empresa.anadirCar(car);
                            System.out.println(car.toString());
                            System.out.println("Coche registrado");
                            empresa.printCars();////////////////////////////////////////////////проверка списка
                        } catch (InputMismatchException e) {
                            System.out.println("Introduce numero entero");
                            in.next();
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Introduce numero entero");
                        in.next();
                    }

                } else if (answer == 3) {
                    count++;
                    Persona persBuscar = new Persona();
                    Vehiculos carBuscar = new Vehiculos();
                    System.out.println("Introduce nif de cliente");
                    in.nextLine();
                    String nif = in.nextLine();
                    System.out.println("El nif es " + nif);
                    try {
                        persBuscar = empresa.buscarClienteNif(nif);
                        if (persBuscar.equals(null)) {
                            throw new NullPointerException("no hay");
                        }
                        System.out.println("Introduce bastitud de coche");
                        String bastitud = in.nextLine();
                        try {
                            carBuscar = empresa.buscarVehiculoBastitud(bastitud);
                            if (carBuscar.equals(null)) {
                                throw new NullPointerException("no hay");
                            }
                            System.out.println("Introduce numero de dias de alquiler");
                            try {
                                int numdias = in.nextInt();
                                LocalDateTime time = LocalDateTime.now();
                                Alquiler alquiler = new Alquiler(persBuscar, carBuscar, numdias, time);
                                empresa.anadirAlquiler(alquiler);
                                System.out.println(alquiler.toString());
                                System.out.println("Alquiler registrado");
                                empresa.printContracts();////////////////////////////////////////проверка списка
                            } catch (InputMismatchException e) {
                                System.out.println("InputMismatchException");
                                in.next();
                            }
                        } catch (NullPointerException e) {
                            System.out.println("No hay este vehiculo o bastitud incorrecto");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("No hay este cliente o nif incorrecto");
                    }
                } else if (answer == 4) {
                    stop = false;
                } else if (answer == 5) {
                    if (count < 3) {
                        System.out.println("No hay alquileres");
                    } else if (count >= 3) {
                        System.out.println("""
                                           1- Buscar alquiler con NIF 
                                           2- Buscar alquiler con BASTITUD
                                           3- Borrar alquiler con id
                                           4- Borrar cliente si no hay alquileres
                                           5- Borrar vehiculo si no hay alquileres
                                           6- Buscar todos vehiculos con misma fecha de volver
                                           7- Salir
                                           """);
                        try {
                            answer = in.nextInt();
                            if (answer == 1) {
                                System.out.println("Introduce nif de cliente");
                                in.nextLine();
                                String nif = in.nextLine();
                                ArrayList<Alquiler> listToPrint = empresa.getAlquileresNif(nif);
                                if (!listToPrint.get(0).equals(null)) {
                                    for (int i = 0; i < listToPrint.size(); i++) {
                                        System.out.println(listToPrint.get(i).toString());

                                    }
                                } else {
                                    System.out.println("No hay alquileres");
                                }

                            } else if (answer == 2) {
                                System.out.println("Introduce bastitud de vehiculo");
                                in.nextLine();
                                String bastitud = in.nextLine();
                                ArrayList<Alquiler> listToPrint = empresa.getAlquileresBastitud(bastitud);
                                if (!listToPrint.get(0).equals(0)) {
                                    for (int i = 0; i < listToPrint.size(); i++) {
                                        System.out.println(listToPrint.get(i).toString());

                                    }
                                } else {
                                    System.out.println("No hay alquileres");
                                }
                            } else if (answer == 3) {
                                System.out.println("Introduce id de alquiler");
                                try {
                                    int id = in.nextInt();
                                    empresa.borrarAlquiler(id);
                                    empresa.printContracts();
                                } catch (InputMismatchException e) {
                                    System.out.println("Introduce numero entero");
                                }
                            } else if (answer == 4) {
                                System.out.println("Introduce nif de persona");
                                in.nextLine();
                                String nif = in.nextLine();
                                Persona tmp = empresa.buscarClienteNif(nif);
                                try {
                                    tmp.equals(null);
                                    try {
                                        empresa.borrarPersNoAlquila(tmp);
                                    } catch (NullPointerException e) {
                                        empresa.borrarPers(tmp);
                                        System.out.println("Cliente eleminado");
                                    }
                                    empresa.printPers();
                                } catch (NullPointerException e) {
                                    System.out.println("No hay este cliente");
                                }
                            } else if (answer == 5) {
                                System.out.println("Introduce bastitud de vehiculo");
                                in.nextLine();
                                String bastitud = in.nextLine();
                                Vehiculos tmp = empresa.buscarVehiculoBastitud(bastitud);
                                try {
                                    tmp.equals(null);
                                    try {
                                        empresa.borrarVehuculoNoAlquila(tmp);
                                    } catch (NullPointerException e) {
                                        empresa.borrarCar(tmp);
                                        System.out.println("Vehiculo eleminado");
                                    }
                                    empresa.printCars();
                                } catch (NullPointerException e) {
                                    empresa.borrarCar(tmp);
                                    System.out.println("No hay este Vehiculo");
                                }
                            } else if (answer == 6) {
                                System.out.println("Introdir fecha de vuelta en formato");
                                System.out.println("Introduce ano de vulta");
                                int year = in.nextInt();
                                System.out.println("Introduce mes de vuelta");
                                int month = in.nextInt();
                                System.out.println("Introduce dia de vuelta");
                                int day = in.nextInt();

                                LocalDateTime fecha = LocalDateTime.of(year, month, day, 0, 0);
                                ArrayList<Vehiculos> volver = empresa.getVehiculosLocalDate(fecha);
                                for (int i = 0; i < volver.size(); i++) {
                                    System.out.println(volver.get(i).toString());
                                }
                            } else if (answer == 7) {
                                stop = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("No hay este opcion");
                            stop = true;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("No hay este opcion");
                in.next();
                stop = true;
            }
        } while (stop);
    }
}
