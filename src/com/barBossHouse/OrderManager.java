/*package com.barBossHouse;

public class OrderManager {
    private Order[] orders;

    // Конструктор принимает число столиков, инициализирует массив элементов
    public OrderManager(int numOfTables) {
        this.orders = new Order[numOfTables];
    }

    public Order[] getOrders() {
        return orders;
    }

    // Метод добавляет заказ столику, принимая номер стола и ссылку на заказ
    public void setOrder(int numOfTable, Order order) {
        if (numOfTable >= 0 && numOfTable < orders.length) {
            orders[numOfTable] = order;
        } else {
            System.out.println("Ошибка: нет такого номера столика");
        }
    }


    //  Метод получает заказ столика по его номеру
    public Order getOrder(int numOfTable) {
        if (numOfTable < 0 || numOfTable >= orders.length) {
            System.out.println("Ошибка: нет такого номера столика");
            return null;
        }
        return orders[numOfTable];
    }

    // Метод освобождает столик
    public void setTableFree(int numOfTable) {
        if (numOfTable >= 0 && numOfTable < orders.length)
            orders[numOfTable] = null;
        else {
            System.out.println("Ошибка: нет такого номера столика");
        }
    }

    // Метод возвращает номер первого свободного стола
    public int numOfFreeTable() {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                return i;
            }
        }
        System.out.println("Ошибка:нет свободного стола");
        return -1;
    }

    public int[] numberTables(boolean isFree) {
        int freeOrderCount = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)
                freeOrderCount++;
        }
        if (isFree) {
            if (freeOrderCount == 0) {
                System.out.println("Ошибка:нет свободных столиков");
                return null;
            }
        } else {
            if (freeOrderCount == orders.length) {
                System.out.println("Ошибка:нет занятых столиков");
                return null;
            }
        }
        int[] numbOfTables;
        if (isFree) {
            numbOfTables = new int[freeOrderCount];
        } else {
            numbOfTables = new int[orders.length - freeOrderCount];
        }
        int j = 0;
        for (int i = 0; i < orders.length; i++) {
            if (isFree) {
                if (orders[i] == null)
                    numbOfTables[j++] = i;
            } else {
                if (orders[i] != null)
                    numbOfTables[j++] = i;
            }
        }
        return numbOfTables;
    }


    //Метод возвращает массив номеров свободных столиков
    public int[] numbersOfFreeTables() {
        return numberTables(true);
    }

    // Метод возвращает массив номеров занятых столов
    public int[] numbersOfOccupiedTables() {
        return numberTables(false);
    }

    // Метод возвращает массив имеющихся на данный момент заказов
    public Order[] arrayOfOrder() {
        int amountOfOrders = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null)
                amountOfOrders++;
        }
        Order[] orders1 = new Order[amountOfOrders];
        int j = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)
                continue;
            orders1[j] = orders[i];
            j++;
        }
        orders = orders1;
        return orders;
    }

    // Метод возвращает суммарную стоимост имеющихся на данный момент заказов
    public int getCostAllOrders() {
        int costAllOrders = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                costAllOrders += orders[i].generalCostOfOrder();
            }
        }
        return costAllOrders;
    }

    // Метод возвращает количество порций определенного блюда
    public int getNumOrderedDish(String dishName) {
        int numOrderedDish = 0;

        if (dishName == null)
            return 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)
                continue;
            numOrderedDish += orders[i].numOfOrderedDishes(dishName);

        }
        return numOrderedDish;
    }
}*/