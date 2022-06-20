package com.barBossHouse;

public class OrderManager {
    Order[] orders;

    // Конструктор принимает число столиков, инициализирует массив элементов
    public OrderManager(int numOfTables) {
        this.orders = new Order[numOfTables];
    }

    // Метод добавляет заказ столику, принимая номер стола и ссылку на заказ
    public void setOrder(int numOfTable, Order order) {
        if (numOfTable >= 0 && numOfTable < orders.length)
            orders[numOfTable] = order;
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

    //Метод возвращает массив номеров свободных столиков
    public int[] numbersOfFreeTables() {
        int lengthNewArray = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)
                lengthNewArray++;
        }
        if (lengthNewArray == 0) {
            System.out.println("Ошибка:нет свободных столиков");
            return null;
        }
        int[] FreeNumOfTables = new int[lengthNewArray];
        int j = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                FreeNumOfTables[j] = i;
            }
            j++;

        }
        return FreeNumOfTables;
    }

    // Метод возвращает массив номеров занятых столов
    public int[] numbersOfOccupiedTables() {
        int lengthNewArr = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null)
                lengthNewArr++;
        }
        if (lengthNewArr == 0) {
            System.out.println("Ошибка:нет занятых столиков");
            return null;
        }
        int[] OccupiedNumOfTables = new int[lengthNewArr];
        int j = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                OccupiedNumOfTables[j] = i;
            }
            j++;

        }
        return OccupiedNumOfTables;
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
                costAllOrders = costAllOrders + orders[i].generalCostOfOrder();
            }
        }
        return costAllOrders;
    }

    // Метод возвращает количество порций определенного блюда
    public int getNumOrderedDish(String dishName) {
        int numOrderedDish = 0;
        //int j =0;
        if (dishName != null) {
            for (int i = 0; i < orders.length; i++) {
                if (orders[i] != null) {
                    for (int j = 0; j < orders[i].getDishes().length; j++) {
                        if (orders[i].getDishes()[j].getNameOfDish().equals(dishName)) {
                            numOrderedDish++;
                        }
                    }
                }
            }
        }
        return numOrderedDish;
    }
}