package school;

import students.Student;
import teachers.Teacher;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private int totalMoneyEarned;
    private  int totalMoneySpent;
    private String name;
    private String choice;
    static Scanner input = new Scanner(System.in);

    public School(String name) {
        this.name = name;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
    }

    public School(String name, List<Teacher> teachers, List<Student> students) {
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void updateTotalMoneyEarned(int totalMoneyEarned) {
        this.totalMoneyEarned += totalMoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void updateTotalMoneySpent(int totalMoneySpent) {
        this.totalMoneySpent += totalMoneySpent;
    }

    public int getProfitMade(){
        return getTotalMoneyEarned() - getTotalMoneySpent();
    }

    public int listTeachers(){
        if(teachers.isEmpty()){
            System.out.println("No teachers added!");
        }else{
            System.out.println("ID\tName\t\tSalary\tPaid\tUnpaid");
            for (Teacher teacher:
                    teachers) {
                System.out.println(teacher.getId() + "\t" + teacher.getName() + "\t" + teacher.getSalary() + "\t" + teacher.getRecievedSalary() + "\t" + teacher.getUnpaidSalary());
            }
        }
        return teachers.size();
    }

    public int listStudents(){
        if(students.isEmpty()){
            System.out.println("No student added!");
        }else{
            System.out.println("Id\tName\t\tGrade\tPaid Fees\tBalance");
            for (Student student: students
            ) {
                System.out.println(student.getId() + "\t" + student.getName() + "\t\t" + student.getGrade() + "\t" + student.getPaidFees() + "\t" + student.getFeeBalance());
            }
        }
        return students.size();
    }

    public void addStudent(){
        //getting student's id
        System.out.println("Enter student's id");
        int id = getIntInput();

        //getting student's name
        System.out.println("Enter student's name");
        String name = input.nextLine();

        //getting student's grade
        int grade = 0;
        while (grade<=0 || grade>6){
            System.out.println("Enter student's grade : 1 - 6");
            grade = getIntInput();
        }

        //adding student object to  list
        this.students.add(new Student(id, name, grade));
        System.out.println("Student added successfully to the student's list.");
    }

    public void addTeacher(){
        System.out.println("Enter the teacher's id: ");
        int id = getIntInput();
        System.out.println("Enter the teacher's name: ");
        String name = input.nextLine();
        System.out.println("Enter the teacher's salary");
        int salary = getIntInput();
        teachers.add(new Teacher(id, name, salary)); //adding teachers object to the teachers list
        System.out.println("Teacher added successfully to the teachers list");
    }

    public void selectStudent(){
        System.out.println("Enter the student's id : ");
        int id = getIntInput();
        boolean found = false;
        for (Student student: students
        ) {
            if(student.getId() == id){
                found = true;
                studentDetails(student);
            }
        }
        if (!found)  System.out.println("No student with id: " + id) ;
    }

    public void selectTeacher(){
        System.out.println("Enter the teacher's id : ");
        int id = getIntInput();
        boolean found = false;
        for (Teacher teacher: teachers
        ) {
            if(teacher.getId() == id){
                found = true;
                teacherDetails(teacher);
            }
        }
        if (!found)  System.out.println("No teacher with id: " + id) ;
    }

    public void studentDetails(Student student){
        System.out.println("Student details for: " + student.getName());
        System.out.println("1. Pay fees\n2. Edit details\n3. Cancel");
        choice = input.next();

        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")){
            System.out.println("Invalid choice! Please try again");
            System.out.println("1. Pay fees\n2. Edit details\3. Cancel");
            choice = input.next();
        }

        input.nextLine(); //discard the input

        switch (choice){
            case "1":
                payStudentFees(student);
                break;
            case "2":
                editStudentDetails(student);
                break;
            case "3":
                // return to student menu
        }

    }

    public void teacherDetails(Teacher teacher){
        System.out.println("Teacher details for: " + teacher.getName());
        System.out.println("1. Pay salary\n2. Edit details\n3. Cancel");
        choice = input.next();

        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")){
            System.out.println("Invalid choice! Please try again");
            System.out.println("1. Pay salary\n2. Edit details\3. Cancel");
            choice = input.next();
        }

        input.nextLine();  //discard the input

        switch (choice){
            case "1":
                payTeacherSalary(teacher);
                break;
            case "2":
                editTeacherDetails(teacher);
                break;
            case "3":
                //on cancel the program will return to the students menu
        }
    }

    public void editStudentDetails(Student student){
        System.out.println("Edit details for: " + student.getName());
        System.out.println("Enter student's new name");
        String name = input.nextLine();
        int grade = 0;
        while (grade<=0 || grade>6){
            System.out.println("Enter student's new grade : 1 - 6");
            grade = getIntInput();
        }
        student.setName(name);
        student.setGrade(grade);
        System.out.println("Student's details updated successfully");
    }

    public void payStudentFees(Student student){
        System.out.println("Pay fees for : " + student.getName());
        System.out.println("Enter the amount to pay");
        int fee = getIntInput();
        student.payFees(fee);
        updateTotalMoneyEarned(fee); //update total money earned by the school
        System.out.println(fee + " successfully paid for " + student.getName() + ". The balance is: " + student.getFeeBalance());
    }

    public void payTeacherSalary(Teacher teacher){
        System.out.println("Pay salary to : " + teacher.getName());
        System.out.println("Enter the amount to pay");
        int salary = getIntInput();
        teacher.recieveSalary(salary);
        updateTotalMoneySpent(salary);  //update total money spent by the school
        System.out.println(salary + " successfully paid to " + teacher.getName() + ". The unpaid amount is : " + teacher.getUnpaidSalary());
    }

    public void editTeacherDetails(Teacher teacher){
        System.out.println("Edit details for : " + teacher.getName());
        System.out.println("Enter teacher's new name");
        String name = input.nextLine();
        System.out.println("Enter the teacher's new salary");
        int salary = getIntInput();
        teacher.setName(name);
        teacher.setSalary(salary);
        System.out.println("Teachers details updated successfully.");
    }

    public int getIntInput(){
        boolean badInput = true;
        int integer = 0;
        while (badInput){
            try {
                integer = input.nextInt();
                badInput = false;
                input.nextLine();  //discard the input
            }
            catch (InputMismatchException e){
                System.out.println("Please enter an integer value");
                input.nextLine(); //discard the input
            }
        }
        return integer;
    }


}
