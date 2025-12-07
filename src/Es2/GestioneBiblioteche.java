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

import Global.Menu;

import java.util.Scanner;

public class GestioneBiblioteche {
    public static final Scanner input = new Scanner(System.in);
    public static String[] opzionigestioneEventi = {
            "Crea Concerto",
            "Crea Conferenza",
            "Crea Morstra Arte",
            "Elimina Evento",
            "Fine"
    };

    public static void gestioneBiblioteche() { //entry point gestione eventi
        System.out.println("Esercizio gestione bibiloteca");
        boolean fine = false;
        int choice = 0;

        do {
            Menu.printMenu("Gestione Eventi Menu", opzionigestioneEventi);
            switch (choice) {
                case 1:
                    System.out.println("Hai scelto ");
                    break;
                case 2:
                    System.out.println("Hai scelto ");
                    break;
                case 3:
                    System.out.println("Hai scelto ");
                    break;
                case 4:
                    System.out.println("Hai scelto ");
                    break;
                case 5:
                    System.out.println("Hai scelto ");
                    break;
                default: System.out.println("Non hai inserto un'opzione valida.");


            }
        } while (!fine);

    }

}
