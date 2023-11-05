package org.petregistryprogram.model;

import org.petregistryprogram.model.packanimal.TypePackAnimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class PackAnimal<C> extends Animal {
    private Integer petIdAnimal;
    static Integer petId = 0;
    private TypePackAnimal type;
    private String name;
    private LocalDate birthday;
    private List<C> commands;


    public PackAnimal(String name, LocalDate birthday, List<C> commands) {
        setPackAnimalId();
        setPackAnimalIdAnimal();
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public PackAnimal() {

    }

    public void setPackAnimalIdAnimal() {
        this.petIdAnimal = id++;
    }

    public void setPackAnimalId() {
        this.petId++;
    }

    public void setTypePackAnimal(TypePackAnimal type) {
        this.type = type;
    }

    public String getId() {
        return this.petId.toString();
    }
    public String getTypePackAnimal() {
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

    public String getInfoPackAnimal() {
        return
//                getId() + ", "
                getTypePackAnimal() + "\t | \t"
                + getName() + "\t | \t"
                + getBirthday() + "\t | \t"
                + getCommand() + "\n";
    }
}
