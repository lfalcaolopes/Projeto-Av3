public class ConsultaPlano extends Consulta{
    private String nome;
    private int numPlano;

    public ConsultaPlano(String dataConsulta, int horaConsulta, boolean status, String nome, int numPlano) {
        super(dataConsulta, horaConsulta, status);
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
