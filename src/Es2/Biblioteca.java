package Es2;

import Es2.Models.Materiale;
import java.util.ArrayList;

public class Biblioteca {

    private final ArrayList<Materiale> materiali = new ArrayList<>();

    public void aggiungiMateriale(Materiale materiale) {
        materiali.add(materiale);
        System.out.println("Materiale aggiunto.");
    }

    public void visualizzaMateriali() {
        if (materiali.isEmpty()) {
            System.out.println("Nessun materiale presente.");
            return;
        }

        System.out.println("Materiali in biblioteca:");
        for (Materiale m : materiali) {
            System.out.println("- " + m.getInformazioni());
        }
    }

    public void prestaMateriale(int index) {
        if (index < 0 || index >= materiali.size()) {
            System.out.println("Indice non valido.");
            return;
        }

        Materiale m = materiali.get(index);
        System.out.println(m.presta());
    }
}
