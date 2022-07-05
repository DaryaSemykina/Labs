package com.barBossHouse;

public final class Address {
    final private String CITY;
    final private String STREET;
    final private int POSTAL_CODE;
    final private int BUILD_NUM;
    final private String BUILD_LETTER;
    final private int BUILD_OFFICE;

    // final private String CITY_DEFAULT = "Самара";?
//Конструктор Без параметров. В этом случае все строковые поля инициализируются пустыми строками, а числовые – значением -1.
    public Address() {
        this("", "", -1, -1, "", -1);
    }

    //Конструктор,Принимающий название улицы, номер здания, литера здания, номер помещения.Название страны принимается равным “Самара”, почтовый индекс – -1.
    public Address(String STREET, int BUILD_NUM, String BUILD_LETTER, int BUILD_OFFICE) {
        this("Самара", STREET, -1, BUILD_NUM, BUILD_LETTER, BUILD_OFFICE);
    }

    //Конструктор,Принимающий все параметры
    public Address(String CITY, String STREET, int POSTAL_CODE, int BUILD_NUM, String BUILD_LETTER, int BUILD_OFFICE) {
        this.CITY = CITY;
        this.STREET = STREET;
        this.POSTAL_CODE = POSTAL_CODE;
        this.BUILD_NUM = BUILD_NUM;
        this.BUILD_LETTER = BUILD_LETTER;
        this.BUILD_OFFICE = BUILD_OFFICE;

    }
    //Экземпляр класса Address, инициализированный с помощью конструктора поумолчанию.StackOverflowError????!!!!
    // Address addressDefault = new Address();

    //Метод, возвращающий название улицы.
    public String getSTREET() {
        return STREET;
    }

    //Метод, возвращающий название города
    public String getCITY() {
        return CITY;
    }

    //Метод, возвращающий почтовый индекс
    public int getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    //Метод, возвращающий номер здания.
    public int getBUILD_NUM() {
        return BUILD_NUM;
    }

    //Метод, возвращающий номер помещения
    public int getBUILD_OFFICE() {
        return BUILD_OFFICE;
    }

    //Метод, возвращающий литеру здания.
    public String getBUILD_LETTER() {
        return BUILD_LETTER;
    }

    //Переопрделенный метод toString()
    @Override
    public String toString() {
        String str = "Address:";
        if (!CITY.equals("")) str += "<" + CITY + "> ";
        if (POSTAL_CODE != -1) str += "<" + POSTAL_CODE + "> ";
        str += ",";
        if (!STREET.equals("")) str += "<" + STREET + "> ";
        if (BUILD_NUM != -1) str += "<" + BUILD_NUM + "> ";
        if (!BUILD_LETTER.equals("")) str += "<" + BUILD_LETTER + "> ";
        str += "-";
        if (BUILD_OFFICE != -1) str += "<" + BUILD_OFFICE + "> ";

        return str;
    }

    //Переопрделенный метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        if (!this.getCITY().equals(address.getCITY())) return false;
        if (!this.getSTREET().equals(address.getSTREET())) return false;
        if (this.getPOSTAL_CODE() != address.getPOSTAL_CODE()) return false;
        if (this.getBUILD_NUM() != address.getBUILD_NUM()) return false;
        if (!this.getBUILD_LETTER().equals(address.getBUILD_LETTER())) return false;
        if (this.getBUILD_OFFICE() != address.getBUILD_OFFICE()) return false;
        return true;
    }

    //Переопрделенный метод hashCode
    @Override
    public int hashCode() {
               return getCITY().hashCode()^getSTREET().hashCode()^getPOSTAL_CODE()^getBUILD_NUM()^getBUILD_LETTER().hashCode()^getBUILD_OFFICE();
    }
}
