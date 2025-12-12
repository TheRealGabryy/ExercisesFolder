/*
* Esercizio 2: Gestione di un Sistema di Biblioteche
Descrizione:
Crea un sistema per la gestione di libri in una biblioteca che gestisce libri e riviste, sfruttando
l'ereditarietà per differenziare le due tipologie di media.
Requisiti:
1. Crea una classe base Materiale con i seguenti attributi:
• titolo, autore, annoPubblicazione.
• Metodi:
• getInformazioni(): restituisce le informazioni generali sul materiale
(titolo, autore, anno).
• presta(): restituisce un messaggio che indica che il materiale è stato
prestato.
2. Crea le seguenti classi derivate:
• Libro: Aggiungi un attributo numeroPagine e un metodo
getInformazioni() che include il numero di pagine.
• Rivista: Aggiungi un attributo numeroRivista e un metodo
getInformazioni() che include il numero della rivista.
3. Crea una classe Biblioteca che:
• Contiene un elenco di materiali (usando composizione).
• Ha un metodo aggiungiMateriale(Materiale materiale) per
aggiungere un materiale alla biblioteca.
• Ha un metodo visualizzaMateriali() per visualizzare tutti i materiali
presenti.
• Ha un metodo prestaMateriale(Materiale materiale) per prestare un
materiale.
4. Crea un programma Main che:
• Crea oggetti di tipo Libro e Rivista.
• Gestisce l'aggiunta, la visualizzazione e il prestito dei materiali.
*/



package Es2;

import Es2.Models.*;
import Global.GetLocalDate;
import Global.Menu;

import java.time.LocalDate;
import java.util.Scanner;


public class GestioneBiblioteche {

    public static final Scanner input = new Scanner(System.in);
    public static final Biblioteca biblioteca = new Biblioteca();
    public static String[] opzioni = {
            "Aggiungi Libro",
            "Aggiungi Rivista",
            "Visualizza Materiali",
            "Presta materiale",
            "Fine"
    };

    public static void inserisciLibro() {
        String titolo, autore;
        LocalDate anno;
        int pagine = 0;
        System.out.print("Titolo: ");
        do {
            System.out.print("-> ");
            titolo = input.nextLine();
            if (checkInput(titolo)) {
                System.out.print("Hai inserito un Titolo non valido. riprova.");
            }
        } while (checkInput(titolo));
        System.out.print("Titolo inserito correttamente");
        System.out.print("Autore: ");
        do {
            System.out.print("-> ");
            autore = input.nextLine();
            if (checkInput(autore)) {
                System.out.print("Hai inserito un Autore");
            }
        } while (checkInput(autore));
        System.out.print("Autore inserito Correttamente");
        System.out.print("Anno: ");
        anno = readDate();

        System.out.print("Pagine: ");
        do {
            System.out.print("-> ");
            try {
                pagine = input.nextInt();
            } catch (Exception e) {
                System.out.println("Non hai inserito un intero");
                input.nextLine();
                continue;
            }
            if (pagine < 1 || pagine > 10000) {
                System.out.println("Non hai inserito un valore valido. riprova.");
            }
        } while (pagine < 1 || pagine > 10000);
        biblioteca.aggiungiMateriale(new Libro(titolo, autore, anno, pagine));
    }

    public static void inserisciRivista() {
        String titolo, autore;
        LocalDate anno;
        int nRivista = 0;
        System.out.print("Titolo: ");
        do {
            System.out.print("-> ");
            titolo = input.nextLine();
            if (checkInput(titolo)) {
                System.out.print("Non hai inserito il titolo della rivista correttamente, riprova.");
            }
        } while (checkInput(titolo));
        System.out.print("Titolo inserito correttamente");
        System.out.print("Autore: ");
        do {
            System.out.print("-> ");
            autore = input.nextLine();
            if (checkInput(autore)) {
                System.out.print("Hai inserito un Autore non corretto, riprova.");
            }
        } while (checkInput(autore));
        System.out.print("Anno: ");
        anno = readDate();
        System.out.print("Numero rivista: ");
        do {
            System.out.print("-> ");
            try {
                nRivista = input.nextInt();
            } catch (Exception e) {
                System.out.println("Non hai inserito un intero");
                input.nextLine();
                continue;
            }
            if (nRivista < 1 || nRivista > 10000) {
                System.out.println("Non hai inserito un valore valido. riprova.");
            }
        } while (nRivista < 1 || nRivista > 10000);
        biblioteca.aggiungiMateriale(new Rivista(titolo, autore, anno, nRivista));
    }

    public static void gestioneBiblioteche() {
        boolean fine = false;

        while (!fine) {

            Menu.printMenu("Gestione Biblioteca", opzioni);
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Inserisci un libro");
                    inserisciLibro();
                    break;

                case 2:
                    System.out.println("Inserisci rivista");
                    inserisciRivista();
                    break;

                case 3:
                    System.out.println("Visualizza Materiali");
                    biblioteca.visualizzaMateriali();
                    break;

                case 4:
                    System.out.println("Presta materiale. Materiali:");
                    biblioteca.visualizzaMateriali();
                    System.out.print("Inserisci indice materiale da prestare: ");
                    int idx = input.nextInt();
                    biblioteca.prestaMateriale(idx);
                    break;

                case 5:
                    System.out.println("Fine programma");
                    fine = true;
                    break;
                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }

    public static boolean checkInput(String input) {
        if (input.length() < 3) {
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static LocalDate readDate() {
        return GetLocalDate.getLocalDate(input);
    }

}

