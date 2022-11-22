public abstract class Consulta {
    private int horaConsulta;
    private Usuario paciente;
    private Clinica clinica;
    private Especialidade especialidade;


    public Consulta(int horaConsulta, Usuario paciente, Clinica clinica, Especialidade especialidade) {
        this.horaConsulta = horaConsulta;
        this.paciente = paciente;
        this.clinica = clinica;
        this.especialidade = especialidade;
    }


    public int getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(int horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
}
