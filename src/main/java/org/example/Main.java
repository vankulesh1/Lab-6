package org.example;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);

        int[] seatsToBook = {2, 3, 4};
        cinema.bookSeats(1, 3, seatsToBook);

        // Declare hallNumber within the main method
        int hallNumber;

        // Get input for hallNumber
        System.out.print("Enter the hall number: ");
        hallNumber = scanner.nextInt();

        // Call the printSeatingArrangement method
        cinema.printSeatingArrangement(hallNumber);

        int[] seatsToCancel = {3, 4};
        cinema.cancelBooking(1, 3, seatsToCancel);

        cinema.printSeatingArrangement(1);

        int numSeatsToCheck = 4;
        boolean availability = false;
        System.out.println("Доступні " + numSeatsToCheck + " послідовних місць: " + availability);





        int choice;
        do {
            System.out.println("\n1. Забронювати місця");
            System.out.println("2. Скасувати бронювання");
            System.out.println("3. Перевірити доступність місць");
            System.out.println("4. Друк схеми розміщення місць");
            System.out.println("5. Автоматичне бронювання");
            System.out.println("0. Вийти");

            System.out.print("Оберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Забронювати місця
                    // Введення: номер залу, номер ряду, місця для бронювання
                    System.out.print("Номер залу: ");
                    hallNumber = scanner.nextInt();  // Remove the "int" declaration
                    System.out.print("Номер ряду: ");
                    int row = scanner.nextInt();
                    System.out.print("Місця для бронювання (розділені пробілами): ");
                    String seatsInput = scanner.nextLine(); // Щоб вивести буфер нового рядка
                    seatsInput = scanner.nextLine();
                    int[] seatsToBookInput = Arrays.stream(seatsInput.split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    cinema.bookSeats(hallNumber, row, seatsToBookInput);
                    break;

                case 2:
                    // Скасувати бронювання
                    // Введення: номер залу, номер ряду, місця для скасування

                    System.out.print("Номер залу: ");
                    hallNumber = scanner.nextInt();
                    System.out.print("Номер ряду: ");
                    row = scanner.nextInt();
                    System.out.print("Місця для скасування (розділені пробілами): ");
                    String cancelSeatsInput = scanner.nextLine(); // Щоб вивести буфер нового рядка
                    cancelSeatsInput = scanner.nextLine();
                    int[] cancelBooking = Arrays.stream(cancelSeatsInput.split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    cinema.cancelBooking(hallNumber, row, cancelBooking);
                    break;

                case 3:
                    // Перевірити доступність місць
// Введення: номер залу, кількість місць
                    System.out.print("Номер залу: ");
                    hallNumber = scanner.nextInt();
                    System.out.print("Кількість місць: ");
                    numSeatsToCheck = scanner.nextInt();
// Choose the row you want to check for availability
                    System.out.print("Номер ряду: ");
                    int rowToCheck = scanner.nextInt();
                    availability = cinema.checkAvailability(hallNumber, rowToCheck, numSeatsToCheck);
                    System.out.println("Доступні " + numSeatsToCheck + " послідовних місць: " + availability);
                    break;

                case 4:
                    // Друк схеми розміщення місць
                    // Введення: номер залу
                    System.out.print("Номер залу: ");
                    hallNumber = scanner.nextInt();
                    cinema.printSeatingArrangement(hallNumber);
                    break;

                case 5:
                    // Автоматичне бронювання
                    // Введення: номер залу, кількість місць
                    System.out.print("Номер залу: ");
                    hallNumber = scanner.nextInt();
                    System.out.print("Кількість місць для автоматичного бронювання: ");
                    int numSeatsToAutoBook = scanner.nextInt();
                    cinema.autoBook(hallNumber, numSeatsToAutoBook);
                    break;

                case 0:
                    // Вийти з програми
                    System.out.println("Дякуємо за використання нашого кінотеатру!");
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        } while (choice != 0);

        scanner.close();



    }
}
