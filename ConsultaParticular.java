public class ConsultaParticular  extends Consulta{
    private double valor;

    public ConsultaParticular(String dataConsulta, int horaConsulta, boolean status, double valor) {
        super(dataConsulta, horaConsulta, status);
        this.valor = valor;
    }
}
