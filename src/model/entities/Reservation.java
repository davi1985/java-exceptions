package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate
            checkIn, LocalDate checkOut) throws DomainException {
        validateDates(checkIn);

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        validateDates(checkIn, checkOut);

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    private void validateDates(LocalDate checkIn) throws DomainException {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }
    }

    private void validateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }

        if (!checkOut.isAfter(checkOut)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: " + dateFormat.format(checkIn)
                + ", check-out: " + dateFormat.format(checkOut)
                + ", " + duration()
                + " nights";
    }
}
