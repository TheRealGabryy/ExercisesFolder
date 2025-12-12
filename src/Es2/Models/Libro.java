package Es2.Models;

import java.time.LocalDate;

public class Libro extends Materiale {
    private int numeroPagine;

    public Libro(String titolo, String autore, LocalDate annoPubblicazione, int numeroPagine) {
        super(titolo, autore, annoPubblicazione);
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String getInformazioni() {
        return super.getInformazioni() + ", Pagine: " + numeroPagine;
    }
}
