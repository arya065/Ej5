package com.mycompany.ej5.subclases;

import java.util.*;

public class PersonaCatalogo extends Catalogo {

    private ArrayList<Persona> listClientes;

    public PersonaCatalogo(int numPers) {
        this.listClientes = new ArrayList<>(numPers);
    }
    
}
