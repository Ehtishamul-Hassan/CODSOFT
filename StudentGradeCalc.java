package CodSoftInternship;

import java.util.*;

public class StudentGradeCalc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Marks obtained (out of 100) of each subject ");

        // taking marks of each subjects from user
        System.out.print("Enter the marks obtained in Maths : ");
        int math = sc.nextInt();
        System.out.print("Enter the marks obtained in Physics : ");
        int physics = sc.nextInt();
        System.out.print("Enter the marks obtained in Chemistry : ");
        int chemistry = sc.nextInt();
        System.out.print("Enter the marks obtained in English :");
        int english = sc.nextInt();
        System.out.print("Enter the makrs obtained in Computer : ");
        int computer = sc.nextInt();

        // Calculate Average Percentage
        int average = (math + physics + chemistry + english + computer) / 5;
        // Calculate Total Marks
        int totalMarks = math + physics + chemistry + english + computer;

        String grade;

        // Grade Calculator
        if (average >= 90) {
            grade = "Grade A+";
        } else if (average >= 80) {
            grade = "Grade A";
        } else if (average >= 70) {
            grade = "Grade B";
        } else if (average >= 60) {
            grade = "Grade C";
        } else if (average >= 50) {
            grade = "Grade D";
        } else if (average >= 40) {
            grade = "Grade E";
        } else {
            grade = "Grade F";
        }

        System.out.println();
        // Display Results
        System.out.println("Result");
        System.out.println(
                "Total Marks :" + totalMarks + "     " + "Average Percentage :" + average + "     " + "Grade :"
                        + grade);

    }

}

