package lab3;

public class Secretarie extends Employee {

    private String office;

    public Secretarie(String name, int age, String email, String tel, String office) {
        super(name, age, email, tel);
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public double calculateSalary(int age) {
        return 20000.0 + (age - 18) * 3000;
    }

    @Override
    public String toString() {
        return "Secretarie: " + super.toString() + ", Office: " + office;
    }

    @Override
    public void setBonus(int preformance) {
        super.setBonus(preformance*2); 
    }

}
