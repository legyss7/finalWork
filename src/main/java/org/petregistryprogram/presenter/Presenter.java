package org.petregistryprogram.presenter;

import org.petregistryprogram.model.Pet;
import org.petregistryprogram.model.PetsBase;
import org.petregistryprogram.model.Service;
import org.petregistryprogram.model.pet.CatCommand;


import java.util.List;
import java.util.Map;

public class Presenter {
    private Service service;

    public Presenter() {
        service = new Service();
    }

    public void addAnimal(Map<String, String> dataAnimal, List<String> commandAnimal) {
        service.addAnimal(dataAnimal, commandAnimal, 0, false);
    }
    public String getPetsList(){
        return service.getPets();
    }
    public String getPackAnimalList(){
        return service.getPackAnimals();
    }

    public void setChangeAnimalDetails(int id, Map<String, String> dataAnimal, List<String> commandAnimal) {
        service.addAnimal(dataAnimal, commandAnimal, id, true);
    }
    public String getPet(int id) {
        return service.getPet(id);
    }
    public String getPackAnima(int id) {
        return service.getPackAnimal(id);
    }

}
