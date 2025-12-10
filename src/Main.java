import Es1.GestioneEventi;
import Global.Menu;

import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    public static final String[] mainOpzioni = {
            "Esercizio Eventi",
            "Gestione Biblioteca",
            "Gestione Prodotti",
            "Gestione Prenotazioni",
            "Gestione Assistenti AI",
            "Tutti in sequenza",
            "Fine"
    };

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Esercizi GB");
        print();
        boolean fine = false;
        int chose = 0;
        do {
            Menu.printMenu("Main Menu", mainOpzioni);
            try {
                chose = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Non hai inserito un intero");
                sc.nextLine();
                continue;
            }
            switch (chose) {
                case 1:
                    System.out.println("Esercizio gestione eventi");
                    GestioneEventi.gestioneEventi();
                    break;
                case 2:
                    System.out.println("Esercizio gestione biblioteca");

                    break;
                case 3:
                    System.out.println("Esercizio gestione prodotti");
                    break;
                case 4:
                    System.out.println("Esercizio gestione prenotazioni");
                    break;
                case 5:
                    System.out.println("Esercizio gestione assistenti AI");
                    break;
                case 6:
                    System.out.println("Tutti gli esercizi uno dieto l'altro");
                    break;
                case 7:
                    System.out.println("Fine");
                    fine = true;
                    break;
                default:
                    System.out.println("Non hai inserito un'opzione valida");
                    break;
            }
        } while (!fine);



    }

    public static void print() throws InterruptedException {
        System.out.println("Questi sono gli esercizi che mi hai mandato per mail");
        Thread.sleep(2000);
        System.out.println("Li ho fatti tutti in un solo progetto");
        Thread.sleep(2000);
        System.out.println("Così era più carino da controllare un PRG più grande");
        Thread.sleep(2000);
        System.out.println("Per scegliere l'esercizio puoi usare il menù");
        Thread.sleep(2000);
        System.out.println("Oppure farli tutti in sequenza con l'ultima opzione");
        Thread.sleep(3000);
        System.out.println("Ho aggiunto alcune cose agli esercizi");
        Thread.sleep(3000);
        System.out.println("Per renderli un po più complessi e vicini al mondo reale");
        Thread.sleep(2000);
        System.out.println("Ma nella Struttura ho seguito le istruzioni");
        Thread.sleep(2000);
        System.out.println("Premi invio per continuare ---- ");
        String invio = sc.nextLine();
        print2();
    }

    public static void print2() throws InterruptedException {
        System.out.println("Essendo che sono un Accanitissimo di Intelligenza artificiale");
        Thread.sleep(2000);
        System.out.println("Nell'ultimo esercizio (quello della gestione degli assistenti AI)");
        Thread.sleep(2000);
        System.out.println("Ho Creato un mini modello di Generative Pretrained Transformer (stesso algoritmo di ChatGPT)");
        Thread.sleep(2000);
        System.out.println("Con un minuscolo dataset che è in grado di completare certe parole");
        Thread.sleep(3000);
        System.out.println("Mentre per gli altri assistenti (Vocale, Visivo), ho integrato effettivamente L'AI con OpenAI API");
        Thread.sleep(2000);
        System.out.println("Infine con l'assistente visivo ho creato una mini interfaccia con JavaFX per poter visualizzare le immagini");
        Thread.sleep(2000);
        System.out.println("Infine ho creato la documentazione di come funziona l'argoritmo e tutti i file README.md");
        Thread.sleep(2000);
        System.out.println("Premi invio per continuare ---- ");
        String invio = sc.nextLine();


    }
}