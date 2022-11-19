import java.util.ArrayList;
import java.util.Arrays;

public class Agenda {
    private ArrayList<Dia> semana = new ArrayList<Dia>();

    public Agenda() {
        setSemana();
    }

    public ArrayList<Dia> getSemana() {
        return semana;
    }

    public void setSemana() {
        Dia segunda = new Dia();
        Dia terca = new Dia();
        Dia quarta = new Dia();
        Dia quinta = new Dia();
        Dia sexta = new Dia();

        this.semana.addAll(Arrays.asList(segunda, terca, quarta, quinta, sexta));
    }
}

