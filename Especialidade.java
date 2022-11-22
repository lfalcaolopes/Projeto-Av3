import java.util.ArrayList;
import java.util.Arrays;

public class Especialidade {
    private String nome;
    private ArrayList<Clinica> clinicas = new ArrayList<Clinica>();


    public Especialidade(String nome, Clinica... clinicas) {
        this.nome = nome;
        addClinicas(clinicas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Clinica> getClinicas() {
        return clinicas;
    }

    public void addClinicas(Clinica... clinicas) {
        this.clinicas.addAll(Arrays.asList(clinicas));
    }
}
