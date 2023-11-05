package org.petregistryprogram.model;

import org.petregistryprogram.model.packanimal.Camel;
import org.petregistryprogram.model.packanimal.CamelCommand;
import org.petregistryprogram.model.packanimal.Horse;
import org.petregistryprogram.model.packanimal.HorseCommand;
import org.petregistryprogram.model.pet.Cat;
import org.petregistryprogram.model.pet.CatCommand;
import org.petregistryprogram.model.pet.Dog;
import org.petregistryprogram.model.pet.DogCommand;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Service {
    PetsBase petsList;
    PackAnimalBase packAnimalList;


    public Service() {
        this.petsList = new PetsBase();
        this.packAnimalList = new PackAnimalBase();
    }

    public int addAnimal(Map<String, String> dataAnimal, List<String> commandAnimal, int id, boolean replacement) {
        String typeAnimal = dataAnimal.get("typeAnimal");
        String denominationAnimal = dataAnimal.get("denominationAnimal");
        int status = 0;
        switch (typeAnimal) {
            case ("Pet"):
                switch (denominationAnimal) {
                    case ("Cat"):
                        addCat(dataAnimal, commandAnimal, id, replacement);
                        break;
                    case ("Dog"):
                        addDog(dataAnimal, commandAnimal, id, replacement);
                        break;
                    default:
                        status = -2;
                        break;
                }
                break;
            case ("PackAnimal"):
                switch (denominationAnimal) {
                    case ("Horse"):
                        addHorse(dataAnimal, commandAnimal, id, replacement);
                        break;
                    case ("Camel"):
                        addCamel(dataAnimal, commandAnimal, id, replacement);
                        break;
                    default:
                        status = -3;
                        break;
                }
                break;
            default:
                status = -1;
                break;
        }
        return status;
    }

    public void addCat(Map<String, String> dataAnimal, List<String> commandAnimal, int id, boolean replacement) {
        List<CatCommand> catCommands = new ArrayList<>();
        for (String commandString : commandAnimal) {
            switch (commandString) {
                case ("Сидеть"):
                    catCommands.add(CatCommand.Sit);
                    break;
                case ("Атаковать"):
                    catCommands.add(CatCommand.Pounce);
                    break;
                case ("Царапать"):
                    catCommands.add(CatCommand.Scratch);
                    break;
                case ("Мяукать"):
                    catCommands.add(CatCommand.Meow);
                    break;
                case ("Прыгать"):
                    catCommands.add(CatCommand.Jump);
                    break;
                default:
                    break;
            }
        }
        String name = dataAnimal.get("name");
        LocalDate localDate = LocalDate.parse(dataAnimal.get("year")
                + dataAnimal.get("month") + dataAnimal.get("day"));
        Cat cat = new Cat(name, localDate, catCommands);
        if (replacement) {
            petsList.modPet(id, cat);
        } else {
            petsList.addPet(cat);
        }
    }

    public void addDog(Map<String, String> dataAnimal, List<String> commandAnimal, int id, boolean replacement) {
        List<DogCommand> dogCommands = new ArrayList<>();
        for (String commandString : commandAnimal) {
            switch (commandString) {
                case ("Сидеть"):
                    dogCommands.add(DogCommand.Sit);
                    break;
                case ("Стоять"):
                    dogCommands.add(DogCommand.Stay);
                    break;
                case ("Принести"):
                    dogCommands.add(DogCommand.Fetch);
                    break;
                case ("Лапа"):
                    dogCommands.add(DogCommand.Paw);
                    break;
                case ("Лай"):
                    dogCommands.add(DogCommand.Bark);
                    break;
                case ("Крутиться"):
                    dogCommands.add(DogCommand.Roll);
                    break;
                default:
                    break;
            }
        }
        String name = dataAnimal.get("name");
        LocalDate localDate = LocalDate.parse(dataAnimal.get("year")
                + dataAnimal.get("month") + dataAnimal.get("day"));
        Dog dog = new Dog(name, localDate, dogCommands);
        if (replacement) {
            petsList.modPet(id, dog);
        } else {
            petsList.addPet(dog);
        }
    }

    public void addHorse(Map<String, String> dataAnimal, List<String> commandAnimal, int id, boolean replacement) {
        List<HorseCommand> horseCommands = new ArrayList<>();
        for (String commandString : commandAnimal) {
            switch (commandString) {
                case ("Рысь"):
                    horseCommands.add(HorseCommand.Trot);
                    break;
                case ("Прыжок"):
                    horseCommands.add(HorseCommand.Jump);
                    break;
                case ("Галоп"):
                    horseCommands.add(HorseCommand.Gallop);
                    break;
                default:
                    break;
            }
        }
        String name = dataAnimal.get("name");
        LocalDate localDate = LocalDate.parse(dataAnimal.get("year")
                + dataAnimal.get("month") + dataAnimal.get("day"));
        Horse horse = new Horse(name, localDate, horseCommands);
        if (replacement) {
            packAnimalList.modPackAnimal(id, horse);
        } else {
            packAnimalList.addPackAnimal(horse);
        }
    }

    public void addCamel(Map<String, String> dataAnimal, List<String> commandAnimal, int id, boolean replacement) {
        List<CamelCommand> camelCommands = new ArrayList<>();
        for (String commandString : commandAnimal) {
            switch (commandString) {
                case ("Сидеть"):
                    camelCommands.add(CamelCommand.Sit);
                    break;
                case ("Ходить"):
                    camelCommands.add(CamelCommand.Walk);
                    break;
                case ("Нести груз"):
                    camelCommands.add(CamelCommand.CarryLoad);
                    break;
                case ("Бегать"):
                    camelCommands.add(CamelCommand.Run);
                    break;
                default:
                    break;
            }
        }
        String name = dataAnimal.get("name");
        LocalDate localDate = LocalDate.parse(dataAnimal.get("year")
                + dataAnimal.get("month") + dataAnimal.get("day"));
        Camel camel = new Camel(name, localDate, camelCommands);
        if(replacement) {
            packAnimalList.modPackAnimal(id, camel);
        } else {
            packAnimalList.addPackAnimal(camel);
        }
    }

    public String getPets() {
        return petsList.infoPetsBase();
    }

    public String getPackAnimals() {
        return packAnimalList.infoPackAnimalBase();
    }

    public String getPet(int id) {
        return petsList.getPet(id);
    }

    public String getPackAnimal(int id) {
        return packAnimalList.getPackAnimal(id);
    }

}
