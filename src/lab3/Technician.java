package lab3;

import java.util.Scanner;

public class Technician extends Employee {

    private String operatingSystem;
    
    private Scanner sc = new Scanner(System.in);
    
    public Technician() {
    }

    public Technician(String name, int age, String email, String tel, String operatingSystem) {
        super(name, age, email, tel);
        this.operatingSystem = operatingSystem;
    }

    public int getNumberOfAtributes() {
        return getClass().getDeclaredFields().length
                + getClass().getSuperclass().getDeclaredFields().length;
    }
    
    @Override
    public void printAtributs() {
        super.printAtributs();
        System.out.println("5. OperatingSystem");
    }

    @Override
    public void updateAtributs(int choice) {
        super.updateAtributs(choice);

        switch (choice) {
            case 5: {
                System.out.print("Enter operating system: ");
                String op = sc.nextLine();
                this.operatingSystem = op;
                break;
            }
        }
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
