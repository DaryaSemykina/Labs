package com.barBossHouse;

public final class Customer {
    final private String nameCustomer;
    final private String surname;
    final private int age;
    final private Address address;

    //Конструктор Без параметров
    public Customer() {
        this("", "", -1, new Address());
    }

    //Конструктор, принимающий один параметр – возраст
    public Customer(int age) {
        this("", "", age, new Address());
    }

    //Конструктор, принимающий все 4 параметра
    public Customer(String nameCustomer, String surname, int age, Address address) {
        this.nameCustomer = nameCustomer;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }
    // Экземпляр класса Customer, инициализированный с помощью конструктора принимающего один параметр – возраст со значением 21 и еще один экземпляр с возрастом 14 лет
    //Customer customerDefault = new Customer(21);
    //Customer customerDefaultSecond = new Customer(14);

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
        String str = "Customer:";
        if (!surname.equals("")) str += "<" + surname + "> ";
        if (!nameCustomer.equals("")) str += "<" + nameCustomer + "> ";
        str += ",";
        if (age != -1) str += "<" + age + "> ";
        str += ",";
        if (!address.toString().equals("Address:")) str += "<" + address.toString() + "> ";
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
        if (!this.getAddress().equals(customer.getAddress())) return false;
        return true;
    }

    //Переопрделенный метод hashCode
    @Override
    public int hashCode() {
              return nameCustomer.hashCode()^ surname.hashCode()^address.hashCode()^age;
    }
}
