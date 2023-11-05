package org.petregistryprogram.view.commands;

import org.petregistryprogram.view.ConsoleUI;

public class AddAnimal implements Command {
    private ConsoleUI consoleUI;

    public AddAnimal(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить животное";
    }

    @Override
    public void execute() {
        consoleUI.addAnimal();
    }
}