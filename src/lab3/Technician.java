package lab3;

public class Technician extends Employee{
        
    
    public Technician(String name, int age, String email, String tel) {
        super(name, age, email, tel);
    }


    
    @Override
    protected void setSalary(int age){
    super.salary = 20000.0 + (age-18)*4000;
    }
    @Override
    public String toString() {
        return "Technician: " + super.toString(); 
    }
}
