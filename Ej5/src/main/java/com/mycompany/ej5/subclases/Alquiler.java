package com.mycompany.ej5.subclases;

import java.time.*;
import java.util.*;

public class Alquiler {

    private com.mycompany.ej5.Persona pers;
    private com.mycompany.ej5.Vehiculos car;
    private int numDias;
    private LocalTime time;

    public Alquiler(com.mycompany.ej5.Persona pers, com.mycompany.ej5.Vehiculos car, int numDias, LocalTime time) {
        this.pers = pers;
        this.car = car;
        this.numDias = numDias;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "pers=" + pers + ", car=" + car + ", numDias=" + numDias + ", fecha=" + time + '}';
    }

    public int getNumDias() {
        return numDias;
    }

}
