package it.unibs.fdp.magazzino;

public class Orario {

    private int secondi;
    private int minuti;
    private int ore;

    public Orario(int ore, int minuti, int secondi) {
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    public int getSecondi() {
        return secondi;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getOre() {
        return ore;
    }

    @Override
    public String toString() {
        return ore + " ore " + minuti + " minuti " + secondi + " secondi";
    }

    public static Orario calcolaOrarioProduzione(Orario tempoProduzioneUnitario, int qDaProdurre) {

        int ore = tempoProduzioneUnitario.getOre() * qDaProdurre;
        int minuti = tempoProduzioneUnitario.getMinuti() * qDaProdurre;
        int secondi = tempoProduzioneUnitario.getSecondi() * qDaProdurre;

        while(secondi >= 60) {
            secondi = secondi - 60;
            minuti++;
        }

        while(minuti >= 60) {
            minuti = minuti - 60;
            ore++;
        }

        return new Orario(ore, minuti, secondi);
    }
}
