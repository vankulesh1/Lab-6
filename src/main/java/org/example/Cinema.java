package org.example;

import java.util.Arrays;
public class Cinema {
    private int[][][] seats;

    public Cinema() {

        seats = new int[5][10][20];

        for (int hall = 0; hall < 5; hall++) {
            for (int row = 0; row < 10; row++) {
                for (int seat = 0; seat < 20; seat++) {
                    seats[hall][row][seat] = 0;
                }
            }
        }
    }

    // бронювання місць
    public void bookSeats(int hallNumber, int row, int[] seatsToBook) {
        for (int seat : seatsToBook) {
            if (seats[hallNumber][row][seat] == 0) {
                seats[hallNumber][row][seat] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " заброньоване.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " вже заброньоване.");
            }
        }
    }

    // скасування бронювання
    public void cancelBooking(int hallNumber, int row, int[] seatsToCancel) {
        for (int seat : seatsToCancel) {
            if (seats[hallNumber][row][seat] == 1) {
                seats[hallNumber][row][seat] = 0;
                System.out.println("Бронювання для місця " + seat + " в ряду " + row + " скасоване.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " не було заброньоване.");
            }
        }
    }

    // перевірка наявності заданої кількості місць, що йдуть послідовно
    public boolean checkAvailability(int hallNumber, int row, int numSeats) {
        for (int seat = 0; seat <= 20 - numSeats; seat++) {
            boolean available = true;
            for (int i = 0; i < numSeats; i++) {
                if (seats[hallNumber][row][seat + i] == 1) {
                    available = false;
                    break;
                }
            }
            if (available) {
                return true;
            }
        }
        return false;
    }

    // Метод для друку схеми розміщення місць
    public void printSeatingArrangement(int hallNumber) {
    System.out.println("Схема розміщення місць для залу " + hallNumber + ":");

            for (int row = 0; row < 10; row++) {
                for (int seat = 0; seat < 20; seat++) {
                    if (seats[hallNumber][row][seat] == 0) {
                        System.out.print("\u001B[32mO \u001B[0m"); // вільне місце
                    } else {
                        System.out.print("\u001B[31mX \u001B[0m"); // заброньоване місце
                    }
                }
                System.out.println();
            }
        }


    public int[] findBestAvailableSeats(int hallNumber, int numSeats) {
        for (int row = 0; row < 10; row++) {
            for (int seat = 0; seat <= 20 - numSeats; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (seats[hallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    return Arrays.copyOfRange(seats[hallNumber][row], seat, seat + numSeats);
                }
            }
        }
        return null; // Немає доступн місць
    }


    public void autoBook(int hallNumber, int numSeats) {
        int[] bestAvailableSeats = findBestAvailableSeats(hallNumber, numSeats);

        if (bestAvailableSeats != null) {
            bookSeats(hallNumber, findAvailableRow(hallNumber, numSeats), bestAvailableSeats);
            System.out.println("Автоматичне бронювання " + numSeats + " послідовних місць успішно.");
        } else {
            System.out.println("Немає достатньої кількості послідовних вільних місць.");
        }
    }


    private int findAvailableRow(int hallNumber, int numSeats) {
        for (int row = 0; row < 10; row++) {
            if (checkAvailability(hallNumber, row, numSeats)) {
                return row;
            }
        }
        return -1; // Немає рядів
    }
}