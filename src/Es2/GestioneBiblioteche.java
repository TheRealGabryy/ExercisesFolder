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
import Global.Menu;
import java.util.Scanner;

public class GestioneBiblioteche {

    public static final Scanner input = new Scanner(System.in);

    public static String[] opzioni = {
            "Aggiungi Libro",
            "Aggiungi Rivista",
            "Visualizza Materiali",
            "Presta materiale",
            "Fine"
    };

    public static void gestioneBiblioteche() {

        Biblioteca biblioteca = new Biblioteca();
        boolean fine = false;

        while (!fine) {

            Menu.printMenu("Gestione Biblioteca", opzioni);
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Titolo: ");
                    String t = input.nextLine();
                    System.out.print("Autore: ");
                    String a = input.nextLine();
                    System.out.print("Anno: ");
                    int an = input.nextInt();
                    System.out.print("Pagine: ");
                    int p = input.nextInt();
                    input.nextLine();
                    biblioteca.aggiungiMateriale(new Libro(t, a, an, p));
                    break;

                case 2:
                    System.out.print("Titolo: ");
                    String t2 = input.nextLine();
                    System.out.print("Autore: ");
                    String a2 = input.nextLine();
                    System.out.print("Anno: ");
                    int an2 = input.nextInt();
                    System.out.print("Numero rivista: ");
                    int nr = input.nextInt();
                    input.nextLine();
                    biblioteca.aggiungiMateriale(new Rivista(t2, a2, an2, nr));
                    break;

                case 3:
                    biblioteca.visualizzaMateriali();
                    break;

                case 4:
                    System.out.print("Inserisci indice materiale da prestare: ");
                    int idx = input.nextInt();
                    biblioteca.prestaMateriale(idx);
                    break;

                case 5:
                    fine = true;
                    break;

                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }
}

