import java.util.Scanner;

public class GradeCalculator {
    public static String calculateGrade(double avgPer) {
        if (avgPer >= 90) {
            return "A+";
        } else if (avgPer >= 80) {
            return "A";
        } else if (avgPer >= 70) {
            return "B";
        } else if (avgPer >= 60) {
            return "C";
        } else if (avgPer >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subject = sc.nextInt();

        int[] marks = new int[subject];
        for (int i = 0; i < subject; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
        }

        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double avgPer = ((double) totalMarks / (subject * 100)) * 100;
        String grade = calculateGrade(avgPer);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", avgPer);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
