package com.mycompany.ej5;
import java.util.*;
import java.time.*;
public class Alquiler {
    
    private Persona pers;
    private Vehiculos car;
    private int numDias;
    private LocalTime time;

    public Alquiler(Persona pers, Vehiculos car, int numDias, LocalTime time) {
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
