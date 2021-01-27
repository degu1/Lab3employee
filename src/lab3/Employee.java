package lab3;

import static lab3.Main.sc;

public class Employee {

    private int id;
    private static int idGenerator = 1;
    private String name;
    private int age;
    protected double salary;
    private String email;
    private String tel;

    public Employee() {
    }

    public Employee(String name, int age, String email, String tel) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.tel = tel;
        this.id = idGenerator++;
        setSalary(age);
    }

    protected void setSalary(int age) {
        this.salary = 20000.0 + (age - 18) * 1000;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        setSalary(age);
    }

    public int getId() {
        return id;
    }

    public void printAtributs() {
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Email");
        System.out.println("4. tel");
    }

    public void updateAtributs(int choice) {

        switch (choice) {
            case 1: {
                System.out.print("Enter name:");
                String name = sc.nextLine();
                this.name = name;
                break;
            }
            case 2: {
                System.out.print("Enter age:");
                int age = sc.nextInt();
                sc.nextLine();
                setAge(age);

            }
            case 3: {
                System.out.print("Enter email:");
                String email = sc.nextLine();
                this.email = email;
                break;
            }
            case 4: {
                System.out.print("Enter tel:");
                String tel = sc.nextLine();
                this.tel = tel;
                break;
            }
            default:

        }
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Tel: " + tel + ", Salary: " + salary;
    }

}
