package lab3;

import static analytics.AnalyticsUI.*;
import java.util.ArrayList;
import java.util.Scanner;
import static UIMaker.UIMaker.*;

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

        String[] menu = {
            "Add employee",
            "Print all employees",
            "Print employees by type",
            "Print employee by id",
            "Print employee by name",
            "Update employee",
            "Remove employee",
            "Give employee bonus",
            "Analytics"};
        int choice = menu("Main Menu", menu, "Exit Program");
        switch (choice) {
            case 0: {
                System.exit(0);
            }
            case 1: {
                addEmployee();
                break;
            }
            case 2: {
                printAllEmployeesMenu();
                break;
            }
            case 3: {
                printByTypeMenue();
                break;
            }

            case 4: {
                printEmployeeById();
                break;
            }

            case 5: {
                String name = enterString("Enter name: ");
                ArrayList<Employee> searchResult = employeeManegment.searchEmployeeByName(name);
                searchResult.forEach((employee) -> {
                    System.out.println(employee);
                });
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

    public static void printAllEmployeesMenu() {
        String[] menu = {
            "Sort by id",
            "Sort by name rising",
            "Sort by name falling",
            "Sort by age rising",
            "Sort by age falling",
            "Sort by proffession then subclass atribute",
            "Sort by age then name",
            "Sort by bonus"
        };

        int choice = menuMaker(menu, "Main menu");

        switch (choice) {

            case 0: {
                break;
            }
            case 1: {
                employeeManegment.sortEmplyeeById();
                printEmployees();
                break;
            }
            case 2: {
                employeeManegment.sortEmplyeeByNameRising();
                printEmployees();
                break;
            }
            case 3: {
                employeeManegment.sortEmplyeeByNameFalling();
                printEmployees();
                break;
            }
            case 4: {
                employeeManegment.sortEmplyeeByAgeRising();
                printEmployees();
                break;
            }
            case 5: {
                employeeManegment.sortEmplyeeByAgeFalling();
                printEmployees();
                break;
            }
            case 6: {
                employeeManegment.sortByProffessionThenObjectSpecific();
                printEmployees();
                break;
            }
            case 7: {
                employeeManegment.sortByAgeThenName();
                printEmployees();
                break;
            }
            case 8: {
                employeeManegment.sortByBonus();
                printEmployees();
                break;
            }
            default: {
            }
        }

    }

    public static void printEmployees() {
        for (Employee employee : employeeManegment.getAllEmployees()) {
            System.out.println(employee);
        }
        System.out.println("");
    }

    public static void printByTypeMenue() {
        String[] menu = {
            "Secretaire",
            "Technician",
            "Programmer"
        };

        int choice = menuMaker(menu);
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

    public static void printEmployeeById() {
        int id = enterInt("Enter id: ");
        try {
            Employee employee = employeeManegment.getEmployeeFromId(id);
            System.out.println(employee);
            System.out.println("");
        } catch (DidNotFindIdException e) {
            System.out.println("Did not find id in emplyee records.");
            System.out.println("");
        }
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
        String[] menu = {
            "Secretaire",
            "Technician",
            "Programmer"
        };
        int choice = menuMaker(menu);

        String name = enterString("Enter name: ");
        int age = enterInt("Enter age: ");
        String email = enterString("Eneter email: ");
        String tel = enterString("Enter tel: ");

        switch (choice) {
            case 1: {
                String office = enterString("Enter office: ");
                return new Secretarie(name, age, email, tel, office);
            }
            case 2: {
                String op = enterString("Enter operating system: ");
                return new Technician(name, age, email, tel, op);
            }
            case 3: {
                String language = enterString("Enter language: ");
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
        try {
            int id = enterInt("Enter id of emplyee: ");
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
            int choice = enterInt("Make your choice: ");
            System.out.println("");
            if (choice == 0) {
                return;
            }
            updateAtributs(employee, choice);
        } catch (DidNotFindIdException e) {
            System.out.println("Did't fint any emplyee by id");
            System.out.println("");
        }
    }

    public static void updateAtributs(Employee employee, int choice) {
        boolean nextSwich = false;
        switch (choice) {
            case 1: {
                String name = enterString("Enter name: ");
                employee.setName(name);
                break;
            }
            case 2: {
                int age = enterInt("Enter age: ");
                employee.setAge(age);
                break;
            }
            case 3: {
                String email = enterString("Enter email: ");
                employee.setEmail(email);
                break;
            }
            case 4: {
                String tel = enterString("Enter §tel: ");
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
                        String office = enterString("Enter office: ");
                        ((Secretarie) employee).setOffice(office);
                    }
                }
            } else if (employee instanceof Technician) {
                switch (choice) {
                    case 5: {
                        String operatingSystem = enterString("Enter OperatingSystem: ");
                        ((Technician) employee).setOperatingSystem(operatingSystem);
                    }
                }
            } else if (employee instanceof Programmer) {
                switch (choice) {
                    case 5: {
                        String language = enterString("Enter Language: ");
                        ((Programmer) employee).setLanguage(language);
                    }
                }
            }

        }

    }

    public static void removeEmployee() {
        int id = enterInt("Enter employee id you want to remove:");
        System.out.println("");
        try{employeeManegment.removeEmployee(id);}
        catch(DidNotFindIdException e){
            System.out.println("Did not remove emplyee with id " + id +".");
            System.out.println("");
        };
    }

    public static void setBonusForEmplyee() {
        int id = enterInt("Enter id: ");
        try {
            Employee employee = employeeManegment.getEmployeeFromId(id);
            int preformance = enterInt("How has " + employee.getName() + " prformanc been (1-10)? ");
            System.out.println("");
            employeeManegment.setBonusForEmplyee(employee, preformance);
        } catch (DidNotFindIdException e) {
            System.out.println("Did't find emplyee with id " + id);
        }
    }
}
