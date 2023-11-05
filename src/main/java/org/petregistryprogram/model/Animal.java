package org.petregistryprogram.model;

public abstract class Animal {
    static Integer id = 1;
    public String getCountAnimal() {
        Integer i = id - 1;
        return i.toString();
    }
}
