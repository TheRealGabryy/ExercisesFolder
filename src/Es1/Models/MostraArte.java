package Es1.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class MostraArte extends Eventi{
    private String pittore;
    public MostraArte(String nomeEvento, LocalDate data, LocalTime ora, double prezzoBiglietto, LocalTime durata, String pittore) {
        super(nomeEvento, data, ora, prezzoBiglietto, durata);
        this.pittore = pittore;
    }

    public double calcolaPrezzoTotale(int partecipanti, int persone) {
        if (persone > 3) {
            return (getPrezzoBiglietto() * partecipanti) * 0.85; //sconto del 15 per cento
        } else {
            return getPrezzoBiglietto() * partecipanti;
        }
    }

    public String getPittore() {
        return pittore;
    }

    public void setPittore(String pittore) {
        this.pittore = pittore;
    }
}
