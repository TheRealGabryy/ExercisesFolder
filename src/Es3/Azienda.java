package Es3;

import Es3.Models.Risorsa;
import java.util.ArrayList;

public class Azienda {

    private ArrayList<Risorsa> risorse = new ArrayList<>();

    public void aggiungiRisorsa(Risorsa r) {
        risorse.add(r);
        System.out.println("Risorsa aggiunta.");
    }

    public void visualizzaRisorse() {
        if (risorse.isEmpty()) {
            System.out.println("Nessuna risorsa presente.");
            return;
        }

        for (Risorsa r : risorse) {
            System.out.println(r.getInfo());
        }
    }

    public double calcolaStipendioTotale() {
        double totale = 0;
        for (Risorsa r : risorse) {
            totale += r.calcolaRetribuzione();
        }
        return totale;
    }
}
