package Es1.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Eventi {
    private String nomeEvento;
    private LocalDate data;
    private LocalTime ora;
    private double prezzoBiglietto;
    private LocalTime durata;

    public Eventi(String nomeEvento, LocalDate data, LocalTime ora, double prezzoBiglietto, LocalTime durata) {
        this.nomeEvento = nomeEvento;
        this.data = data;
        this.ora = ora;
        this.prezzoBiglietto = prezzoBiglietto;
        this.durata = durata;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzoBiglietto() {
        return prezzoBiglietto;
    }

    public void setPrezzoBiglietto(double prezzoBiglietto) {
        this.prezzoBiglietto = prezzoBiglietto;
    }

    public LocalTime getDurata() {
        return durata;
    }

    public void setDurata(LocalTime durata) {
        this.durata = durata;
    }

    public void dettagliEvento() {
        System.out.println("Evento: " + nomeEvento);
        System.out.println("Data: " + data);
        System.out.println("Ora: " + ora);
        System.out.println("prezzo Biglietto: $" + prezzoBiglietto);
        System.out.println("Durata evento: h" + durata);
    }

    public double calcolaPrezzoTotale(int partecipanti) {
        return prezzoBiglietto * partecipanti;
    }
}
