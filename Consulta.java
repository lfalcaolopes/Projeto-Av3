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

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public abstract void informacoes();
}
