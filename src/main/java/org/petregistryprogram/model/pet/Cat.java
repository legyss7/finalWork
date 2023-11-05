package org.petregistryprogram.model.pet;

import org.petregistryprogram.model.Pet;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Pet<CatCommand> {
    public Cat(String name, LocalDate birthday, List<CatCommand> command) {
        super(name, birthday, command);
        setTypePet(TypePet.Cat);
    }
}
