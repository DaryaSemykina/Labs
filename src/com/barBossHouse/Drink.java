package com.barBossHouse;

public class Drink extends MenuItem implements Alcoholable {
    DrinkTypeEnum drinkType;
    float alcoholVol;
    //Конструкторпринимающий 5 параметров – стоимость, название, тип, описание, долю этилового спирта
    public Drink(int cost, String name, DrinkTypeEnum drinkType, String description, float alcoholVol) {
        super(cost, name, description);
        this.drinkType = drinkType;
        this.alcoholVol = alcoholVol;
    }
//Конструктор принимающий 4 параметра – стоимость, название, тип и описание. Доля спирта – 0
    public Drink(int cost, String name, DrinkTypeEnum drinkType, String description) {
        this(cost, name, drinkType, description, 0);
    }
//Конструкто,принимающий два параметра – название и тип. Стоимость и процент спирта при этом
//инициализируются значением 0, описание – пустая строка.
    public Drink(String name, DrinkTypeEnum drinkType) {
        this(0, name, drinkType, "", 0);
    }
//Метод, возвращающий тип напитка.
    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }
//Метод, возвращающий логическое значение – true, если напиток является алкогольным и false– в противном случае
    public boolean isAlco() {
        return alcoholVol > 0;
    }
//Метод, возвращающий процент этилового спирта в напитке
    public float getAlcoholVol() {
        return alcoholVol;
    }

    //Переопрделенный метод toString()
    @Override
    public String toString() {
        String str = "\"Drink: <" + getDrinkType() + "> ";
        if (getNameOfDish() != null) str += "<" + getNameOfDish() + ">, ";
        str += "<" + getCostOfDish() + ">p. ";
        if (isAlco()) str += "<" + getAlcoholVol() + ">%. ";
        if (!getDescriptionOfDish().equals("")) str += "<" + getDescriptionOfDish() + "> ";
        str += '\"';
        return str;
    }

    //Переопрделенный метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Drink drink = (Drink) obj;
        if (this.getCostOfDish() != drink.getCostOfDish()) return false;
        if (!this.getNameOfDish().equals(drink.getNameOfDish())) return false;
        return this.getAlcoholVol() == drink.getAlcoholVol();
    }

    //Переопрделенный метод hashCode
    @Override
    public int hashCode() {
        return getNameOfDish().hashCode() ^ getDescriptionOfDish().hashCode() ^ getCostOfDish() ^ getDrinkType().hashCode() ^ Math.round(alcoholVol);
    }
}
