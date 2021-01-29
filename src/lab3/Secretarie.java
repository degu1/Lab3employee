package lab3;

import java.util.Scanner;

public class Secretarie extends Employee {

    private String office;
    
    private Scanner sc = new Scanner(System.in);

    public Secretarie() {
    }

    public Secretarie(String name, int age, String email, String tel, String office) {
        super(name, age, email, tel);
        this.office = office;
    }

    public int getNumberOfAtributes() {
        return getClass().getDeclaredFields().length
                + getClass().getSuperclass().getDeclaredFields().length;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public void printAtributs() {
        super.printAtributs();
        System.out.println("5. Office");
    }

    @Override
    public void updateAtributs(int choice) {
        super.updateAtributs(choice);

        switch (choice) {
            case 5: {
                System.out.print("Enter Office: ");
                String office = sc.nextLine();
                this.office = office;
                break;
            }
        }
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
