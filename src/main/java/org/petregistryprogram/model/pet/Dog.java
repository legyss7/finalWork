package org.petregistryprogram.model.pet;

import org.petregistryprogram.model.Pet;

import java.time.LocalDate;
import java.util.List;

public class Dog  extends Pet<DogCommand> {
    public Dog(String name, LocalDate birthday, List<DogCommand> command) {
        super(name, birthday, command);
        setTypePet(TypePet.Dog);
    }
}
