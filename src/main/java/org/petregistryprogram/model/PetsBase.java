package org.petregistryprogram.model;


import java.util.ArrayList;
import java.util.List;

public class PetsBase {
    List<Pet> listPets;
    public PetsBase() {
        this.listPets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        listPets.add(pet);
    }

    public void modPet(int id, Pet pet) {
        listPets.set(id, pet);
    }

    public String getPet(int id) {
        return listPets.get(id).getInfoPet();
    }

    public String infoPetsBase() {
        String str = "id\t | \t" +
//                "Тип Животного   \t | \t" +
                "Назв.\t | \t" +
                "Имя\t | \t" +
                "ДатаРождения\t | \t" +
                "Команды \n";
        int index = 1;
        for (Pet pet: listPets) {
            str += index + "\t | \t";
//            str += "Домашний питомец" + "\t | \t";
            str += pet.getInfoPet();
            index++;
        }
        return str;
    }

}
