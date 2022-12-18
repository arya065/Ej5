package com.mycompany.ej5;

import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;//импорт архивов в файл pom

public class Persona {

    private String name;
    private Nombre nombre;
    private int age;
    private String nif;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
        this.nif = generaNif();
    }

    public Persona() {
        
    }

    @Override
    public String toString() {
        if (name == null) {
            return "Persona{" + "name=" + nombre + ", age=" + age + ", nif=" + nif + '}';
        }
        return "Persona{" + "name=" + name + ", age=" + age + ", nif=" + nif + '}';

    }

    private String generaNif() {
        Random rand = new Random();
        int numRand = rand.nextInt(99999999 + 1);
        String nif = "" + numRand;
        numRand = Math.round(numRand % 23);
        String letras = "TRWAGMYFPDXBNJZSQVHLCK";
        char letraNif = letras.charAt(numRand);
        nif += letraNif;
        return nif;
    }

    private Nombre generaNombre() { //генерирует имя из enum
        Random rand = new Random();
        int numRand = rand.nextInt(4);
        return Nombre.values()[numRand];
    }

    public String getNif() {
        return nif;
    }

    public int getAge() {
        return age;
    }

}

enum Nombre {
    JUAN,
    EDUARDO,
    ANTONIO,
    JOSH,
    Carlos,
    Mike
}
