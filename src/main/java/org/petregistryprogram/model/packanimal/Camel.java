package org.petregistryprogram.model.packanimal;

import org.petregistryprogram.model.PackAnimal;

import java.time.LocalDate;
import java.util.List;

public class Camel extends PackAnimal<CamelCommand> {
    public Camel(String name, LocalDate birthday, List<CamelCommand> command) {
        super(name, birthday, command);
        setTypePackAnimal(TypePackAnimal.Camel);
    }
}
