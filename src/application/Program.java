package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Room Number: ");
            int roomNumber = in.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(in.next(), dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(in.next(), dtf);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(in.next(), dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(in.next(), dtf);

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (DateTimeParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        in.close();
    }
}
