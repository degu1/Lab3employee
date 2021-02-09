package lab3;

public class Programmer extends Employee {

    private String language;
    
    public Programmer(String name, int age, String email, String tel, String language) {
        super(name, age, email, tel);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void setBonus(int preformance) {
        super.setBonus(preformance*3); 
    }   
    
    @Override
    public String toString() {
        return "Programmer: " + super.toString() + ", Language: " + language ;
    }
}
