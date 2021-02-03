package lab3;

public class Technician extends Employee {

    private String operatingSystem;
    
    public Technician() {
    }

    public Technician(String name, int age, String email, String tel, String operatingSystem) {
        super(name, age, email, tel);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    
    @Override
    public double calculateSalary(int age) {
        return 20000.0 + (age - 18) * 4000;
    }

    @Override
    public String toString() {
        return "Technician: " + super.toString() + ", Operating System: " + operatingSystem;
    }
}
