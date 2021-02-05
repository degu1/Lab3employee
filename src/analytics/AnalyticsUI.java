package analytics;

import java.util.ArrayList;
import java.util.Scanner;
import lab3.Employee;
import static analytics.Analytics.*;

public class AnalyticsUI {

    private static Scanner sc = new Scanner(System.in);

    public static void analyticsMenu(ArrayList<Employee> employeeRecord) {
        boolean inAnalyticsMenu = true;
        while (inAnalyticsMenu) {
            System.out.println("1. Average salary");
            System.out.println("2. Bonus disttriution");
            System.out.println("3. Print employees with highest salary");
            System.out.println("4. Print employees with lowest salary");
            System.out.println("0. Main menu");
            System.out.print("Make your choice: ");
            int choice = enterInt();
            System.out.println("");
            switch (choice) {
                case 0: {
                    inAnalyticsMenu = false;
                }
                case 1: {
                    printAverageSalary(employeeRecord);
                    break;
                }
                case 2: {
                    printBonusDist(employeeRecord);
                    break;
                }
                case 3: {
                    printEmployeeHighestSalary(employeeRecord);
                    break;
                }
                case 4: {
                    printEmployeeLowestSalary(employeeRecord);
                    break;
                }
            }
        }
    }

    private static void printAverageSalary(ArrayList<Employee> employeeRecord) {

        double[] averageSalarys = averageSalary(employeeRecord);
        System.out.println("The total average salary is " + Math.round(averageSalarys[0]) + ".");
        System.out.println("The average salary for programmers is " + Math.round(averageSalarys[1]) + ".");
        System.out.println("The average salary for secretaries is " + Math.round(averageSalarys[2]) + ".");
        System.out.println("The average salary for technicians is " + Math.round(averageSalarys[3]) + ".");
        System.out.println("");
    }

    private static void printBonusDist(ArrayList<Employee> employeeRecord) {

        double[] bonusDis = bonusDistribution(employeeRecord);
        System.out.println("Programmers get " + bonusDis[0] + "% of the total bonus.");
        System.out.println("Secretaries get " + bonusDis[1] + "% of the total bonus.");
        System.out.println("Technicians get " + bonusDis[2] + "% of the total bonus.");
        System.out.println("");
    }

    private static void printEmployeeHighestSalary(ArrayList<Employee> employeeRecord) {

        ArrayList<Employee> searchResult = getEmplyeesHighestSalary(employeeRecord);
        for (Employee employee : searchResult) {
            System.out.println(employee);
        }
        System.out.println("");
    }

    private static void printEmployeeLowestSalary(ArrayList<Employee> employeeRecord) {
        ArrayList<Employee> searchResult = getEmplyeesLowestSalary(employeeRecord);
        for (Employee employee : searchResult) {
            System.out.println(employee);
        }
        System.out.println("");
    }

    private static int enterInt() {
        int integer = sc.nextInt();
        sc.nextLine();
        return integer;
    }
}
