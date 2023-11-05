package org.petregistryprogram.view;

import org.petregistryprogram.presenter.Presenter;

import java.util.*;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    private Map<String, String> dataAnimal;

    private List<String> commandAnimal;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
        dataAnimal = new HashMap<>();
        commandAnimal = new ArrayList<>();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        print("Программа-реестр домашних животных\n");
        while (work) {
            print(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                print("Ошибка ввода\n");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLineMenu(line)) {
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLineMenu(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void finish() {
        print("Программа завершила свою работу.\n");
        work = false;
    }

    public void addAnimal() {
        commandAnimal.clear();
        dataAnimal.clear();
        inputTypeAnimal();
        if (dataAnimal.get("typeAnimal") == "Pet") {
            inputDenominationPet();
        } else {
            inputDenominationPackAnimal();
        }
        inputDataAnimal();
        if(checkDataAddCommand()) {
            presenter.addAnimal(dataAnimal, commandAnimal);
        }
    }

    private boolean checkDataAddCommand() {
        if (checkInputName()) {
            if (checkInputDate()) {
                boolean work = true;
                while (work) {
                    if (inputCommandAnimal()) {
                        print("добавить ещё команду?");
                        print("1. Да");
                        print("2. Нет");
                        String line = scanner.nextLine();
                        if (line.matches("[1, 2]+")) {
                            if (Integer.parseInt(line) == 2) {
                                work = false;
                            }
                        }
                    } else {
                        print("Ошибка Ввода команды животного!\n");
                        print("Попробуйте снова!\n");
                    }
                }
                print("Запись добавлена \n");
                return true;

            } else {
                print("Ошибка Ввода даты рождения!\n");
                print("Попробуйте снова!\n");
            }
        } else {
            print("Ошибка Ввода!\n");
            print("Поля: Имя являются обязательными!\n");
            print("Попробуйте снова!\n");
        }
        return false;
    }

    private void inputTypeAnimal() {
        print("Выберите тип животного: ");
        print("1. Домашний питомец");
        print("2. Вьючное животное");

        String line = scanner.nextLine();
        if (line.matches("[1, 2]+")) {
            if (Integer.parseInt(line) == 1) {
                dataAnimal.put("typeAnimal", "Pet");
            } else {
                dataAnimal.put("typeAnimal", "PackAnimal");
            }
        } else {
            print("Ошибка При выборе типа животного!");
        }
    }

    private void inputDenominationPet() {
        print("Выберите название животного: ");
        print("1. Кошка");
        print("2. Собака");

        String line = scanner.nextLine();
        if (line.matches("[1-2]+")) {
            switch (Integer.parseInt(line)) {
                case (1):
                    dataAnimal.put("denominationAnimal", "Cat");
                    break;
                case (2):
                    dataAnimal.put("denominationAnimal", "Dog");
                    break;
            }
        } else {
            print("Ошибка При выборе названия животного!");
        }
    }

    private void inputDenominationPackAnimal() {
        print("Выберите название животного: ");
        print("1. Лошадь");
        print("2. Верблюд");

        String line = scanner.nextLine();
        if (line.matches("[1-2]+")) {
            switch (Integer.parseInt(line)) {
                case (1):
                    dataAnimal.put("denominationAnimal", "Horse");
                    break;
                case (2):
                    dataAnimal.put("denominationAnimal", "Camel");
                    break;
            }
        } else {
            print("Ошибка При выборе названия животного!");
        }
    }

    private void inputDataAnimal() {
        print("Введите имя: ");
        dataAnimal.put("name", scanner.nextLine());
        print("Введите дату рождения \n");
        print("Год: ");
        dataAnimal.put("year", scanner.nextLine());
        print("Месяц (цифрой): ");
        dataAnimal.put("month", scanner.nextLine());
        print("Число (месяца): ");
        dataAnimal.put("day", scanner.nextLine());
    }

    private boolean inputCommandAnimal() {
        print("Выберите команду которой обучено животное: ");
        print("1. Сидеть (для кошки, собаки, верблюда);");
        print("2. Атаковать; 3. Царапать; 4. Мяукать; 5. Прыгать (1-5 для кошки)");
        print("6. Стоять; 7. Принести; 8. Лапа; 9. Лай; 10. Катиться (1, 6-10 для собаки)");
        print("11. Рысь; 12. Прыжок; 13. Галоп (11-13 для лошади)");
        print("14. Ходить; 15. Нести груз; 16. Бегать (1, 14-16 для верблюда)");
        print("17. Животное ничего не умеет");

        String line = scanner.nextLine();
        if (line.matches("[1-9,10,11,12,13,14,15,16,17]+")) {
            switch (Integer.parseInt(line)) {
                case (1):
                    commandAnimal.add("Сидеть");
                    break;
                case (2):
                    commandAnimal.add("Атаковать");
                    break;
                case (3):
                    commandAnimal.add("Царапать");
                    break;
                case (4):
                    commandAnimal.add("Мяукать");
                    break;
                case (5):
                    commandAnimal.add("Прыгать");
                    break;
                case (6):
                    commandAnimal.add("Стоять");
                    break;
                case (7):
                    commandAnimal.add("Принести");
                    break;
                case (8):
                    commandAnimal.add("Лапа");
                    break;
                case (9):
                    commandAnimal.add("Лай");
                    break;
                case (10):
                    commandAnimal.add("Крутиться");
                    break;
                case (11):
                    commandAnimal.add("Рысь");
                    break;
                case (12):
                    commandAnimal.add("Прыжок");
                    break;
                case (13):
                    commandAnimal.add("Галоп");
                    break;
                case (14):
                    commandAnimal.add("Ходить");
                    break;
                case (15):
                    commandAnimal.add("Нести груз");
                    break;
                case (16):
                    commandAnimal.add("Бегать");
                    break;
                default:
                    commandAnimal.add("Нет");
                    break;
            }
            return true;
        } else {
            return false;
        }
    }


    private boolean checkInputName() {
        boolean checkFlag = true;
        if (!(dataAnimal.get("name") != "")) {
            checkFlag = false;
        }
        return checkFlag;
    }

    private boolean checkInputDate() {
        if (dataAnimal.get("year") != "" && dataAnimal.get("month") != "" && dataAnimal.get("day") != "") {
            String year = dataAnimal.get("year");
            String month = dataAnimal.get("month");
            String day = dataAnimal.get("day");
            if (Integer.parseInt(year) < 1000 || Integer.parseInt(year) > 10000) {
                return false;
            }
            if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12) {
                return false;
            }
            if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31) {
                return false;
            }

            if (Integer.parseInt(month) < 10) {
                month = "-0" + month;
            } else {
                month = "-" + month;
            }
            if (Integer.parseInt(day) < 10) {
                day = "-0" + day;
            } else {
                day = "-" + day;
            }
            dataAnimal.put("month", month);
            dataAnimal.put("day", day);
            return true;
        } else {
            return false;
        }
    }

    public void changeAnimalDetails() {
        commandAnimal.clear();
        dataAnimal.clear();
        inputTypeAnimal();
        int id = 0;
        if (dataAnimal.get("typeAnimal") == "Pet") {
            if (presenter.getPetsList() == "") {
                print("Список пуст!\n");
            } else {
                print(presenter.getPetsList());
                print("Выберите id редактируемого животного");
                id = Integer.parseInt(scanner.nextLine()) - 1;
                getPetInfo(id);
                inputDenominationPet();
            }
        } else {
            if (presenter.getPackAnimalList() == "") {
                print("Список пуст!\n");
            } else {
                print(presenter.getPackAnimalList());
                print("Выберите id редактируемого животного");
                id = Integer.parseInt(scanner.nextLine()) - 1;
                getPackAnimalInfo(id);
                inputDenominationPackAnimal();
            }
        }
        inputDataAnimal();
        if(checkDataAddCommand()) {
            presenter.setChangeAnimalDetails(id, dataAnimal, commandAnimal);
        }
    }

    public void getPetInfo(int id) {
        print(presenter.getPet(id));
    }

    public void getPackAnimalInfo(int id) {
        print(presenter.getPackAnima(id));
    }

    public void getAllNote() {
        print("Домашние питомцы");
        print(presenter.getPetsList());
        print("Вьючные животные");
        print(presenter.getPackAnimalList());
    }

}
