import java.util.*;

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

    public Dia selecionarDia(){
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("Qual o melhor dia para a consulta?");

        // Imprime todos os dias disponiveis
        for (int i = 0; i < this.agenda.size(); i++){
            System.out.print((i + 1) + ". " + this.agenda.get(i).getNome() + "   ");
        }
        System.out.println();

        // Retorna o dia escolhido
        return this.agenda.get(sc.nextInt() - 1);
    }
    public void setAgenda() { // Cria os dias da semana com os horarios livres para atendimento
        Dia segunda = new Dia("Segunda");
        Dia terca = new Dia("Terça");
        Dia quarta = new Dia("Quarta");
        Dia quinta = new Dia("Quinta");
        Dia sexta = new Dia("Sexta");

        this.agenda.addAll(Arrays.asList(segunda, terca, quarta, quinta, sexta));
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


}
