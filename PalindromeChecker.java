
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String text = sc.nextLine();

        String cleaned = text.toLowerCase()
                .replaceAll("[^a-z0-9]", "");

        String reversed = new StringBuilder(cleaned)
                .reverse().toString();

        if (cleaned.equals(reversed)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }

        sc.close();
    }
}
