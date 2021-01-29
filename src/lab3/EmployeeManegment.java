package lab3;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeManegment {

    private ArrayList<Employee> employeeRecords = new ArrayList<Employee>();

    public ArrayList<Employee> getEmployeeRecords() {
        return employeeRecords;
    }

    public void removeEmployee(int id) {
        employeeRecords.removeIf(employee -> employee.getId() == id);
//        System.out.println("employee removed successfuly");
    }
//    public void removeEmployee() {
//        System.out.println("Enter id to remove employee");
//        int id = enterInt();
//        for (int i = 0; i < employeeRecord.size(); i++) {
//            if (employeeRecord.get(i).getId() == id) {
//                employeeRecord.remove(i);
//                System.out.println("");
//                return;
//            }
//        }
//        System.out.println("");
//        System.out.println("Not valid id");
//        System.out.println("");
//    }

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

    // preformance is a int in the range 1-10
    public void setBonusForEmplyee(Employee employee, int preformance) {
        employee.setBonus(preformance);
    }
    
    public void loadDB() {
        Secretarie employee1 = new Secretarie("Dennis", 39, "dennis@mail.com", "976549", "Main office");
        Technician employee2 = new Technician("Stina", 23, "stina@mail.com", "235326", "Win");
        Programmer employee3 = new Programmer("Clas", 33, "clas@mail.com", "236526", "Java", 3);

        employeeRecords.add(employee1);
        employeeRecords.add(employee2);
        employeeRecords.add(employee3);
    }

    public void loadBonus() {
        Random rand = new Random();
        for (Employee employee : employeeRecords) {
            int preformance = rand.nextInt(10)+1;
            
            employee.setBonus(preformance);
        }
    }
}
