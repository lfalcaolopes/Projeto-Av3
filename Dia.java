import java.util.ArrayList;

public class Dia {
    private ArrayList<Consulta> consultasMarcadas = new ArrayList<Consulta>();
    private int[] horarios = {0,0,0,0,1,1,0,0,0,0};
    private String nome;

    public Dia(String nome) {
        this.nome = nome;
    }


    public void marcarConsulta(int hora, Consulta consulta){
        this.horarios[hora-8] = 1; // Troca o item da array de 0 (Livre) para 1 (Ocupado)
        this.consultasMarcadas.add(consulta);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}