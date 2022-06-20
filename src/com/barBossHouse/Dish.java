package com.barBossHouse;

public class Dish {
    private int costOfDish;
    private String nameOfDish;
    private String descriptionOfDish;

    //Конструктор принимает два параметра – название и описание блюда
    public Dish(String nameOfDish, String descriptionOfDish) {
        this.nameOfDish = nameOfDish;
        this.descriptionOfDish = descriptionOfDish;
        this.costOfDish = 0;
    }

    //Конструктор принимает три параметра – стоимость, название и описание блюда
    public Dish(int costOfDish, String nameOfDish, String descriptionOfDish) {
        this.costOfDish = costOfDish;
        this.nameOfDish = nameOfDish;
        this.descriptionOfDish = descriptionOfDish;
    }

    //Метод возвращающает стоимость
    public int getCostOfDish() {
        return costOfDish;
    }

    //Метод устанавливает значение стоимости
    public void setCostOfDish(int costOfDish) {

        this.costOfDish = costOfDish;
    }

    //Метод возвращающает значение названия
    public String getNameOfDish() {

        return nameOfDish;
    }

    //Метод устанавливает значение названия
    public void setNameOfDish(String nameOfDish) {

        this.nameOfDish = nameOfDish;
    }

    //Метод возвращающает значение описания
    public String getDescriptionOfDish() {

        return descriptionOfDish;
    }

    //Метод устанавливает значение описания
    public void setDescriptionOfDish(String descriptionOfDish) {
        this.descriptionOfDish = descriptionOfDish;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "costOfDish=" + costOfDish +
                ", nameOfDish='" + nameOfDish + '\'' +
                ", descriptionOfDish='" + descriptionOfDish + '\'' +
                '}';
    }
}
