package Global;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GetLocalDate {
    public static LocalDate getLocalDate(Scanner input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();

        while (true) {
            System.out.print("Inserisci una data (dd/MM/yyyy): ");
            String data = input.nextLine();

            try {
                LocalDate date = LocalDate.parse(data, formatter);

                if (date.isBefore(today)) {
                    return date;
                } else {
                    System.out.println("La data deve essere precedente a oggi.");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Formato non valido. Riprova.");
            }
        }
    }

    public static LocalDate getLocalDateFuture(Scanner input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();

        while (true) {
            System.out.print("Inserisci una data (dd/MM/yyyy): ");
            String data = input.nextLine();

            try {
                LocalDate date = LocalDate.parse(data, formatter);

                if (date.isAfter(today)) {
                    return date;
                } else {
                    System.out.println("La data deve essere DOPO la data di oggi");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Formato non valido. Riprova.");
            }
        }
    }
}
