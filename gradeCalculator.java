package InternshipCodes;

import java.util.Scanner;

public class gradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from user to enter the number of subjects.
        System.out.println("\n\t\t\t\tWelcome to Grade Calculator");
        System.out.print("\n* Enter the number of subjects: \n");
        int numSubjects = scanner.nextInt();

        // Initializing an array to store marks for each subject.
        int[] marks = new int[numSubjects];

        // Input marks for each subject.
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("* Enter marks for subject " + (i + 1) + " (out of 100): \n");
            marks[i] = scanner.nextInt();
        }

        // Creating totl marks obtained.
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Calculating Avg
        double averagePercentage = (double) totalMarks / numSubjects;

        // Generating grade based on marks!!
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Displaying final results!!
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
