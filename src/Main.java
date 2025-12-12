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
        String[] lines = {
                "Questi sono gli esercizi che mi hai mandato per mail",
                "Li ho fatti tutti in un solo progetto",
                "Così era più carino da controllare un PRG più grande",
                "Per scegliere l'esercizio puoi usare il menù",
                "Oppure farli tutti in sequenza con l'ultima opzione",
                "Ho aggiunto alcune cose agli esercizi",
                "Per renderli un po più complessi e vicini al mondo reale",
                "Ma nella Struttura ho seguito le istruzioni"
        };
        System.out.println("[INVIO per continuare, digita skip per saltare]");
        for (String line : lines) {
            System.out.print(line);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("skip")) {
                System.out.println("Paragrafo skippato");
                return;
            }
        }
        System.out.println();
        System.out.println("Primo paragrafo completato, premi INVIO per continuare o digita 'skip' per saltare");
        String inp = sc.nextLine();
        if (inp.equalsIgnoreCase("skip")) {
            System.out.println("Paragrafo skippato");
            return;
        }

        print2();
    }


    public static void print2() throws InterruptedException {
        String[] lines = {
                "Essendo che sono un Accanitissimo di Intelligenza artificiale",
                "Nell'ultimo esercizio (quello della gestione degli assistenti AI)",
                "Ho Creato un mini modello di Generative Pretrained Transformer",
                "Con un minuscolo dataset che è in grado di completare certe parole",
                "Ho integrato l'AI con OpenAI API nei vari assistenti",
                "Ho creato una mini interfaccia JavaFX per visualizzare immagini",
                "Ho creato la documentazione e README.md"
        };
        System.out.println("[INVIO per continuare, digita skip per saltare]");
        for (String line : lines) {
            System.out.println(line);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("skip")) return;
        }
    }

}