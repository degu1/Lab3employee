/*
    The EmployeeManegment class contains all the logic for handling the employees 
 */
package lab3;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeManegment {

    private ArrayList<Employee> employeeRecords = new ArrayList<Employee>();

    public ArrayList<Employee> getAllEmployees() {
        return employeeRecords;
    }

    public ArrayList<Employee> getAllProgrammers() {
        ArrayList<Employee> programmers = new ArrayList<>();
        for (Employee employee : employeeRecords) {
            if (employee instanceof Programmer) {
                programmers.add(employee);
            }
        }
        return programmers;
    }

    public ArrayList<Employee> getAllSecretaries() {
        ArrayList<Employee> secretaries = new ArrayList<>();
        for (Employee employee : employeeRecords) {
            if (employee instanceof Secretarie) {
                secretaries.add(employee);
            }
        }
        return secretaries;
    }

    public ArrayList<Employee> getAllTechnicians() {
        ArrayList<Employee> technicians = new ArrayList<>();
        for (Employee employee : employeeRecords) {
            if (employee instanceof Technician) {
                technicians.add(employee);
            }
        }
        return technicians;
    }

    public void removeEmployee(int id) {
        employeeRecords.removeIf(employee -> employee.getId() == id);
    }

    public void addEmployee(Employee employee) {
        employeeRecords.add(employee);
    }

    public Employee getEmployeeFromId(int id) {
        for (Employee employee : employeeRecords) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return new Employee();
    }

    public ArrayList<Employee> searchEmployeeByName(String searchName) {
        
        ArrayList<Employee> searchresult = new ArrayList<>();
        searchName = searchName.trim().toLowerCase();
        
        for (Employee employee : employeeRecords) {
            if (employee.getName().toLowerCase().contains(searchName)) {
                searchresult.add(employee);
            }
        }
        return searchresult;
    }

    // preformance is a int in the range 1-10
    public void setBonusForEmplyee(Employee employee, int preformance) {
        employee.setBonus(preformance);
    }

    public void loadDB() {
        Secretarie e1 = new Secretarie("Dennis", 39, "dennis@mail.com", "976549", "Main office");
        Technician e2 = new Technician("Stina", 23, "stina@mail.com", "235326", "Win");
        Programmer e3 = new Programmer("Clas", 33, "clas@mail.com", "236526", "Java");
        Secretarie e4 = new Secretarie("Alice", 26, "alice@mail.com", "324556", "Main office");
        Secretarie e5 = new Secretarie("Noah", 47, "noah@mail.com", "523634", "Main office");
        Programmer e6 = new Programmer("Elsa", 21, "elsa@mail.com", "326789", "Java");
        Programmer e7 = new Programmer("Astrid", 28, "astrid@mail.com", "346523", "C++");
        Programmer e8 = new Programmer("Lucas", 50, "lucas@mail.com", "763454", "C++");
        Programmer e9 = new Programmer("Liam", 37, "liam@mail.com", "344576", "Java");
        Programmer e10 = new Programmer("Freja", 21, "freja@mail.com", "485623", "C++");
        Technician e11 = new Technician("Oscar", 37, "oscar@mail.com", "456872", "Win");
        Technician e12 = new Technician("Olivia", 28, "olivia@mail.com", "352634", "Win");
        Technician e13 = new Technician("Matteo", 24, "matteo@mail.com", "126236", "Linux");
        Technician e14 = new Technician("Selma", 32, "selma@mail.com", "346734", "Linux");
        Technician e15 = new Technician("Oliver", 35, "oliver@mail.com", "435465", "Win");

        employeeRecords.add(e1);
        employeeRecords.add(e2);
        employeeRecords.add(e4);
        employeeRecords.add(e5);
        employeeRecords.add(e6);
        employeeRecords.add(e7);
        employeeRecords.add(e8);
        employeeRecords.add(e9);
        employeeRecords.add(e10);
        employeeRecords.add(e11);
        employeeRecords.add(e12);
        employeeRecords.add(e13);
        employeeRecords.add(e14);
        employeeRecords.add(e15);

    }

    public void loadBonus() {
        Random rand = new Random();
        for (Employee employee : employeeRecords) {
            int preformance = rand.nextInt(10) + 1;

            employee.setBonus(preformance);
        }
    }
}
