package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManegment {

    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> employeeRecord = new ArrayList<Employee>();

    public void printEmployees() {
        for (Employee employee : employeeRecord) {
            System.out.println(employee);
        }
        System.out.println("");

    }

    public void removeEmployee() {
        System.out.println("Enter id to remove employee");
        int id = enterInt();
        for (int i = 0; i < employeeRecord.size(); i++) {
            if (employeeRecord.get(i).getId() == id) {
                employeeRecord.remove(i);
                System.out.println("");
                return;
            }
        }
        System.out.println("");
        System.out.println("Not valid id");
        System.out.println("");
    }

    public void addEmployee() {
        Employee employee = makeEmployee();
        if (employee != null) {
            employeeRecord.add(employee);
            System.out.println("New emplyee was added");
            System.out.println("");
        } else {
            System.out.println("Did't add emplyee");
            System.out.println("");
        }

    }

    public Employee makeEmployee() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = enterInt();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter tel: ");
        String tel = sc.nextLine();

        System.out.println("1. Secretaire");
        System.out.println("2. Technician");
        System.out.println("3. Programmer");
        System.out.print("Enter number for title: ");
        int choice = enterInt();
        switch (choice) {
            case 1: {
                return new Secretarie(name, age, email, tel);

            }
            case 2: {
                return new Technician(name, age, email, tel);

            }
            case 3: {
                return new Programmer(name, age, email, tel);

            }
            default: {
                System.out.println("Not valid choice");
                System.out.println("");
                return null;
            }

        }

    }

    public void updateEmplyee() {
        System.out.print("Enter id of emplyee: ");
        int id = enterInt();
        Employee employee = getEmployeeFromId(id);
        
        System.out.println("");
        System.out.println("What to update:");
//        System.out.println("1. Name");
//        System.out.println("2. Age");
//        System.out.println("3. Email");
//        System.out.println("4. tel");
        employee.printAtributs();

        System.out.println("0. Exit update");
        int choice = enterInt();
        System.out.println("");
        if (choice == 0){return;}
        employee.updateAtributs(choice);

//        switch (choice) {
//            case 1: {
//                System.out.print("Enter name:");
//                String name = sc.nextLine();
////                    for (Employee employee : employeeRecord) {
////                        if (employee.getId() == id) {
////                            employee.setName(name);
////                        }
////                        break;
////                    }
//                break;
//            }
//            case 2: {
//                System.out.print("Enter age:");
//                int age = enterInt();
////                    for (Employee employee : employeeRecord) {
////                        if (employee.getId() == id) {
////                            employee.setAge(age);
////                        }
////                        break;
////                    }
////                    break;
//            }
//            case 3: {
//                System.out.print("Enter email:");
//                String email = sc.nextLine();
////                    for (Employee employee : employeeRecord) {
////                        if (employee.getId() == id) {
////                            employee.setEmail(email);
////                        }
////                        break;
////                    }
//                break;
//            }
//            case 4: {
//                System.out.print("Enter tel:");
//                String tel = sc.nextLine();
////                    for (Employee employee : employeeRecord) {
////                        if (employee.getId() == id) {
////                            employee.setTel(tel);
////                        }
////                        break;
////                    }
//                break;
//            }
//            default:
//
//        }
    }

    private Employee getEmployeeFromId(int id) {

        for (Employee employee : employeeRecord) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return new Employee();
    }

    private int enterInt() {
        int integer = sc.nextInt();
        sc.nextLine();
        return integer;
    }

    public void loadDB() {
        Secretarie employee1 = new Secretarie("Dennis", 39, "dennis@mail.com", "976549");
        Technician employee2 = new Technician("Stina", 23, "stina@mail.com", "235326");
        Programmer employee3 = new Programmer("Clas", 33, "clas@mail.com", "236526");

        employeeRecord.add(employee1);
        employeeRecord.add(employee2);
        employeeRecord.add(employee3);
    }
}
