package Es3.Models;

public class Manager extends Risorsa {

    private double bonus;

    public Manager(String nome, String cognome, double retribuzioneBase, double bonus) {
        super(nome, cognome, retribuzioneBase);
        this.bonus = bonus;
    }

    @Override
    public double calcolaRetribuzione() {
        return retribuzioneBase + bonus;
    }
}
