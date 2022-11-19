import java.util.ArrayList;
import java.util.Arrays;

public class Clinica {
    private String nome;
    private int cnpj;
    private String endereco;
    private ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();
    private Agenda agenda = new Agenda();

    public Clinica(String nome, int cnpj, String endereco, Especialidade... especialidades) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.especialidades.addAll(Arrays.asList(especialidades));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void addEspecialidade(Especialidade... especialidades) {
        this.especialidades.addAll(Arrays.asList(especialidades));
    }

    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Clinica{" +
                "nome='" + nome + '\'' +
                ", cnpj=" + cnpj +
                ", endereco='" + endereco + '\'' +
                ", especialidades=" + especialidades +
                '}';
    }
}
