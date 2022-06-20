package com.barBossHouse;

import java.util.HashSet;
import java.util.Set;

public class Order {
    Dish[] dishes;
    int amountOrderedDishes;
    final int AMOUNT_OF_DISHES = 16;

    //Конструктор не принимающий параметров, инициирующий массив из 16 элементов
    public Order() {

        this.dishes = new Dish[AMOUNT_OF_DISHES];
    }

    //Конструктор принимает целое число–емкость массива, инициирующий массив указанным числом элементов
    public Order(int amountDishes) {

        this.dishes = new Dish[amountDishes];
    }

    // Конструктор принимает массив блюд.
    public Order(Dish[] dishes) {

        this.dishes = dishes;
    }

    //Метод добавляет блюдо в заказ
    public boolean addDish(Dish dish) {
        boolean hasNull = false;
        int length = dishes.length;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null) {
                dishes[i] = dish;
                hasNull = true;
                break;
            }
        }
        if (hasNull == false) {
            Dish[] dishes1 = new Dish[length * 2];
            for (int i = 0; i < dishes.length; i++) {
                dishes1[i] = dishes[i];
            }
            for (int i = 0; i < dishes1.length; i++) {
                if (dishes1[i] == null) {
                    dishes1[i] = dish;
                    hasNull = true;
                    break;
                }
            }
            dishes = dishes1;
        }
        return hasNull;
    }

    // Метод удаляющий блюдо из заказа по его названию
    public boolean deleteOneDish(String nameO) {
        boolean wasDelete = false;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i].getNameOfDish().equals(nameO)) {
                dishes[i] = null;
                wasDelete = true;
                break;
            }
        }
        Dish[] dishes1 = new Dish[dishes.length];
        int j = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null)
                continue;
            dishes1[j] = dishes[i];
            j++;
        }
        dishes = dishes1;
        return wasDelete;
    }

    //Метод удаляет все блюда с заданным именем
    public int deleteDishes(String nameO) {
        int numOfDelete = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null) {
                if (dishes[i].getNameOfDish() == nameO) {
                    dishes[i] = null;
                    numOfDelete++;
                }
            }
        }
        Dish[] dishes1 = new Dish[dishes.length];
        int j = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null) {
                continue;
            }
            dishes1[j] = dishes[i];
            j++;
        }
        dishes = dishes1;
        return numOfDelete;
    }

    // Метод возвращающий общее число блюд
    public int generalAmountOfDishes() {
        int amountOfDishes = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null)
                amountOfDishes++;
        }
        return amountOfDishes;
    }

    // Метод возвращающий массив блюд
    public Dish[] arrayOfDish() {
        int amountOfDishes = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null)
                amountOfDishes++;
        }
        Dish[] dishes1 = new Dish[amountOfDishes];
        int j = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null)
                continue;
            dishes1[j] = dishes[i];
            j++;
        }
        dishes = dishes1;
        return dishes;
    }

    //Метод возвращающий общую стоимость заказа
    public int generalCostOfOrder() {
        int sumOfCost = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null)
                sumOfCost = sumOfCost + dishes[i].getCostOfDish();
        }
        return sumOfCost;
    }

    //Метод возвращающий число заказанных блюд
    public int numOfOrderedDishes(String nameO) {
        int amountOfDishes = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i].getNameOfDish().equals(nameO))
                amountOfDishes++;
        }
        return amountOfDishes;
    }

    // Метод возвращающий массив названий заказанных блюд??
    public String[] arrayNameOfDish() {
        int arrLength = 0;
        for (int i = 0; i < dishes.length; i++) {
            String name = dishes[i].getNameOfDish();
            arrLength++;
            for (int j = i + 1; j < dishes.length; j++) {
                if (name.equals(dishes[j].getNameOfDish())) {
                    arrLength--;
                    break;
                }
            }
        }
        String[] arrayNames = new String[arrLength];
        int num = 0;
        for (int i = 0; i < dishes.length; i++) {
            arrayNames[num] = dishes[i].getNameOfDish();
            for (int j = i + 1; j < dishes.length; j++) {
                if (arrayNames[num].equals(dishes[j].getNameOfDish())) {
                    num--;
                    break;
                }
            }
            num++;
        }
        return arrayNames;
    }

    // Метод возвращает массив блюд, отсротированный по убыванию цены
    public Dish[] sortDownCost() {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < dishes.length; i++) {
                Dish dish1 = dishes[i];
                if (dishes[i].getCostOfDish() > dishes[i - 1].getCostOfDish()) {
                    dishes[i] = dishes[i - 1];
                    dishes[i - 1] = dish1;
                    needIteration = true;
                }
            }
        }
        return dishes;
    }

    public void showAllDishes() {
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }
}