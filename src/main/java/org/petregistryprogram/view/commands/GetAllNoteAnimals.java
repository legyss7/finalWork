package org.petregistryprogram.view.commands;

import org.petregistryprogram.view.ConsoleUI;

public class GetAllNoteAnimals implements Command {
    private ConsoleUI consoleUI;

    public GetAllNoteAnimals(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Показать все записи о животных";
    }

    @Override
    public void execute() {
        consoleUI.getAllNote();
    }
}
