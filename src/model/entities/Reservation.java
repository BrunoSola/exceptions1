package model.entities;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public long duration(){
        Period diff = Period.between(checkIn, checkOut);
        return diff.get(ChronoUnit.DAYS);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reservation: ");
        sb.append("Room ").append(roomNumber);
        sb.append(", check-In: ").append(checkIn.format(dtf));
        sb.append(", check-Out: ").append(checkOut.format(dtf));
        sb.append(", ").append(duration()).append(" nights.");
        return sb.toString();
    }
}
