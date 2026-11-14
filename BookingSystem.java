import java.util.Scanner;

// Custom Exception
class BookingException extends Exception {

    public BookingException(String message) {
        super(message);
    }
}

public class BookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Input
            System.out.print("Enter available seats: ");
            int availableSeats = sc.nextInt();

            System.out.print("Enter requested seats: ");
            int requestedSeats = sc.nextInt();

            // Check if flight is fully booked
            if (availableSeats == 0) {
                throw new BookingException("Flight is fully booked");
            }

            // Check invalid seat request
            if (requestedSeats <= 0) {
                throw new IllegalArgumentException(
                    "Requested seats must be greater than 0"
                );
            }

            // Check insufficient seats
            if (requestedSeats > availableSeats) {
                throw new RuntimeException(
                    "Not enough seats available"
                );
            }

            // Successful booking
            System.out.println("Booking successful!");
            System.out.println(
                requestedSeats + " seat(s) reserved."
            );

        }

        // Handle custom exception
        catch (BookingException e) {
            System.out.println("Booking Error: " + e.getMessage());
        }

        // Handle illegal argument
        catch (IllegalArgumentException e) {
            System.out.println("Input Error: " + e.getMessage());
        }

        // Handle runtime exception
        catch (RuntimeException e) {
            System.out.println("Runtime Error: " + e.getMessage());
        }

        // Handle any other exception
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        sc.close();
    }
}