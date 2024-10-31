import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(scanner.nextLine(), dateFormat);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(scanner.nextLine(), dateFormat);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(scanner.nextLine(), dateFormat);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(scanner.nextLine(), dateFormat);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation Updated: " + reservation);

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
