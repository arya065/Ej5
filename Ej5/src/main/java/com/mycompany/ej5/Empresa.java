package com.mycompany.ej5;

public class Empresa {

    private String cif;
    private String name;
    private PersonaCatalogo clientes;
    private VehiculosCatalogo cars;
    private AlquilerCatalogo alquileres;

    public Empresa(String cif, String name) {
        this.cif = cif;
        this.name = name;
        this.clientes = new PersonaCatalogo(10);
        this.cars = new VehiculosCatalogo(10);
        this.alquileres = new AlquilerCatalogo(10);
    }

    public void anadirCliente(Persona cliente) {//добавление клиента
        clientes.anadirPers(cliente);
    }

    public Persona buscarCliente(String nif) {//поиск в каталоге клиентов
        Persona persMethod = clientes.buscarConNif(nif);
        return persMethod;
    }

    public Vehiculos buscarVehiculo(String bastitud) {//поиск машины
        Vehiculos carMethod = cars.buscarConBastid(bastitud);
        return carMethod;
    }

    public void anadirCar(Vehiculos car) {//добавление машины
        cars.anadirCars(car);
    }
    public String printPers(){
        String a = clientes.imprimCatalogo();
        return a;
        
    }
    public String printCars(){
        String a = cars.imprimCatalogo();
        return a;
    }

    public PersonaCatalogo getClientes() {
        return clientes;
    }

    public VehiculosCatalogo getCars() {
        return cars;
    }

    public AlquilerCatalogo getAlquileres() {
        return alquileres;
    }
    
}
