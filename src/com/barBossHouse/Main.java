package com.barBossHouse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dish dish1 = new Dish(90, "Винегрет", "Салат");
        Dish dish2 = new Dish(120, "Борщ", "Суп");
        Dish dish3 = new Dish("Оливье", "Салат");
        Dish dish4 = new Dish(120, "Борщ", "Суп");

        Dish[] dishes = {dish1, dish2, dish3, dish4};

        Order order = new Order(dishes);
        System.out.println(order.dishes.length);
        order.showAllDishes();
        order.addDish(new Dish(150, "Пицца", "Закуска"));
        order.addDish(new Dish(150, "Пицца", "Закуска"));
        order.addDish( new Dish("Оливье", "Салат"));
        //System.out.println(order.dishes.length);
       // order.showAllDishes();
        System.out.println();
         //order.deleteDishes("Борщ");
        order.showAllDishes();
        dishes =order.arrayOfDish();
        order.showAllDishes();
        System.out.println( order.numOfOrderedDishes("Оливье"));

       // Order order1 = new Order(order.sortDownCost());
        dishes =order.sortDownCost();
        order.showAllDishes();
        System.out.println();
        System.out.println(Arrays.toString(order.arrayNameOfDish()));
//        System.out.println();
//        OrderManager orderManager = new OrderManager(3);
//        orderManager.setOrder(0,order);
//        orderManager.setOrder(1,order);
//        orderManager.setOrder(3,order);
//        System.out.println(orderManager.numOfFreeTable());
//        System.out.println(orderManager.getCostAllOrders());
//        System.out.println(orderManager.getNumOrderedDish("Борщ"));
    }
}
