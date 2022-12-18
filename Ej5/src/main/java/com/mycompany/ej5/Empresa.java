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

    public int buscarCliente(String nif) {//поиск в каталоге клиентов
        int index = clientes.buscarConNif(nif);
        return index;
    }

    public int buscarVehiculo(String bastitud) {//поиск машины
        int index = cars.buscarConBastid(bastitud);
        return index;
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
