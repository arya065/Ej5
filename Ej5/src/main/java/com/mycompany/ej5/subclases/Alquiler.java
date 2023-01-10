package com.mycompany.ej5.subclases;

import java.time.*;
import java.util.*;

public class Alquiler {

    private Persona pers;
    private Vehiculos car;
    private int numDias;
    private LocalDateTime time;
    private LocalDateTime timeBack;

    public Alquiler(Persona pers, Vehiculos car, int numDias, LocalDateTime time) {
        this.pers = pers;
        this.car = car;
        this.numDias = numDias;
        this.time = time;
        this.timeBack = time.plusDays(numDias);
    }

    @Override
    public String toString() {
        return "Alquiler{" + "pers=" + pers + ", car=" + car + ", numDias=" + numDias + ", time=" + time + ", timeBack=" + timeBack + '}';
    }

    public int getNumDias() {
        return numDias;
    }

    public Persona getPers() {
        return pers;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Vehiculos getCar() {
        return car;
    }

    public LocalDateTime getTimeBack() {
        return timeBack;
    }

}
