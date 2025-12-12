package Es4.Models;

public class Prodotto {

    protected String nome;
    protected double prezzo;
    public int quantitaDisponibile;

    public Prodotto(String nome, double prezzo, int quantitaDisponibile) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public double calcolaPrezzoTotale(int quantita) {
        return prezzo * quantita;
    }

    public String getInfo() {
        return nome + " Prezzo: " + prezzo + " Quantità disp: " + quantitaDisponibile;
    }
}
