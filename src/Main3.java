import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = scanner.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = dateFormat.parse(scanner.next());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = dateFormat.parse(scanner.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = dateFormat.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = dateFormat.parse(scanner.next());

            Date now = new Date();

            String error = reservation.updateDates(checkIn, checkIn);

            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println("Reservation Updated: " + reservation);
            }
        }

        scanner.close();
    }
}
