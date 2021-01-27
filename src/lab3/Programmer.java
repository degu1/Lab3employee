package lab3;

import static lab3.Main.sc;

public class Programmer extends Employee {
  
    String language = "Java";
    
    public Programmer(String name, int age, String email, String tel) {
        super(name, age, email, tel);
        
    }

    @Override
    public String toString() {
        return "Programmer: " + super.toString()+ ", Language: "+ language;
    }
    
    @Override
    public void printAtributs() {
    super.printAtributs();
    System.out.println("5. Language");
    }
    
    @Override
    public void updateAtributs(int choice){
    super.updateAtributs(choice);
    
    switch (choice){
        case 5 :{
            System.out.print("Enter language: ");
            String language = sc.nextLine();
            this.language = language;
            break;
        }
    }
    
    }
    
//    @Override
//    protected double setSalary(int age){
//    return 20000.0 + (age-18)*1000;
//    }
}
