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
        }
    }

    void creatingCombinations(int numberOfCombos, ArrayList<String> listOfTypes) {

        for (int i = 1; i <= numberOfCombos; i++) {
            HashMap<String, String> comboDishes = new HashMap<>();
            for (String type : listOfTypes) {
                ArrayList<String> dishesInType = dishesByType.get(type);
                int dishNumber = new Random().nextInt(dishesInType.size());
              // System.out.println(dishNumber); //проверка, удалить в итоговом
                String dish = dishesInType.get(dishNumber);
              //   System.out.println(dish); //проверка, удалить в итоговом
                comboDishes.put(type, dish);
                 }
                comboList.add(comboDishes);


            /*for (String key : comboDishes.keySet()) { //проверка, удалить в итоговом
                System.out.println(key);
                 }
            for (String value : comboDishes.values()) {
                System.out.println(value);
            }*/

        }
        System.out.println(comboList);
        System.out.println("Возможные комбинации: ");
        for (int j = 0; j < comboList.size(); j++) {
            System.out.println("Комбо " + (j + 1) + " :");
            System.out.println(comboList.get(j));
        }
        dishesByType.clear();
    }

    boolean checkType(String dishType) {
        boolean result = false;
        if (dishesByType.containsKey(dishType)) {
            result = true;
        }
        return result;
    }

    boolean chekList() {
        boolean result = false;
        if (!dishesByType.isEmpty()) {
            result = true;
        } return result;
    }

    void printListOfTypes(ArrayList<String> listOfTypes) {
        System.out.println("Комбинации из: ");
        for (String type : listOfTypes) {
            System.out.println(type);
        }
    }
}
