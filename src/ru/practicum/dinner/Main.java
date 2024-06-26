package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        System.out.println("");
        dc.newDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (!dc.isEmptyCheckList()) {
            System.out.println("Список блюд пуст. Введите данные");
            return;
        }
        ArrayList<String> listOfTypes = new ArrayList<>();
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Вы можете составить комбинации из следующих типов блюд:");
        dc.printAllDishesByType();
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                listOfTypes.add(nextItem);
                nextItem = scanner.nextLine();
            } else {
                System.out.println("Такого типа нет в списке");
                System.out.println("");
                break;
            }
        }
        dc.printListOfTypes(listOfTypes);
        dc.creatingCombinations(numberOfCombos, listOfTypes);
    }
}




