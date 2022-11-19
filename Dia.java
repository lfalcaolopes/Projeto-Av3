import java.util.ArrayList;


public class Dia {
    private ArrayList<Consulta> consultasMarcadas = new ArrayList<Consulta>();
    private int[] horarios = {0,0,0,0,1,1,0,0,0,0};

    public void marcarConsulta(int hora){
        this.horarios[hora-8] = 1;
    }

    public ArrayList<Consulta> getConsultasMarcadas() {
        return consultasMarcadas;
    }

    public void setConsultasMarcadas(ArrayList<Consulta> consultasMarcadas) {
        this.consultasMarcadas = consultasMarcadas;
    }

    public int[] getHorarios() {
        return horarios;
    }

    public void setHorarios(int[] horarios) {
        this.horarios = horarios;
    }
}