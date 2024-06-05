package ru.practicum.dinner;


import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType;
    ArrayList<ArrayList<String>> comboList;

    DinnerConstructor() {
        dishesByType = new HashMap<>();
        comboList = new ArrayList<>();
    }

    void newDish(String dishType, String dishName) {
        if (dishesByType.containsKey(dishType)) {
            ArrayList<String> dishes = dishesByType.get(dishType);
            if (dishes.contains(dishName)) {
                System.out.println("Такое блюдо уже есть в списке");
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
            for (String dish : dishesInType) {
                System.out.println("Наименование: " + dish);
            }
        }
    }

    ArrayList<ArrayList<String>> creatingСombinations(int numberOfCombos, ArrayList<String> listOfTypes) {

    }

    boolean checkType(String type) {
        boolean
        return
    }

    void printListOfTypes(ArrayList<String> listOfTypes) {
        for (String type : listOfTypes) {
            System.out.println(type);
        }
    }
}
