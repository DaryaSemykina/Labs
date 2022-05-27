package com.cafe;

public class Order {
    Dish[] dishes;
    int amountOrderedDishes;
    int AMOUNT_OF_DISHES = 16;
//Конструктор не принимающий параметров, инициирующий массив из 16 элементов
    public Order() {
        dishes = new Dish[AMOUNT_OF_DISHES];
    }
//Конструктор принимает целое число–емкость массива, инициирующий массив указанным числом элементов
    public Order(int amountDishes) {
        dishes = new Dish[amountDishes];
    }
// Конструктор принимает массив блюд.
    public Order(Order[] dishes) {
    }
//Метод добавляет блюдо в заказ
    public boolean addDish(Dish dish) {
        boolean hasNull = false;
        int length = dishes.length;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null) {
                dishes[i] = dish;
                hasNull = true;
            }
            break;
        }
        if (hasNull == false) {
            Dish[] dishes1 = new Dish[length * 2];
            dishes1 = dishes.clone();
            for (int i = 0; i < dishes1.length; i++) {
                if (dishes1[i] == null) {
                    dishes1[i] = dish;
                }
                break;
            }
            Dish[] dishes = dishes1;
        }
        return true;
    }
// Метод удаляющий блюдо из заказа по его названию
    public boolean deleteOneDish(String nameO) {
        boolean wasDelete = false;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i].nameOfDish.equals(nameO)) {
                dishes[i] = null;
                wasDelete = true;
            }
            break;
        }
        Dish[] dishes1 = new Dish[dishes.length];
        int j = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] == null)
                continue;
            dishes1[j] = dishes[i];
            j++;
        }
        Dish[] dishes = dishes1;
        return wasDelete;
    }
   //Метод удаляет все блюда с заданным именем
    public int deleteDishes(String nameO) {
        int numOfDelete = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i].nameOfDish.equals(nameO)) {
                dishes[i] = null;
                numOfDelete++;
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
        Dish[] dishes = dishes1;
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
    public Dish [] arrayOfDish(){
        int amountOfDishes = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null)
                amountOfDishes++;
        }
        Dish[] dishes1 = new Dish[amountOfDishes];
        int j =0;
        for (int i = 0; i < dishes.length; i++){
            if (dishes[i] == null)
                continue;
            dishes1[j] = dishes[i];
            j++;
        }
        Dish[] dishes = dishes1;
        return dishes;
    }
    //Метод возвращающий общую стоимость заказа
    public int generalCostOfOrder(){
        int sumOfCost = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i] != null)
                sumOfCost=dishes[i].costOfDish ;
        }
        return sumOfCost;
    }
    //Метод возвращающий число заказанных блюд
    public int numOfOrderedDishes(String nameO){
        int amountOfDishes = 0;
        for (int i = 0; i < dishes.length; i++) {
            if (dishes[i].nameOfDish.equals(nameO))
                amountOfDishes++;
        }
        return amountOfDishes;
    }
//    // Метод возвращающий массив названий заказанных блюд
//    public String [] arrayNameOfDish(){
//        String [] arrayNames;
//        for (int i = 0; i < dishes.length; i++) {
//            for (int j =0; )
//        }
//    }

}