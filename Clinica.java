import java.util.ArrayList;
import java.util.Arrays;

public class Clinica {
    private String nome;
    private int cnpj;
    private String endereco;
    private ArrayList<Especialidade> especialidades = new ArrayList<Especialidade>();

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
}
