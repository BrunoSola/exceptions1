package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner in = new Scanner(System.in);

        System.out.print("Room Number: ");
        int roomNumber = in.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(in.next(), dtf);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(in.next(), dtf);

        if (!checkOut.isAfter(checkIn)){
            System.out.println("Error in reservation: Check-Out date must be after check-in date!");
        }
        else{
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(in.next(), dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(in.next(), dtf);

            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) || checkOut.isBefore(now) ){
                System.out.println("Error in reservation: Reservation dates for update must be future dates!");
            }
            else if (!checkOut.isAfter(checkIn)){
                System.out.println("Error in reservation: Check-Out date must be after check-in date!");
            }
            else {
                reservation.updateDates(checkIn,checkOut);
                System.out.println(reservation);
            }
        }

        in.close();
    }
}
