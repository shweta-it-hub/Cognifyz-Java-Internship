
import java.util.Scanner;
import java.io.*;

public class FileEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("1. Encrypt File");
            System.out.println("2. Decrypt File");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();

            System.out.print("Enter shift value (1-25): ");
            int shift = sc.nextInt();

            if (shift < 1 || shift > 25) {
                System.out.println("Shift must be between 1 and 25.");
                sc.close();
                return;
            }

            File inputFile = new File(fileName);

            if (!inputFile.exists()) {
                System.out.println("File not found: " + fileName);
                sc.close();
                return;
            }

            StringBuilder content = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                new FileReader(inputFile)
            );

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < content.length(); i++) {
                char ch = content.charAt(i);

                if (choice == 1 && ch >= 'A' && ch <= 'Z') {
                    ch = (char) ((ch - 'A' + shift) % 26 + 'A');
                } else if (choice == 1 && ch >= 'a' && ch <= 'z') {
                    ch = (char) ((ch - 'a' + shift) % 26 + 'a');
                } else if (choice == 2 && ch >= 'A' && ch <= 'Z') {
                    ch = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                } else if (choice == 2 && ch >= 'a' && ch <= 'z') {
                    ch = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                }

                result.append(ch);
            }

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice.");
                sc.close();
                return;
            }

            String outputName = choice == 1
                ? "encrypted.txt"
                : "decrypted.txt";

            BufferedWriter writer = new BufferedWriter(
                new FileWriter(outputName)
            );
            writer.write(result.toString());
            writer.close();

            System.out.println("Success! Output saved in " + outputName);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        sc.close();
    }
}
