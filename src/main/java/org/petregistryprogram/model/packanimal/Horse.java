package org.petregistryprogram.model.packanimal;

import org.petregistryprogram.model.PackAnimal;

import java.time.LocalDate;
import java.util.List;

public class Horse extends PackAnimal<HorseCommand> {
    public Horse(String name, LocalDate birthday, List<HorseCommand> command) {
        super(name, birthday, command);
        setTypePackAnimal(TypePackAnimal.Horse);
    }
}
