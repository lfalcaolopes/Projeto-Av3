import java.util.ArrayList;
import java.util.Arrays;

public class Clinica {
    private String nome;
    private int cnpj;
    private String endereco;
    private ArrayList<Dia> agenda = new ArrayList<Dia>();

    public Clinica(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        setAgenda();
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

    public ArrayList<Dia> getAgenda() {
        return agenda;
    }

    public void setAgenda() {
        Dia segunda = new Dia();
        Dia terca = new Dia();
        Dia quarta = new Dia();
        Dia quinta = new Dia();
        Dia sexta = new Dia();

        this.agenda.addAll(Arrays.asList(segunda, terca, quarta, quinta, sexta));
    }

    @Override
    public String toString() {
        return "Clinica{" +
                "nome='" + nome + '\'' +
                ", cnpj=" + cnpj +
                ", endereco='" + endereco + '\'' +
                ", agenda=" + agenda +
                '}';
    }
}
