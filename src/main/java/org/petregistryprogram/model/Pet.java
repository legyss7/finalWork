package org.petregistryprogram.model;

import org.petregistryprogram.model.pet.TypePet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Pet<C> extends Animal {
    private Integer petIdAnimal;
    static Integer petId = 0;
    private TypePet type;
    private String name;
    private LocalDate birthday;
    private List<C> commands;


    public Pet(String name, LocalDate birthday, List<C> commands) {
        setPetId();
        setPetIdAnimal();
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public Pet() {

    }

    public void setPetIdAnimal() {
        this.petIdAnimal = id++;
    }
    public void setPetId() {
        this.petId++;
    }
    public void setTypePet(TypePet type) {
        this.type = type;
    }
    public String getId() {
        return this.petId.toString();
    }
    public String getTypePet() {
        return this.type.toString();
    }
    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.birthday.format(pattern).toString();
    }

    public String getCommand() {
        String str = "";
        for (C command : this.commands) {
           str += command.toString() + " ";
        }
        return str;
    }

    public String getInfoPet() {
        return
//                getId() + ", " +
                getTypePet() + "\t | \t"
                + getName() + "\t | \t"
                + getBirthday() + "\t | \t"
                + getCommand() + "\n";
    }
}
