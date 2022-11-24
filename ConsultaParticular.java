public class ConsultaParticular  extends Consulta{
    private double valor;

    public ConsultaParticular(String dia, int horaConsulta, Usuario paciente, Clinica clinica, Especialidade especialidade, double valor) {
        super(dia, horaConsulta, paciente, clinica, especialidade);
        this.valor = valor;
    }

    @Override
    public void informacoes() {
        System.out.printf("%-10s%-10s%-15.12s%-17s%-20s%-20s%n", super.getDia(), super.getHoraConsulta() + "h", super.getPaciente().getNome(), super.getClinica().getNome(), super.getEspecialidade().getNome(), "Particular");
    }
}
