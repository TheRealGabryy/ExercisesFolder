package Es4.Models;

public class ProdottoBevanda extends Prodotto {

    private int volume; // ml

    public ProdottoBevanda(String nome, double prezzo, int quantitaDisponibile, int volume) {
        super(nome, prezzo, quantitaDisponibile);
        this.volume = volume;
    }

    @Override
    public double calcolaPrezzoTotale(int quantita) {

        double totale = prezzo * quantita;

        if (volume > 1000) {
            totale *= 0.9; // sconto 10 percento
        }

        return totale;
    }
}
