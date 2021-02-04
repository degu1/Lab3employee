package analytics;

import java.util.ArrayList;
import lab3.Employee;
import lab3.Programmer;
import lab3.Secretarie;

public class Analytics {

    public static double[] averageSalary(ArrayList<Employee> employeeRecord) {
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
        double[] averageSalary = new double[4];
        averageSalary[0] = totalSalary / employeeRecord.size();
        averageSalary[1] = totalSalaryPro / nPro;
        averageSalary[2] = totalSalarySec / nSec;
        averageSalary[3] = totalSalaryTec / nTec;

        return averageSalary;
    }

    public static double[] bonusDistribution(ArrayList<Employee> employeeRecord) {
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
        double[] bonusDis = new double[3];
        bonusDis[0] = Math.round(totalBonusPro / totalBonus * 100);
        bonusDis[1] = Math.round(totalBonusSec / totalBonus * 100);
        bonusDis[2] = Math.round(totalBonusTec / totalBonus * 100);

        return bonusDis;
    }

    public static ArrayList<Employee> getEmplyeesHighestSalary(ArrayList<Employee> employees) {
        ArrayList<Employee> ans = new ArrayList<>();
        double highestSalary = getMaxSalary(employees);
        for (Employee employee : employees) {
            if (employee.getSalary() == highestSalary)
                ans.add(employee);
        }
        return ans;
    }

    public static ArrayList<Employee> getEmplyeesLowestSalary(ArrayList<Employee> employees) {
        ArrayList<Employee> ans = new ArrayList<>();
        double lowestSalary = getMinSalary(employees);
        for (Employee employee : employees) {
            if (employee.getSalary() == lowestSalary)
                ans.add(employee);
        }
        return ans;
    }

    public static double getMaxSalary(ArrayList<Employee> employees) {
        double maxSalary = employees.get(0).getSalary();
        for (int i = 1; i < employees.size(); i++) {
            if (maxSalary < employees.get(i).getSalary()) {
                maxSalary = employees.get(i).getSalary();
            }
        }
        return maxSalary;
    }

    public static double getMinSalary(ArrayList<Employee> employees) {
        double minSalary = employees.get(0).getSalary();
        for (int i = 1; i < employees.size(); i++) {
            if (minSalary > employees.get(i).getSalary()) {
                minSalary = employees.get(i).getSalary();
            }
        }
        return minSalary;
    }
}
