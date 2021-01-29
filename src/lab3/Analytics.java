package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Analytics {

    private Scanner sc = new Scanner(System.in);

    public void AnalyticsMenu(ArrayList<Employee> employeeRecord) {
        System.out.println("1. Average salary");
        System.out.println("2. Bonus disttriution");

        System.out.println("Make your choice: ");
        int choice = enterInt();
        System.out.println("");
        switch (choice) {
            case 1: {
                printAverageSalary(employeeRecord);
            }
            case 2: {
                printBonusDist(employeeRecord);
            }

        }
    }

    private void printAverageSalary(ArrayList<Employee> employeeRecord) {
        double totalSalary = 0;
        double totalSalaryPro = 0;
        double totalSalarySec = 0;
        double totalSalaryTec = 0;
        int nPro = 0;
        int nSec = 0;
        int nTec = 0;

        for (Employee employee : employeeRecord) {
            totalSalary = totalSalary + employee.getSalary();
            if (employee instanceof Programmer) {
                totalSalaryPro = totalSalaryPro + employee.getSalary();
                nPro++;
            } else if (employee instanceof Secretarie) {
                totalSalarySec = totalSalarySec + employee.getSalary();
                nSec++;
            } else {
                totalSalaryTec = totalSalaryTec + employee.getSalary();
                nTec++;
            }
        }

        double averageSalary = totalSalary / employeeRecord.size();
        double averageSalaryPro = totalSalaryPro / nPro;
        double averageSalarySec = totalSalarySec / nSec;
        double averageSalaryTec = totalSalaryTec / nTec;

        System.out.println("The total average salary is " + Math.round(averageSalary) + ".");
        System.out.println("The average salary for programmers is " + Math.round(averageSalaryPro) + ".");
        System.out.println("The average salary for secretaries is " + Math.round(averageSalarySec) + ".");
        System.out.println("The average salary for technicians is " + Math.round(averageSalaryTec) + ".");
        System.out.println("");
    }

    private void printBonusDist(ArrayList<Employee> employeeRecord) {
        double totalBonus = 0;
        double totalBonusPro = 0;
        double totalBonusSec = 0;
        double totalBonusTec = 0;

        for (Employee employee : employeeRecord) {
            totalBonus = totalBonus + employee.getBonus();
            if (employee instanceof Programmer) {
                totalBonusPro = totalBonusPro + employee.getBonus();
            } else if (employee instanceof Secretarie) {
                totalBonusSec = totalBonusSec + employee.getBonus();
            } else {
                totalBonusTec = totalBonusTec + employee.getBonus();
            }

        }
        System.out.println("Programmers get " + Math.round(totalBonusPro / totalBonus * 100) + "% of the total bonus.");
        System.out.println("Secretaries get " + Math.round(totalBonusSec / totalBonus * 100) + "% of the total bonus.");
        System.out.println("Technicians get " + Math.round(totalBonusTec / totalBonus * 100) + "% of the total bonus.");
        System.out.println("");
    }

    private int enterInt() {
        int integer = sc.nextInt();
        sc.nextLine();
        return integer;
    }
}
