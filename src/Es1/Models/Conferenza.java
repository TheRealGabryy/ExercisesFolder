package Es1.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Conferenza extends Eventi{
    private String relatore;
    private double prezzoTotale;
    public Conferenza(String nomeEvento, LocalDate data, LocalTime ora, double prezzoBiglietto, LocalTime durata, String relatore) {
        super(nomeEvento, data, ora, prezzoBiglietto, durata);
        this.relatore = relatore;
    }

    @Override
    public void dettagliEvento() {
        System.out.println("Evento: " + getNomeEvento());
        System.out.println("Data: " + getData());
        System.out.println("Ora: " + getOra());
        System.out.println("prezzo Biglietto: $" + getPrezzoBiglietto());
        System.out.println("Durata evento: h" + getDurata());
        System.out.println("Relatore: " + getRelatore());
    }

    public void calcolaPrezzoTotale(int partecipanti, boolean isGruppoStudenti) {
        if (isGruppoStudenti) {
            prezzoTotale = getPrezzoBiglietto() * partecipanti * 0.85;
        } else {
            prezzoTotale = getPrezzoBiglietto() * partecipanti;
        }
    }

    public String getRelatore() {
        return relatore;
    }

    public void setRelatore(String relatore) {
        this.relatore = relatore;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }
}
