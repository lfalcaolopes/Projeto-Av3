public abstract class Consulta {
    private String dataConsulta;
    private int horaConsulta;
    private boolean status;

    public Consulta(String dataConsulta, int horaConsulta, boolean status) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.status = status;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(int horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
