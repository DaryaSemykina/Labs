package com.Employee;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class DoPayroll {
    public static void main(String[] args) throws IOException {
        Scanner diskScanner = new Scanner(new File("F:\\Учёба\\Программирование\\EmployeeInfo.txt"));
       // Scanner diskScanner = new Scanner(System.in);
        for( int empNum =1;empNum<=3;empNum++){
            payOneEmployee(diskScanner);
        }
    }
    static void  payOneEmployee(Scanner aScanner){
        Employee anEmployee = new Employee();
        anEmployee.setName(aScanner.nextLine());
        anEmployee.setJobTitle(aScanner.nextLine());
        anEmployee.cutCheck(aScanner.nextDouble());
        aScanner.nextLine();
    }
}
