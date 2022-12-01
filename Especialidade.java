import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Especialidade {
    private String nome;
    private ArrayList<Clinica> clinicas = new ArrayList<Clinica>();


    public Especialidade(String nome, Clinica... clinicas) {
        this.nome = nome;
        addClinicas(clinicas);
    }

    public Clinica selecionarClinica(){
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("Qual clínica deseja marcar consulta?");

        // Imprime clinicas disponiveis
        for (int i = 0; i < this.clinicas.size(); i++){
            System.out.print((i + 1) + ". " + this.clinicas.get(i).getNome() + "   ");
        }
        System.out.println();

        // Retorna clinica escolhida
        return this.clinicas.get(sc.nextInt() - 1);
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
