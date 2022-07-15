package com.barBossHouse;

public class TableOrder {

    private MenuItem[] menuItems;
    private int amountOrderedItems;
    private static int AMOUNT_OF_MENU_ITEMS = 16;
    //Добавьте приватное поле типа Customer (клиента) и соответствующие методы get и set.
    private Customer customer;

    //Конструктор не принимающий параметров, инициирующий массив из 16 элементов
    public TableOrder() {
        this(new MenuItem[AMOUNT_OF_MENU_ITEMS], null);

    }

    //Измените конструкторы – все, кроме конструктора по-умолчанию, должны принимать
//еще один параметр: ссылку на экземпляр класса Customer.
    //Конструктор принимает целое число–емкость массива, инициирующий массив указанным числом элементов
    public TableOrder(int amountItems, Customer customer) {
        this(new MenuItem[amountItems], customer);

    }

    // Конструктор принимает массив позиций и экземпляр класса Customer.
    public TableOrder(MenuItem[] menuItems, Customer customer) {
        this.menuItems = menuItems;
        this.customer = customer;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAmountOrderedItems() {
        return amountOrderedItems;
    }

    public void setAmountOrderedItems(int amountOrderedItems) {
        this.amountOrderedItems = amountOrderedItems;
    }

    //Метод добавляет блюдо в заказ
    public boolean addMenuItem(MenuItem menuItem) {
        int length = menuItems.length;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] == null) {
                menuItems[i] = menuItem;
                return true;
            }
        }
        MenuItem[] menuItems1 = new MenuItem[length * 2];
        System.arraycopy(menuItems, 0, menuItems1, 0, length);
        for (int i = 0; i < menuItems1.length; i++) {
            if (menuItems1[i] == null) {
                menuItems1[i] = menuItem;
                break;
            }
        }
        menuItems = menuItems1;
        return true;
    }

    // Метод удаляющий блюдо из заказа по его названию(общий)
    public int deleteMenuItemDish(boolean isFree, String name) {
        int numOfDelete = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null && menuItems[i].getNameOfDish().equals(name)) {
                menuItems[i] = null;
                numOfDelete++;
                if (isFree) return numOfDelete;
            }
        }
        return numOfDelete;
    }

    // Метод удаляющий блюдо из заказа по его названию
    public boolean deleteOneMenuItemDish(String name) {
        if (deleteMenuItemDish(true, name) == 1) return true;
        return false;
    }

    //Метод удаляет все блюда с заданным именем
    public int deleteMenuItemsDish(String name) {
        return deleteMenuItemDish(false, name);
    }

    // Метод возвращающий общее число блюд
    public int generalAmountOfMenuItems() {
        int amountOfMenuItems = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null)
                amountOfMenuItems++;
        }
        return amountOfMenuItems;
    }

    // Метод возвращающий массив блюд
    public MenuItem[] arrayOfMenuItem() {
        MenuItem[] menuItems1 = new MenuItem[generalAmountOfMenuItems()];
        int j = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] == null)
                continue;
            menuItems1[j++] = menuItems[i];

        }
        menuItems = menuItems1;
        return menuItems;
    }

    //Метод возвращающий общую стоимость заказа
    public int generalCostOfOrder() {
        int sumOfCost = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null)
                sumOfCost += menuItems[i].getCostOfDish();
        }
        return sumOfCost;
    }

    //Метод возвращающий число заказанных блюд по имени
    public int numOfOrderedMenuItemsName(String name) {
        int amountOfMenuItems = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null && menuItems[i].getNameOfDish().equals(name))
                amountOfMenuItems++;
        }
        return amountOfMenuItems;
    }

    // Метод возвращающий массив названий заказанных блюд??
    public String[] arrayNameOfMenuItem() {
        String[] names = new String[menuItems.length]; // создаем пустой массив с длиной массива дишес
        int count = 0;                       // создаем счетчик элементов для массива нэймс
        for (MenuItem menuItem : menuItems) {    //перебирвем массив дищес
            if (menuItem == null) continue;
            boolean isContains = false;
            for (String name : names) {   //перебираем массив имена
                if (name == null)
                    continue; // если именя итое равно нул, то дольше и по идее этот цикло фор просто проходит и изсонтант должа остать фолс
                if (menuItem.getNameOfDish().equals(name)) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) {
                names[count++] = menuItem.getNameOfDish();
            }
        }
        String[] namesWithoutNull = new String[count];
        System.arraycopy(names, 0, namesWithoutNull, 0, count);
        return namesWithoutNull;
    }
//

    // Метод возвращает массив блюд, отсротированный по убыванию цены
    public MenuItem[] sortDownCost() {
        MenuItem[] menuItems = arrayOfMenuItem();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < menuItems.length; i++) {
                MenuItem menuItem1 = menuItems[i];
                if (menuItems[i].getCostOfDish() > menuItems[i - 1].getCostOfDish()) {
                    menuItems[i] = menuItems[i - 1];
                    menuItems[i - 1] = menuItem1;
                    needIteration = true;
                }
            }
        }
        return menuItems;
    }

    // Метод удаляющий позицию или позиции из заказа(общий), принимает объект типа MenuItem
    public int deleteMenuItem(boolean isFree, MenuItem menuItem) {
        int numOfDelete = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null && menuItems[i].equals(menuItem)) {
                menuItems[i] = null;
                numOfDelete++;
                if (isFree) return numOfDelete;
            }
        }
        return numOfDelete;
    }

    // Метод удаляющий позицию из заказа сравнивая её с объктом типа MenuItem
    public boolean deleteOneMenuItem(MenuItem menuItem) {
        if (deleteMenuItem(true, menuItem) == 1) return true;
        return false;
    }

    //Метод удаляет все позиции сравнивая их с объктом типа MenuItem
    public int deleteMenuItems(MenuItem menuItem) {
        return deleteMenuItem(false, menuItem);
    }

    //Метод возвращающий число заказанных позиций  принимает объект типа MenuItem
    public int numOfOrderedMenuItems(MenuItem menuItem) {
        int amountOfMenuItems = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null && menuItems[i].equals(menuItem))
                amountOfMenuItems++;
        }
        return amountOfMenuItems;
    }

    //Переопрделенный метод toString()
    @Override
    public String toString() {
        this.arrayOfMenuItem();//почему это сработало
        String str = "\"TableOrder: <" + getMenuItems().length + ">\n";
        for (MenuItem menuItem : menuItems) {
            str += menuItem + "\n";
        }
        str += "\""; //спросить про структуры вывода(ковычки,знаки), почему правильно вывелась последняя строка с диш, если я приводила к типу MenuItem
        return str;
    }

    //Переопрделенный метод equals
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TableOrder order = (TableOrder) obj;
        order.sortDownCost();
        if (!this.getCustomer().equals(((TableOrder) obj).getCustomer())) return false;
        if (this.getMenuItems().length != order.getMenuItems().length) return false;
        for (int i = 0; i < this.getMenuItems().length; i++) {
            if (!this.getMenuItems()[i].equals(order.getMenuItems()[i])) return false;
        }return true;
    }
    //Переопрделенный метод hashCode
    @Override
    public int hashCode() {
        arrayOfMenuItem();
        int hash = getCustomer().hashCode();
        for (int i = 0; i < getMenuItems().length; i++) {
            hash = hash^getMenuItems()[i].hashCode();
        }
        return hash;
    }

    public void showAllMenuItems() {
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }
}