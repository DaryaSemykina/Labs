package com.barBossHouse;

public abstract class MenuItem {
    private int costOfDish;
    private String nameOfDish;
    private String descriptionOfDish;

    //Конструктор принимает два параметра – название и описание блюда
    protected MenuItem(String nameOfDish, String descriptionOfDish) {
        this(0, nameOfDish, descriptionOfDish);
    }


    //Конструктор принимает три параметра – стоимость, название и описание блюда
    protected MenuItem(int costOfDish, String nameOfDish, String descriptionOfDish) {
        this.costOfDish = costOfDish;
        this.nameOfDish = nameOfDish;
        this.descriptionOfDish = descriptionOfDish;
    }

    //Метод возвращающает стоимость
    public int getCostOfDish() {
        return costOfDish;
    }

    //Метод устанавливает значение стоимости


    //Метод возвращающает значение названия
    public String getNameOfDish() {

        return nameOfDish;
    }

    //Метод устанавливает значение названия


    //Метод возвращающает значение описания
    public String getDescriptionOfDish() {

        return descriptionOfDish;
    }

    //Метод устанавливает значение описания

    //Переопрделенный метод toString()
    @Override
    public String toString() {
        String str = "\"";
        if (nameOfDish != null) str += "<" + nameOfDish + ">, ";
        str += "<" + costOfDish + ">p.\"";
        return str;
    }

    //Переопрделенный метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MenuItem menuItem =  (MenuItem) obj;
        if(this.getCostOfDish()!=  menuItem.getCostOfDish()) return false;
        return  this.getNameOfDish().equals(menuItem.getNameOfDish());
    }
    //Переопрделенный метод hashCode
    @Override
    public int hashCode() {
        return getNameOfDish().hashCode() ^ getDescriptionOfDish().hashCode() ^ getCostOfDish();
    }
}
