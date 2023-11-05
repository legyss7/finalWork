package org.petregistryprogram.view.commands;

import org.petregistryprogram.view.ConsoleUI;

public class ChangeAnimalDetails implements Command {
    private ConsoleUI consoleUI;

    public ChangeAnimalDetails(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }
    @Override
    public String getDescription() {
        return "Изменить данные о животном";
    }

    @Override
    public void execute() {
        consoleUI.changeAnimalDetails();
    }
}
