package Es2.Models;

public class Materiale {
    protected String titolo;
    protected String autore;
    protected int annoPubblicazione;

    public Materiale(String titolo, String autore, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getInformazioni() {
        return "Titolo: " + titolo + ", Autore: " + autore + ", Anno: " + annoPubblicazione;
    }

    public String presta() {
        return "Il materiale " + titolo + " è stato prestato.";
    }
}
