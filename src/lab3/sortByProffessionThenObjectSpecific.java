package lab3;

import java.util.Comparator;

public class sortByProffessionThenObjectSpecific implements Comparator<Employee> {

    @Override
    public int compare(Employee t, Employee t1) {
        int ans = t.getClass().getName().compareTo(t1.getClass().getName());
        if (ans == 0) {
            if (t instanceof Programmer) {
                return ((Programmer) t).getLanguage().compareToIgnoreCase(((Programmer) t1).getLanguage());
            } else if (t instanceof Secretarie) {
                return ((Secretarie) t).getOffice().compareToIgnoreCase(((Secretarie) t1).getOffice());
            } else {
                return ((Technician) t).getOperatingSystem().compareToIgnoreCase(((Technician) t1).getOperatingSystem());
            }
        } else {
            return ans;
        }
    }

}
