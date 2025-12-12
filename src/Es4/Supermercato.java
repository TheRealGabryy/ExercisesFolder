package Es4;

import Es4.Models.Prodotto;
import java.util.ArrayList;

public class Supermercato {

    private ArrayList<Prodotto> prodotti = new ArrayList<>();
    private double incassoTotale = 0;

    public void aggiungiProdotto(Prodotto p) {
        prodotti.add(p);
        System.out.println("Prodotto aggiunto.");
    }

    public void visualizzaProdotti() {
        if (prodotti.isEmpty()) {
            System.out.println("Nessun prodotto disponibile.");
            return;
        }

        for (int i = 0; i < prodotti.size(); i++) {
            System.out.println(i + " " + prodotti.get(i).getInfo());
        }
    }

    public void vendiProdotto(int index, int quantita) {
        if (index < 0 || index >= prodotti.size()) {
            System.out.println("Indice non valido.");
            return;
        }

        Prodotto p = prodotti.get(index);

        if (quantita > p.quantitaDisponibile) {
            System.out.println("Quantità non disponibile.");
            return;
        }

        double totale = p.calcolaPrezzoTotale(quantita);
        incassoTotale += totale;
        p.quantitaDisponibile -= quantita;

        System.out.println("Vendita completata. Totale: " + totale);
    }

    public double calcolaIncassoTotale() {
        return incassoTotale;
    }
}
