package Es3.Models;

public class Dipendente extends Risorsa {

    public Dipendente(String nome, String cognome, double retribuzioneBase) {
        super(nome, cognome, retribuzioneBase);
    }

    @Override
    public double calcolaRetribuzione() {
        return retribuzioneBase;
    }
}
