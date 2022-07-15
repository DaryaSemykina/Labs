package com.barBossHouse;

public class Dish extends MenuItem {
    //Конструкцтор, принимающий два параметра – название и описание. Стоимость при этом 
    //инициализируется значением 0                                                      
    public Dish(String nameOfDish, String descriptionOfDish) {
        super(nameOfDish, descriptionOfDish);

    }

    //Конструкцтор,  принимающий три параметра – стоимость, название и описание.
    public Dish(int costOfDish, String nameOfDish, String descriptionOfDish) {
        super(costOfDish, nameOfDish, descriptionOfDish);
    }

    //Переопрделенный метод toString()
    @Override
    public String toString() {
        String str = "\"Dish: ";
        if (getNameOfDish() != null) str += "<" + getNameOfDish() + ">, ";
        str += "<" + getCostOfDish() + ">p. ";
        if (getDescriptionOfDish() != null) str += "<" + getDescriptionOfDish() + ">";
        str += "\"";
        return str;
    }

    //Переопрделенный метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dish dish = (Dish) obj;
        if (this.getCostOfDish() != dish.getCostOfDish()) return false;
        return this.getNameOfDish().equals(dish.getNameOfDish());
    }

    //Переопрделенный метод hashCode
        @Override
        public int hashCode() {
            return getNameOfDish().hashCode()^getDescriptionOfDish().hashCode()^getCostOfDish();
        }
}



