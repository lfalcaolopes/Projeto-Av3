import java.util.ArrayList;
import java.util.Scanner;


public class Dia {
    private ArrayList<Consulta> consultasMarcadas = new ArrayList<Consulta>();
    private int[] horarios = {0,0,0,0,1,1,0,0,0,0};
    private String nome;

    public Dia(String nome) {
        this.nome = nome;
    }

    public void selecionarHorario(Usuario paciente, Clinica clinica, Especialidade especialidade){
        Scanner sc = new Scanner(System.in);
        int[] horarios = this.getHorarios();

        System.out.println();

        System.out.println("Qual o melhor horário para a consulta?");

        for (int i = 0; i < horarios.length; i++){
            if (horarios[i] == 0){
                System.out.print((i + 8) + "h   ");
            }
        }
        System.out.println();
        int hora = sc.nextInt();
        System.out.println();

        System.out.println("1. Particular \t 2. Plano de Saúde");
        int tipo = sc.nextInt();
        sc.nextLine();
        System.out.println();

        Consulta consulta = null;

        if (tipo == 1){
            consulta = new ConsultaParticular(hora, paciente, clinica, especialidade, 120);
        }
        else if (tipo == 2){
            System.out.print("Nome do plano: ");
            String nomePlano = sc.nextLine();
            System.out.print("Numero do plano: ");
            int numPlano = sc.nextInt();
            System.out.println();

            consulta = new ConsultaPlano(hora, paciente, clinica, especialidade, nomePlano, numPlano);
        }

        this.marcarConsulta(hora, consulta);
        System.out.println("Consulta marcada com sucesso");
        System.out.println();
    }

    public void marcarConsulta(int hora, Consulta consulta){
        this.horarios[hora-8] = 1;
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