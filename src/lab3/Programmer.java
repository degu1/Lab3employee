package lab3;

import java.util.Scanner;

public class Programmer extends Employee {

    private String language;
    private int rank;
    
    Scanner sc = new Scanner(System.in);
    
    public Programmer() {
    }

    public Programmer(String name, int age, String email, String tel, String language, int rank) {
        super(name, age, email, tel);
        this.language = language;
        this.rank = rank;
    }

    public int getNumberOfAtributes() {
        return getClass().getDeclaredFields().length + 
                getClass().getSuperclass().getDeclaredFields().length;
    }

    @Override
    public String toString() {
        return "Programmer: " + super.toString() + ", Language: " + language + ", Rank " + rank;
    }

    @Override
    public void printAtributs() {
        super.printAtributs();
        System.out.println("5. Language");
        System.out.println("6. Rank");
    }

    @Override
    public void updateAtributs(int choice) {
        super.updateAtributs(choice);

        switch (choice) {
            case 5: {
                System.out.print("Enter language: ");
                String language = sc.nextLine();
                this.language = language;
                break;
            }
            case 6: {
                System.out.println("Enter Rank: ");
                int rank = sc.nextInt();
                sc.nextLine();
                this.rank = rank;
                break;

            }
        }

    }

//    @Override
//    protected double setSalary(int age){
//    return 20000.0 + (age-18)*1000;
//    }

    @Override
    public void setBonus(int preformance) {
        super.setBonus(preformance*3);
        
    }
}
