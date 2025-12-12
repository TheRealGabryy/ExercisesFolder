package Es4.Models;

import java.time.LocalDate;

public class ProdottoAlimentare extends Prodotto {

    private LocalDate dataScadenza;

    public ProdottoAlimentare(String nome, double prezzo, int quantitaDisponibile, LocalDate dataScadenza) {
        super(nome, prezzo, quantitaDisponibile);
        this.dataScadenza = dataScadenza;
    }

    @Override
    public double calcolaPrezzoTotale(int quantita) {

        double totale = prezzo * quantita;

        LocalDate oggi = LocalDate.now();
        LocalDate limiteSconto = oggi.plusDays(3);

        if (dataScadenza.isBefore(limiteSconto)) {
            totale *= 0.8; // sconto 20 percento
        }

        return totale;
    }
}
