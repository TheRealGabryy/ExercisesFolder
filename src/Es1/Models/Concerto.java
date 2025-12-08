package Es1.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Eventi{
    private String artista;
    private double prezzoTotale;
    public Concerto(String nomeEvento, LocalDate data, LocalTime ora, double prezzoBiglietto, LocalTime durata, String artista) {
        super(nomeEvento, data, ora, prezzoBiglietto, durata);
        this.artista = artista;
    }

    public void calcolaPrezzoTotale(int partecipanti, boolean isSerale) {
        if (isSerale) {
            prezzoTotale = getPrezzoBiglietto() * partecipanti * 0.85;
        } else {
            prezzoTotale = getPrezzoBiglietto() * partecipanti;
        }
    }

    @Override
    public void dettagliEvento() {
        System.out.println("Evento: " + getNomeEvento());
        System.out.println("Data: " + getData());
        System.out.println("Ora: " + getOra());
        System.out.println("prezzo Biglietto: $" + getPrezzoBiglietto());
        System.out.println("Durata evento: h" + getDurata());
        System.out.println("Artista: " + getArtista());
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }
}
