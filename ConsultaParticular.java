public class ConsultaParticular  extends Consulta{
    private double valor;

    public ConsultaParticular(int horaConsulta, Usuario paciente, Clinica clinica, Especialidade especialidade, double valor) {
        super(horaConsulta, paciente, clinica, especialidade);
        this.valor = valor;
    }

    @Override
    public void informacoes() {
        System.out.printf("%-10s%-15.12s%-17s%-20s%-20s%n", super.getHoraConsulta() + "h", super.getPaciente().getNome(), super.getClinica().getNome(), super.getEspecialidade().getNome(), "Particular");
    }
}
