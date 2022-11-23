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

    @Override
    public void informacoes() {
        System.out.printf("%-10s%-15.12s%-17s%-20s%-20s%n", super.getHoraConsulta() + "h", super.getPaciente().getNome(), super.getClinica().getNome(), super.getEspecialidade().getNome(), "Plano");
    }
}
