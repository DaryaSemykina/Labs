package com.barBossHouse;

public final class Address {
     private final String city;
    final private String street;
    final private int postalCode;
    final private int buildNum;
    final private String buildLetter;
    final private int apartmentNumber;
    //Экземпляр класса Address, инициализированный с помощью конструктора поумолчанию
     public  final static Address addressDefault = new Address();
     final  static  private String CITY_DEFAULT = "Самара";
    final  static  private String CITY_DEFAULT_1 = "Самара";
    final  static  private String STREET_DEFAULT = "";
    final  static  private int POSTAL_CODE = -1;
    final  static  private int BUILD_NUM = -1;
    final  static  private String BUILD_LETTER = "";
    final  static  private int APARTMENT_NUMBER = -1;
//Конструктор Без параметров. В этом случае все строковые поля инициализируются пустыми строками, а числовые – значением -1.
    public Address() {
        this(CITY_DEFAULT_1, STREET_DEFAULT, POSTAL_CODE, BUILD_NUM, BUILD_LETTER, APARTMENT_NUMBER);
    }

    //Конструктор,Принимающий название улицы, номер здания, литера здания, номер помещения.Название страны принимается равным “Самара”, почтовый индекс – -1.
    public Address(String street, int buildNum, String buildLetter, int apartmentNumber) {
        this(CITY_DEFAULT, street, POSTAL_CODE, buildNum, buildLetter, apartmentNumber);
    }

    //Конструктор,Принимающий все параметры
    public Address(String city, String street, int postalCode, int buildNum, String buildLetter, int apartmentNumber) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildNum = buildNum;
        this.buildLetter = buildLetter;
        this.apartmentNumber = apartmentNumber;

    }



    //Метод, возвращающий название улицы.
    public String getStreet() {
        return street;
    }

    //Метод, возвращающий название города
    public String getCity() {
        return city;
    }

    //Метод, возвращающий почтовый индекс
    public int getPostalCode() {
        return postalCode;
    }

    //Метод, возвращающий номер здания.
    public int getBuildNum() {
        return buildNum;
    }

    //Метод, возвращающий номер помещения
    public int getApartmentNumber() {
        return apartmentNumber;
    }

    //Метод, возвращающий литеру здания.
    public String getBuildLetter() {
        return buildLetter;
    }

    //Переопрделенный метод toString()
    @Override
    public String toString() {
        String str = '\"'+"Address: ";
        if (!city.equals("")) str += "<" + city + "> ";
        if (postalCode != -1) str += "<" + postalCode + ">";
        str += ",";
        if (!street.equals("")) str += "<" + street + "> ";
        if (buildNum != -1) str += "<" + buildNum + ">";
        if (!buildLetter.equals("")) str += "<" + buildLetter + ">";
        str += "-";
        if (apartmentNumber != -1) str += "<" + apartmentNumber + ">";
        str += '\"';
        return str;
    }

    //Переопрделенный метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        if (!this.getCity().equals(address.getCity())) return false;
        if (!this.getStreet().equals(address.getStreet())) return false;
        if (this.getPostalCode() != address.getPostalCode()) return false;
        if (this.getBuildNum() != address.getBuildNum()) return false;
        if (!this.getBuildLetter().equals(address.getBuildLetter())) return false;
        return this.getApartmentNumber() == address.getApartmentNumber();
    }

    //Переопрделенный метод hashCode
    @Override
    public int hashCode() {
               return getCity().hashCode()^getStreet().hashCode()^getPostalCode()^getBuildNum()^getBuildLetter().hashCode()^getApartmentNumber();
    }
}
