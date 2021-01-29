package lab3;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    private static EmployeeManegment employeeManegment = new EmployeeManegment();

    public static void main(String[] args) {

        employeeManegment.loadDB();
        employeeManegment.loadBonus();

        while (true) {
            mainMenu();
        }

    }

    public static void mainMenu() {
        System.out.println("1. Add employee");
        System.out.println("2. Print all employees");
        System.out.println("3. Print employees by type");
        System.out.println("4. Print employee by id");
        System.out.println("5. Update employee");
        System.out.println("6. Remove employee");
        System.out.println("7. Give employee bonus");
        System.out.println("8. Analytics");
        System.out.println("0. Exit");
        System.out.print("Make your choice:");
        int choice = enterInt();
        System.out.println("");

        switch (choice) {
            case 0: {
                System.exit(0);
            }
            case 1: {
                addEmployee();
                break;
            }
            case 2: {
                printEmployees();
                break;
            }
            case 3: {
                printByTypeMenue();
                break;
            }

            case 4: {
                System.out.print("Enter id; ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("");
                printEmployeeById(id);

                break;
            }

            case 5: {
                updateEmplyee();
                break;
            }
            case 6: {
                removeEmployee();
                break;
            }

            case 7: {
                setBonusForEmplyee();
                break;
            }

            case 8: {
                Analytics analytics = new Analytics();
                analytics.AnalyticsMenu(employeeManegment.getEmployeeRecords());
                break;
            }
            default:

        }
    }

    public static void printEmployees() {
        for (Employee employee : employeeManegment.getEmployeeRecords()) {
            System.out.println(employee);
        }
        System.out.println("");
    }
 public static void printByTypeMenue() {

        System.out.println("1. Programmer");
        System.out.println("2. Secritary");
        System.out.println("3. Technican");
        System.out.print("Choose type: ");
        int choice = enterInt();
        System.out.println("");
        switch (choice) {
            case 1:
                printProgrammers();
                break;
            case 2:
                printSecretaries();
                break;
            case 3:
                printTechnician();
                break;
        }
    }
 
    public static void printProgrammers() {
        for (Employee employee : employeeManegment.getEmployeeRecords()) {
            if (employee instanceof Programmer) {
                System.out.println(employee);
            }
        }
        System.out.println("");
    }

    public static void printSecretaries() {
        for (Employee employee : employeeManegment.getEmployeeRecords()) {
            if (employee instanceof Secretarie) {
                System.out.println(employee);
            }
        }
        System.out.println("");
    }

    public static void printTechnician() {
        for (Employee employee : employeeManegment.getEmployeeRecords()) {
            if (employee instanceof Technician) {
                System.out.println(employee);
            }
        }
        System.out.println("");
    }

    public static void printEmployeeById(int id) {
        for (Employee employee : employeeManegment.getEmployeeRecords()) {
            if (employee.getId() == id) {
                System.out.println(employee);
                break;
            }
        }
        System.out.println("");
    }

    public static void addEmployee() {
        Employee employee = makeEmployee();
        if (employee != null) {
            employeeManegment.addEmployee(employee);
            System.out.println("New emplyee was added");
            System.out.println("");
        } else {
            System.out.println("Did't add emplyee");
            System.out.println("");
        }

    }

    public static Employee makeEmployee() {

        System.out.println("1. Secretaire");
        System.out.println("2. Technician");
        System.out.println("3. Programmer");
        System.out.print("Enter number for title: ");
        int choice = enterInt();
        switch (choice) {
            case 1: {
                Secretarie secretarie = new Secretarie();
                for (int i = 1; i < secretarie.getNumberOfAtributes() + 1; i++) {
                    secretarie.updateAtributs(i);
                }
                return secretarie;
            }
            case 2: {
                Technician technician = new Technician();
                for (int i = 1; i < technician.getNumberOfAtributes() + 1; i++) {
                    technician.updateAtributs(i);
                }
                return technician;
            }
            case 3: {

                Programmer programmer = new Programmer();
                for (int i = 1; i < programmer.getNumberOfAtributes() + 1; i++) {
                    programmer.updateAtributs(i);
                }
                return programmer;
            }
            default: {
                System.out.println("Not valid choice");
                System.out.println("");
                return null;
            }

        }

    }

    public static void updateEmplyee() {
        System.out.print("Enter id of emplyee: ");
        int id = enterInt();
        Employee employee = employeeManegment.getEmployeeFromId(id);

        System.out.println("");
        System.out.println("What to update:");

        employee.printAtributs();

        System.out.println("0. Exit update");
        int choice = enterInt();
        System.out.println("");
        if (choice == 0) {
            return;
        }
        employee.updateAtributs(choice);

    }

    public static void removeEmployee() {
        System.out.println("Enter employee id you want to remove:");
        int id = enterInt();
        System.out.println("");
        employeeManegment.removeEmployee(id);
    }

    public static void setBonusForEmplyee() {
        System.out.print("Enter id: ");
        int id = enterInt();
        System.out.println("");
        Employee employee = employeeManegment.getEmployeeFromId(id);
        System.out.print("How has " + employee.getName() + " prformanc been (1-10)? ");
        int preformance = enterInt();
        System.out.println("");
        employeeManegment.setBonusForEmplyee(employee, preformance);

    }

    private static int enterInt() {
        int integer = sc.nextInt();
        sc.nextLine();
        return integer;
    }
}
