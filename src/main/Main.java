package main;

import school.School;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String choice;
    static School school;

    public static void main(String[] args) {
        school = new School("Faculty of Technical Science Cacak");
        display();
    }

    public static void display(){
        System.out.println("__*__ Welcome to " + school.getName()+ " __*__");
        System.out.println("1. School\n2. Students\n3. Teachers\n4. Exit");
        choice = input.next();

        //repeat the menu if the user enters invalid option
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")){

            System.out.println("Invalid choice! Please try again.");
            System.out.println("_____Welcome to " + school.getName()+ " school_____");
            System.out.println("1. School\n2. Students\n3. Teachers\n4. Exit");
            choice = input.next();
        }

        switch (choice){
            case "1":
                school();
                break;
            case "2":
                students();
                break;
            case "3":
                teachers();
                break;
            case "4":
                System.exit(0);
                break;
        }
    }

    public static void school(){
        System.out.println("1. Check Teachers\n2. Check Students\n3. Finance\n4. Back");
        choice = input.next();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")){
            System.out.println("Invalid choice! Please try again.");
            System.out.println("1. Check Teachers\n2. Check Students\n3. Finance\n4. Back");
            choice = input.next();
        }

        switch (choice){
            case "1":
                school.listTeachers();
                school();
                break;
            case "2":
                school.listStudents();
                school();
                break;
            case "3":
                finance();
                school();
                break;
            case "4":
                display();
                break;
        }
    }

    public static void students(){
        System.out.println("1. Add student\n2. Select student\n3. Back");
        choice = input.next();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") ){
            System.out.println("Invalid choice! Please try again.");
            System.out.println("1.Add student\n2. Select student\n3. Back");
            choice = input.next();
        }

        switch (choice){
            case "1":
                school.addStudent();
                students();
                break;
            case "2":
                int totalStudents = school.listStudents();

                if(totalStudents>0) school.selectStudent(); //selecting students from the list if there are any
                students();
                break;
            case "3":
                display();
                break;
        }
    }

    public static void teachers(){
        System.out.println("1. Add teacher\n2. Select teacher\n3. Back");
        choice = input.next();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") ){
            System.out.println("Invalid choice! Please try again.");
            System.out.println("1.Add teacher\n2. Select teacher\n3. Back");
            choice = input.next();
        }

        switch (choice){
            case "1":
                school.addTeacher();
                teachers();
                break;
            case "2":
                int totalteachers = school.listTeachers();

                if(totalteachers>0) school.selectTeacher(); //select teacher if there are teachers in the teachers list
                teachers();
                break;
            case "3":
                display();
                break;
        }
    }

    public static void finance(){
        System.out.println("1. Check school balance\n2. Check amount earned\n3. Check amount spent\n4. Back");
        choice = input.next();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")){
            System.out.println("Invalid choice! Please try again.");
            System.out.println("1. Check school balance\n2. Check amount earned\n3. Check amount spent\n4. Back");
        }

        switch (choice){
            case "1":
                System.out.println("The profit made by the school is: " + school.getProfitMade()); //school balance is the profit made
                finance();
                break;
            case "2":
                System.out.println("The total money earned by the school is: " + school.getTotalMoneyEarned());
                finance();
                break;
            case "3":
                System.out.println("The total money spent by the school is: " + school.getTotalMoneySpent());
                finance();
                break;
            case "4":
                school();
                break;
        }
    }
}