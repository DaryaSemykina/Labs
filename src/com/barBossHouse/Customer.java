package com.barBossHouse;

public final class Customer {
    final private String nameCustomer;
    final private String surname;
    final private int age;
    final private Address address;
    final static private String NAME_CUSTOMER ="";
    final static private String SURNAME_CUSTOMER ="";
    final static private int AGE_DEFAULT =-1;
    // Экземпляр класса Customer, инициализированный с помощью конструктора принимающего один параметр – возраст со значением 21 и еще один экземпляр с возрастом 14 лет
    public final static Customer customerDefault = new Customer(21);
    public final static Customer customerDefaultSecond = new Customer(14);
    //Конструктор Без параметров
    public Customer() {
        this(NAME_CUSTOMER, SURNAME_CUSTOMER, AGE_DEFAULT, new Address());
    }

    //Конструктор, принимающий один параметр – возраст
    public Customer(int age) {
        this(NAME_CUSTOMER, SURNAME_CUSTOMER, age, new Address());
    }

    //Конструктор, принимающий все 4 параметра
    public Customer(String nameCustomer, String surname, int age, Address address) {
        this.nameCustomer = nameCustomer;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    //Метод,возвращающий возраст.
    public int getAge() {
        return age;
    }

    //Метод,возвращающий имя.
    public String getNameCustomer() {
        return nameCustomer;
    }

    //Метод,возвращающий фамилию.
    public String getSurname() {
        return surname;
    }

    //Метод,возвращающий адрес.
    public Address getAddress() {
        return address;
    }

    //Переопрделенный метод toString()
    @Override
    public String toString() {
        String str = '\"'+"Customer: ";
        if (!surname.equals("")) str += "<" + surname + "> ";
        if (!nameCustomer.equals("")) str += "<" + nameCustomer + ">";
        str += ", ";
        if (age != -1) str += "<" + age + ">";
        str += ", ";
        if (!address.toString().equals('\"'+"Address: ")) str += "<" + address + ">";
        str += '\"';
        return str;
    }

    //Переопрделенный метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        if (!this.getNameCustomer().equals(customer.getNameCustomer())) return false;
        if (!this.getSurname().equals(customer.getSurname())) return false;
        if (this.getAge() != customer.getAge()) return false;
        return this.getAddress().equals(customer.getAddress());
    }

    //Переопрделенный метод hashCode
    @Override
    public int hashCode() {
              return nameCustomer.hashCode()^ surname.hashCode()^address.hashCode()^age;
    }
}
