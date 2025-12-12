package Es2.Models;

public class Rivista extends Materiale {
    private int numeroRivista;

    public Rivista(String titolo, String autore, int annoPubblicazione, int numeroRivista) {
        super(titolo, autore, annoPubblicazione);
        this.numeroRivista = numeroRivista;
    }

    @Override
    public String getInformazioni() {
        return super.getInformazioni() + ", Numero rivista: " + numeroRivista;
    }
}
