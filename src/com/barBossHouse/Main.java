package com.barBossHouse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dish dish1 = new Dish("Винегрет", "Салат");
        Dish dish2 = new Dish(120, "Борщ", "Суп");
        Dish dish3 = new Dish("Оливье", "Салат");
        Dish dish4 = new Dish(120, "Борщ", "Суп");
        Drink drink1 = new Drink(200,"rum1",DrinkTypeEnum.RUM,"Ром 15летней выдержки",40.2f);
        Drink drink2 = new Drink(150,"rum1",DrinkTypeEnum.RUM,"Ром 5летней выдержки",40.2f);

        MenuItem[] menuItems = {dish1,dish2,drink1};
        Address address = new Address("Samara","Pobeda",444555,69,"A",125);
        System.out.println(address);
        Address address1 = new Address("Samara","Pobeda",444555,125,"A",69);
        System.out.println(address.hashCode());
        System.out.println(address1.hashCode());
        System.out.println(address.equals(address1));
        Customer customer = new Customer("Vova","Ivanov",34,address);
        System.out.println(customer);
        MenuItem[] menuItems1 = {dish1,dish2,drink1};
       TableOrder order = new TableOrder(menuItems,customer);
        System.out.println(order.getMenuItems().length);
        System.out.println(order.addMenuItem( (MenuItem) dish3)) ;
        System.out.println(order.getMenuItems().length);
        System.out.println(order);
        order.sortDownCost();
        System.out.println(order);
        TableOrder order1 = new TableOrder(menuItems,customer);
        System.out.println(order1.addMenuItem( (MenuItem) dish3)) ;
        System.out.println(order.equals(order1));
        System.out.println(order.hashCode());
        System.out.println(order1.hashCode());

        System.out.println();
//       System.out.println(order.deleteOneDish("мимоза"));
//        order.showAllDishes();
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
      // System.out.println(Arrays.toString(order.arrayNameOfDish()));
//        System.out.println();
//        OrderManager orderManager = new OrderManager(3);
//       orderManager.setOrder(0,order);
//        orderManager.setOrder(1,order);
     //   orderManager.setOrder(3,order);
       // System.out.println(Arrays.toString(orderManager.numbersOfFreeTables()));
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
    }
}
