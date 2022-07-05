package com.barBossHouse;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private Dish[] dishes;
    private int amountOrderedDishes;
    private static int AMOUNT_OF_DISHES = 16;


    //Конструктор не принимающий параметров, инициирующий массив из 16 элементов??
    public Order() {
        this(new Dish[AMOUNT_OF_DISHES]);
        // this.dishes = new Dish[AMOUNT_OF_DISHES];
    }

    //Конструктор принимает целое число–емкость массива, инициирующий массив указанным числом элементов
    public Order(int amountDishes) {
        this(new Dish[amountDishes]);
        // this.dishes = new Dish[amountDishes];
    }

    // Конструктор принимает массив блюд.
    public Order(Dish[] dishes) {
        this.dishes = dishes;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public void setDishes(Dish[] dishes) {
        this.dishes = dishes;
    }

    public int getAmountOrderedDishes() {
        return amountOrderedDishes;
    }

    public void setAmountOrderedDishes(int amountOrderedDishes) {
        this.amountOrderedDishes = amountOrderedDishes;
    }

    //Метод добавляет блюдо в заказ
    public boolean addDish(Dish dish) {
        int length = dishes.length;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null) {
                dishes[i] = dish;
                return true;
            }
        }
        Dish[] dishes1 = new Dish[length * 2];
        System.arraycopy(dishes, 0, dishes1, 0, length);
        for (int i = 0; i < dishes1.length; i++) {
            if (dishes1[i] == null) {
                dishes1[i] = dish;
                break;
            }
        }
        dishes = dishes1;
        return true;
    }

    // Метод удаляющий блюдо из заказа по его названию(общий)
    public int deleteDish(boolean isFree, String name) {
        int numOfDelete = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null && dishes[i].getNameOfDish().equals(name)) {
                dishes[i] = null;
                numOfDelete++;
                if (isFree) return numOfDelete;
            }
        }
        return numOfDelete;
    }

    // Метод удаляющий блюдо из заказа по его названию
    public boolean deleteOneDish(String name) {
        if (deleteDish(true, name) == 1) return true;
        return false;
    }

    //Метод удаляет все блюда с заданным именем
    public int deleteDishes(String name) {
        return deleteDish(false, name);
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
        Dish[] dishes1 = new Dish[generalAmountOfDishes()];
        int j = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null)
                continue;
            dishes1[j++] = dishes[i];

        }
        dishes = dishes1;
        return dishes;
    }

    //Метод возвращающий общую стоимость заказа
    public int generalCostOfOrder() {
        int sumOfCost = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null)
                sumOfCost += dishes[i].getCostOfDish();
        }
        return sumOfCost;
    }

    //Метод возвращающий число заказанных блюд
    public int numOfOrderedDishes(String name) {
        int amountOfDishes = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null && dishes[i].getNameOfDish().equals(name))
                amountOfDishes++;
        }
        return amountOfDishes;
    }

    // Метод возвращающий массив названий заказанных блюд??
    public String[] arrayNameOfDish() {
        String[] names = new String[dishes.length]; // создаем пустой массив с длиной массива дишес
        int count = 0;                       // создаем счетчик элементов для массива нэймс
        for (Dish dish : dishes) {    //перебирвем массив дищес
            if (dish == null) continue;
            boolean isContains = false;
            for (String name : names) {   //перебираем массив имена
                if (name == null)
                    continue; // если именя итое равно нул, то дольше и по идее этот цикло фор просто проходит и изсонтант должа остать фолс
                if (dish.getNameOfDish().equals(name)) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) {
                names[count++] = dish.getNameOfDish();
            }
        }
        String[] namesWithoutNull = new String[count];
        System.arraycopy(names, 0, namesWithoutNull, 0, count);
        return namesWithoutNull;
    }
//

    // Метод возвращает массив блюд, отсротированный по убыванию цены
    public Dish[] sortDownCost() {
        Dish[] dishes = arrayOfDish();
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