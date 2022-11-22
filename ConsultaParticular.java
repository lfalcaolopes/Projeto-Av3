public class ConsultaParticular  extends Consulta{
    private double valor;

    public ConsultaParticular(int horaConsulta, Usuario paciente, Clinica clinica, Especialidade especialidade, double valor) {
        super(horaConsulta, paciente, clinica, especialidade);
        this.valor = valor;
    }
}
