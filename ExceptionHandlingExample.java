
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        try {

            // Open the file
            BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));

            // Read data from file
            String line = br.readLine();

            // Close the file
            br.close();

            // Convert string to integer
            int number = Integer.parseInt(line);

            // Divide 100 by the number
            int result = 100 / number;

            // Display result
            System.out.println("Result = " + result);

        }

        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        catch (IOException e) {
            System.out.println("Error: Problem reading the file.");
        }

        catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number in file.");
        }

        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}