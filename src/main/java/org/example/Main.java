package org.example;
public class Main {
    public static void main(String[] args) {
        // Приклад використання
        Cinema cinema = new Cinema();

        int[] seatsToBook = {2, 3, 4};
        cinema.bookSeats(1, 3, seatsToBook);

        cinema.printSeatingArrangement(1);

        int[] seatsToCancel = {3, 4};
        cinema.cancelBooking(1, 3, seatsToCancel);

        cinema.printSeatingArrangement(1);

        int numSeatsToCheck = 4;
        boolean availability = cinema.checkAvailability(1, 5, numSeatsToCheck);
        System.out.println("Доступні " + numSeatsToCheck + " послідовних місць: " + availability);
    }
}
