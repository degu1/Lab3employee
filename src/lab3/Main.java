package lab3;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    private static EmployeeManegment employeeManegment = new EmployeeManegment();

    public static void main(String[] args) {

        employeeManegment.loadDB();

        employeeManegment.printEmployees();
        
        while(true){
            mainMenu();
        }

    }

    public static void mainMenu() {
        System.out.println("1. Add employee");
        System.out.println("2. Print employee");
        System.out.println("3. Update employee");
        System.out.println("4. Remove employee");
        System.out.println("0. Exit");
        System.out.print("Make your choice:");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("");

        switch (choice) {
            case 0: {
            System.exit(0);
            }
            case 1: {
                employeeManegment.addEmployee();
                break;
            }
            case 2: {
                employeeManegment.printEmployees();
                break;
            }
            case 3: {
                employeeManegment.updateEmplyee();
                break;
            }
            case 4: {
                employeeManegment.removeEmployee();
            }
            default:
            
        }
    }

}
