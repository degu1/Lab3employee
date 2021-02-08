package lab3;

public class Employee {

    private int id;
    private static int idGenerator = 1;
    private String name;
    private int age;
    private double salary;
    private double bonus;
    private String email;
    private String tel;

    public Employee() {
        this.id = idGenerator++;
    }

    public Employee(String name, int age, String email, String tel) {

        this.id = idGenerator++;
        this.name = name;
        this.age = age;
        this.email = email;
        this.tel = tel;
        this.salary = calculateSalary(age);
        this.bonus = 0;
    }

    public double calculateSalary(int age) {
        return 20000.0 + (age - 18) * 1000;
    }

    public double getBonus() {
        return bonus;
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
        this.salary = calculateSalary(age);
    }

    public int getId() {
        return id;
    }

    //preformance is a integer (1-10)
    public void setBonus(int preformance) {
        this.bonus = 1000.0 * preformance;
    }
    

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Age: " + age + ", Email: "
                + email + ", Tel: " + tel + ", Salary: " + getSalary()
                + ", Bonus: " + bonus;
    }

}
