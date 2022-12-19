package com.mycompany.ej5;

import java.util.*;

public class Vehiculos {

    private String mark;
    private int volumen;
    private String carName;
    private String color;
    private double tarifa;
    private String bastitud;

    public Vehiculos() {
    }

    public Vehiculos(String mark, int volumen, String carName, String color, double tarifa, String bastitud) {
        this.mark = mark;
        this.volumen = volumen;
        this.carName = carName;
        this.color = color;
        this.tarifa = tarifa;
        this.bastitud = bastitud;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "mark=" + mark + ", volumen=" + volumen + ", carName=" + carName + ", color=" + color + ", tarifa=" + tarifa + ", bastitud=" + bastitud + '}';
    }
    
    
    
    public String getBastitud() {
        return bastitud;
    }
    

    public int getVolumen() {
        return volumen;
    }
    
}
