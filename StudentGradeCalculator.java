
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of grades: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid number!");
            sc.close();
            return;
        }

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = sc.nextDouble();

            total = total + grade;
        }

        double average = total / n;

        System.out.println("----------------------------");
        System.out.println("Total Grades: " + n);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Grade: " + average);
        System.out.println("----------------------------");

        sc.close();
    }
}
