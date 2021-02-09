package lab3;


import static analytics.AnalyticsUI.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    private static EmployeeManegment employeeManegment = new EmployeeManegment();

    public static void main(String[] args) {

        employeeManegment.loadDB();
        employeeManegment.loadBonus();
        //employeeManegment.sortEmplyeeByAge();
        while (true) {
            mainMenu();
        }

    }

    public static void mainMenu() {
        System.out.println("1. Add employee");
        System.out.println("2. Print all employees");
        System.out.println("3. Print employees by type");
        System.out.println("4. Print employee by id");
        System.out.println("5. Print employee by name");
        System.out.println("6. Update employee");
        System.out.println("7. Remove employee");
        System.out.println("8. Give employee bonus");
        System.out.println("9. Analytics");
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
                System.out.print("Enter id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("");
                printEmployeeById(id);

                break;
            }

            case 5: {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.println("");
                ArrayList<Employee> searchResult = employeeManegment.searchEmployeeByName(name);
                for (Employee employee : searchResult) {
                    System.out.println(employee);
                }
                System.out.println("");
                break;
            }

            case 6: {
                updateEmplyee();
                break;
            }
            case 7: {
                removeEmployee();
                break;
            }

            case 8: {
                setBonusForEmplyee();
                break;
            }

            case 9: {
                analyticsMenu(employeeManegment.getAllEmployees());
                break;
            }
            default:

        }
    }

    public static void printEmployees() {
        for (Employee employee : employeeManegment.getAllEmployees()) {
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
        for (Employee employee : employeeManegment.getAllProgrammers()) {
            System.out.println(employee);
        }
        System.out.println("");
    }

    public static void printSecretaries() {
        for (Employee employee : employeeManegment.getAllSecretaries()) {
            System.out.println(employee);
        }
        System.out.println("");
    }

    public static void printTechnician() {
        for (Employee employee : employeeManegment.getAllTechnicians()) {
            System.out.println(employee);
        }
        System.out.println("");
    }

    public static void printEmployeeById(int id) {
        for (Employee employee : employeeManegment.getAllEmployees()) {
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

        System.out.print("Enter name:");
        String name = sc.nextLine();

        System.out.print("Enter age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter email:");
        String email = sc.nextLine();

        System.out.print("Enter tel:");
        String tel = sc.nextLine();

        switch (choice) {
            case 1: {
                System.out.print("Enter Office: ");
                String office = sc.nextLine();
                return new Secretarie(name, age, email, tel, office);
            }
            case 2: {
                System.out.print("Enter operating system: ");
                String op = sc.nextLine();
                return new Technician(name, age, email, tel, op);
            }
            case 3: {
                System.out.print("Enter language: ");
                String language = sc.nextLine();
                return new Programmer(name, age, email, tel, language);
            }
            default: {
                System.out.println("Not valid choice of title");
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

        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Email");
        System.out.println("4. tel");

        if (employee instanceof Secretarie) {
            System.out.println("5. Office");
        } else if (employee instanceof Technician) {
            System.out.println("5. OperatingSystem");
        } else if (employee instanceof Programmer) {
            System.out.println("5. Language");
        }

        System.out.println("0. Exit update");
        System.out.print("Make your choice: ");
        int choice = enterInt();
        System.out.println("");
        if (choice == 0) {
            return;
        }
        updateAtributs(employee, choice);
    }

    public static void updateAtributs(Employee employee, int choice) {
        boolean nextSwich = false;
        switch (choice) {
            case 1: {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                employee.setName(name);
                break;
            }
            case 2: {
                System.out.print("Enter age: ");
                int age = enterInt();
                employee.setAge(age);
                break;
            }
            case 3: {
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                employee.setEmail(email);
                break;
            }
            case 4: {
                System.out.print("Enter tel: ");
                String tel = sc.nextLine();
                employee.setTel(tel);
                break;
            }
            default:
                nextSwich = true;
        }

        if (nextSwich) {
            if (employee instanceof Secretarie) {
                switch (choice) {
                    case 5: {
                        System.out.print("Enter Office: ");
                        String office = sc.nextLine();
                        ((Secretarie) employee).setOffice(office);
                    }
                }
            } else if (employee instanceof Technician) {
                switch (choice) {
                    case 5: {
                        System.out.print("Enter OperatingSystem: ");
                        String operatingSystem = sc.nextLine();
                        ((Technician) employee).setOperatingSystem(operatingSystem);
                    }
                }
            } else if (employee instanceof Programmer) {
                switch (choice) {
                    case 5: {
                        System.out.print("Enter Language :");
                        String language = sc.nextLine();
                        ((Programmer) employee).setLanguage(language);
                    }
                }
            }

        }

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
