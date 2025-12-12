package Es2.Models;

public class Libro extends Materiale {
    private int numeroPagine;

    public Libro(String titolo, String autore, int annoPubblicazione, int numeroPagine) {
        super(titolo, autore, annoPubblicazione);
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String getInformazioni() {
        return super.getInformazioni() + ", Pagine: " + numeroPagine;
    }
}
