/*Esercizio 4: Sistema di Gestione di Prodotti Alimentari
Descrizione:
Crea un sistema per gestire diversi tipi di prodotti alimentari in un supermercato. Ogni tipo di
prodotto ha un prezzo e una quantità disponibile, ma alcuni prodotti possono essere in sconto.
Requisiti:
1. Crea una classe base Prodotto con i seguenti attributi:
• nome, prezzo, quantitaDisponibile.
• Metodo:
• calcolaPrezzoTotale(int quantita): calcola il prezzo totale per
la quantità desiderata.
2. Crea le seguenti classi derivate:
• ProdottoAlimentare: Aggiungi un attributo dataScadenza e un metodo
calcolaPrezzoTotale() che applica uno sconto se il prodotto è vicino alla
scadenza.
• ProdottoBevanda: Aggiungi un attributo volume (in millilitri) e un metodo
calcolaPrezzoTotale() che applica uno sconto su bevande di grande volume.
3. Crea una classe Supermercato che:
• Contiene un elenco di prodotti.
• Ha un metodo aggiungiProdotto(Prodotto prodotto) per aggiungere
un prodotto al supermercato.
• Ha un metodo calcolaIncassoTotale() che somma il prezzo totale di tutti i
prodotti venduti.
4. Crea un programma Main che:
• Aggiunga prodotti al supermercato e calcoli l'incasso totale.*/



package Es4;

import Global.Menu;

import java.util.Scanner;

public class GestioneProdotti {
    public static final Scanner input = new Scanner(System.in);
    public static String[] opzionigestioneEventi = {
            "Crea Concerto",
            "Crea Conferenza",
            "Crea Morstra Arte",
            "Elimina Evento",
            "Fine"
    };

    public static void gestioneProdotti() { //entry point gestione eventi
        System.out.println("Esercizio gestione prodotti");
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
