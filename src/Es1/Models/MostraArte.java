package Es1.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class MostraArte extends Eventi{
    private String pittore;
    private double prezzoTotale;
    public MostraArte(String nomeEvento, LocalDate data, LocalTime ora, double prezzoBiglietto, LocalTime durata, String pittore) {
        super(nomeEvento, data, ora, prezzoBiglietto, durata);
        this.pittore = pittore;
    }

    public void calcolaPrezzoTotale(int partecipanti) {
        if (partecipanti > 3) {
            prezzoTotale = getPrezzoBiglietto() * partecipanti * 0.85; //sconto del 15 per cento
        } else {
            prezzoTotale = getPrezzoBiglietto() * partecipanti;
        }
    }

    public String getPittore() {
        return pittore;
    }

    public void setPittore(String pittore) {
        this.pittore = pittore;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }
}
