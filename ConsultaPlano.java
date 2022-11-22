public class ConsultaPlano extends Consulta{
    private String nome;
    private int numPlano;

    public ConsultaPlano(int horaConsulta, Usuario paciente, Clinica clinica, Especialidade especialidade, String nome, int numPlano) {
        super(horaConsulta, paciente, clinica, especialidade);
        this.nome = nome;
        this.numPlano = numPlano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPlano() {
        return numPlano;
    }

    public void setNumPlano(int numPlano) {
        this.numPlano = numPlano;
    }
}
