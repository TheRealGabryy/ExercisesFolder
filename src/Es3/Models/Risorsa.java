package Es3.Models;

public class Risorsa {
    protected String nome;
    protected String cognome;
    protected double retribuzioneBase;

    public Risorsa(String nome, String cognome, double retribuzioneBase) {
        this.nome = nome;
        this.cognome = cognome;
        this.retribuzioneBase = retribuzioneBase;
    }

    public double calcolaRetribuzione() {
        return retribuzioneBase;
    }

    public String getInfo() {
        return nome + " " + cognome + " Retribuzione: " + calcolaRetribuzione();
    }
}
