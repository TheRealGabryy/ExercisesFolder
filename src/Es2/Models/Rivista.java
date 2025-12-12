package Es2.Models;

import java.time.LocalDate;

public class Rivista extends Materiale {
    private final int numeroRivista;

    public Rivista(String titolo, String autore, LocalDate annoPubblicazione, int numeroRivista) {
        super(titolo, autore, annoPubblicazione);
        this.numeroRivista = numeroRivista;
    }

    @Override
    public String getInformazioni() {
        return super.getInformazioni() + ", Numero rivista: " + numeroRivista;
    }
}
