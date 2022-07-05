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
        System.out.println(order.getDishes().length);
        order.showAllDishes();
        order.addDish(new Dish(150, "Пицца", "Закуска"));
        order.addDish(new Dish(80, "мимоза", "Салат"));
        order.addDish( new Dish(80,"мимоза", "Салат"));
        System.out.println(order.getDishes().length);
        order.showAllDishes();
        System.out.println();
       System.out.println(order.deleteOneDish("мимоза"));
        order.showAllDishes();
//        System.out.println();
//         //order.deleteDishes("Борщ");
//        order.showAllDishes();
//        dishes =order.arrayOfDish();
//        order.showAllDishes();
    //    System.out.println( order.numOfOrderedDishes("Оливье"));
//
//       Order order1 = new Order(order.sortDownCost());
//        dishes =order.sortDownCost();
//        order.showAllDishes();
//        System.out.println();
       System.out.println(Arrays.toString(order.arrayNameOfDish()));
//        System.out.println();
        OrderManager orderManager = new OrderManager(3);
       orderManager.setOrder(0,order);
        orderManager.setOrder(1,order);
     //   orderManager.setOrder(3,order);
        System.out.println(Arrays.toString(orderManager.numbersOfFreeTables()));
//        System.out.println(orderManager.getCostAllOrders());
  //     System.out.println(orderManager.getNumOrderedDish("Борщ"));
//        Dish dish1 = new Dish(150,"Memoza", "Salad");
//        Dish dish2 = new Dish(600,"Crem", "Tort");
//        Dish dish3 = new Dish(60,"Hren", "Ovosh");
//        Dish dish4 = new Dish(1200,"Baran", "Myaso");
//        Dish dish5 = new Dish(5,"kislinka", "konfetka");
//
//        Dish[] dishes = {dish1, dish2, dish3, dish4, dish5};
//
//        Order order = new Order(dishes);
//        order.addDish(new Dish(450, "lol", "kek"));
//        System.out.println(Arrays.toString(order.sortDownCost()));
//        System.out.println(order.generalCostOfOrder());
//        System.out.println(Arrays.toString(order.arrayNameOfDish()));
Address address = new Address("Samara","Pobeda",444555,69,"A",125);
        System.out.println(address);
        Address address1 = new Address("Samara","Pobeda",444555,125,"A",69);
        System.out.println(address.hashCode());
        System.out.println(address1.hashCode());
        System.out.println(address.equals(address1));
Customer customer = new Customer("Vova","Ivanov",34,address);
        System.out.println(customer);
    }
}
