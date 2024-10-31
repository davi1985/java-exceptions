import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = dateFormat.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = dateFormat.parse(scanner.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = dateFormat.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = dateFormat.parse(scanner.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation Updated: " + reservation);

        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
