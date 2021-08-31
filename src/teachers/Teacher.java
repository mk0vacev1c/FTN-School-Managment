package teachers;

public class Teacher {
    private int id;
    private String name;
    private int salary;
    private int recievedSalary;

    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.recievedSalary = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getRecievedSalary() {
        return recievedSalary;
    }

    public void setRecievedSalary(int recievedSalary) {
        this.recievedSalary = recievedSalary;
    }

    //recieved salary
    public void recieveSalary(int salary){
        recievedSalary += salary;
    }

    //remaining salary for payment
    public int getUnpaidSalary(){
        return getSalary() - getRecievedSalary();
    }
}
