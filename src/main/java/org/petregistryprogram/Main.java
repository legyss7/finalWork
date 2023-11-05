package org.petregistryprogram;

import org.petregistryprogram.view.ConsoleUI;
import org.petregistryprogram.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
