package ru.practicum.dinner;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType;
    ArrayList<HashMap<String, String>> comboList;

    DinnerConstructor() {
        dishesByType = new HashMap<>();
        comboList = new ArrayList<>();
    }

    void newDish(String dishType, String dishName) {
        if (dishesByType.containsKey(dishType)) {
            ArrayList<String> dishes = dishesByType.get(dishType);
            if (dishes.contains(dishName)) {
                System.out.println("Такое блюдо уже есть в списке");
                System.out.println("");
                printAllDishesByType();
            } else {
                dishes.add(dishName);
                printAllDishesByType();
            }
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByType.put(dishType, dishes);
            printAllDishesByType();
        }
    }


    void printAllDishesByType() {
        System.out.println("Блюда по категориям: ");
        for (String type : dishesByType.keySet()) {
            System.out.println("Тип блюда: " + type);
            ArrayList<String> dishesInType = dishesByType.get(type);
            System.out.println("Наименование: ");
            for (String dish : dishesInType) {
                System.out.println(dish);
            }
            System.out.println("");
        }
    }

    void creatingCombinations(int numberOfCombos, ArrayList<String> listOfTypes) {

        for (int i = 1; i <= numberOfCombos; i++) {
            HashMap<String, String> comboDishes = new HashMap<>();
            for (String type : listOfTypes) {
                ArrayList<String> dishesInType = dishesByType.get(type);
                int dishNumber = new Random().nextInt(dishesInType.size());
                String dish = dishesInType.get(dishNumber);
                comboDishes.put(type, dish);
            }
            comboList.add(comboDishes);
        }
        printComboLunch();
        dishesByType.clear();
    }

    boolean checkType(String dishType) {
        return dishesByType.containsKey(dishType);
    }

    boolean checkList() {
        return !dishesByType.isEmpty();
    }

    void printListOfTypes(ArrayList<String> listOfTypes) {
        System.out.println("Комбинации из: ");
        for (String type : listOfTypes) {
            System.out.println(type);
        }
        System.out.println("");
    }

    void printComboLunch() {
        System.out.println("Возможные комбинации блюд: ");
        for (int j = 0; j < comboList.size(); j++) {
            System.out.println("Комбо " + (j + 1) + ":");
            HashMap<String, String> comboDishes = comboList.get(j);
            for (String dish : comboDishes.values()) {
                System.out.println(dish);
            }
        }
        System.out.println("");
    }
}
