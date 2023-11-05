package org.petregistryprogram.model;

import java.util.ArrayList;
import java.util.List;

public class PackAnimalBase {
    List<PackAnimal> listPackAnimals;
    public PackAnimalBase() {
        this.listPackAnimals = new ArrayList<>();
    }

    public void addPackAnimal(PackAnimal packAnimal) {
        listPackAnimals.add(packAnimal);
    }

    public void modPackAnimal(int id, PackAnimal packAnimal) {
        listPackAnimals.set(id, packAnimal);
    }

    public String getPackAnimal(int id) {
        return listPackAnimals.get(id).getInfoPackAnimal();
    }

    public String infoPackAnimalBase() {
        String str = "id\t | \t" +
//                "Тип Животного   \t | \t" +
                "Назв.\t | \t" +
                "Имя\t | \t" +
                "ДатаРождения\t | \t" +
                "Команды \n";
        int index = 1;
        for (PackAnimal packAnimal: listPackAnimals) {
            str += index + "\t | \t";
//            str += "Вьючное животное" + "\t | \t";
            str += packAnimal.getInfoPackAnimal();
            index++;
        }
        return str;
    }
}
