
import java.util.Scanner;
import java.security.SecureRandom;

public class RandomPasswordGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special = "!@#$%^&*";

        String characters = "";
        String password = "";

        System.out.println("================================");
        System.out.println("    RANDOM PASSWORD GENERATOR");
        System.out.println("================================");

        System.out.print("Enter password length (minimum 4): ");
        int length = sc.nextInt();

        if (length < 4) {
            System.out.println("Password length must be at least 4.");
            sc.close();
            return;
        }

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = sc.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = sc.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = sc.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecial = sc.next().equalsIgnoreCase("y");

        if (useLower) {
            characters += lowercase;
            password += lowercase.charAt(random.nextInt(lowercase.length()));
        }

        if (useUpper) {
            characters += uppercase;
            password += uppercase.charAt(random.nextInt(uppercase.length()));
        }

        if (useNumbers) {
            characters += numbers;
            password += numbers.charAt(random.nextInt(numbers.length()));
        }

        if (useSpecial) {
            characters += special;
            password += special.charAt(random.nextInt(special.length()));
        }

        if (characters.isEmpty()) {
            System.out.println("Please select at least one character type.");
            sc.close();
            return;
        }

        while (password.length() < length) {
            int index = random.nextInt(characters.length());
            password += characters.charAt(index);
        }

        char[] result = password.toCharArray();

        for (int i = result.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            char temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        System.out.println("--------------------------------");
        System.out.println("Generated Password: " + new String(result));
        System.out.println("--------------------------------");

        sc.close();
    }
}
