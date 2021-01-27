package lab3;


public class Secretarie extends Employee{

    public Secretarie(String name, int age, String email, String tel) {
        super(name, age, email, tel);
    }
    
    @Override
    protected void setSalary(int age){
    super.salary = 20000.0 + (age-18)*3000;
    }

    @Override
    public String toString() {
        return "Secretarie: " + super.toString(); 
    }
    
    
    
}
