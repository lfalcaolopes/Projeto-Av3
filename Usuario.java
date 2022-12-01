import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String cpf;
    private String dataNasc;
    private String sexo;
    private String telefone;

    public Usuario(String nome, String cpf, String dataNasc, String sexo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public void consultasMarcadas(ArrayList<Especialidade> especialidades){

        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente","Clinica","Especialidade","Tipo");
        System.out.println();

        // Imprimir informações de todas as consultas
        for (Especialidade especialidade : especialidades){
            for (Clinica clinica : especialidade.getClinicas()){
                for (Dia dia : clinica.getAgenda()){
                    for (Consulta consulta : dia.getConsultasMarcadas()){
                        if (consulta.getPaciente().getNome().equals(this.nome)){
                            consulta.informacoes();
                        }
                    }
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void desmarcarConsulta(ArrayList<Especialidade> especialidades){
        Map<Consulta, ArrayList<Consulta>> consultaMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int contador = 0;

        System.out.println("Digite o numero da consulta que deseja cancelar");
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("   %-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente","Clinica","Especialidade","Tipo");
        System.out.println();

        // Imprimir informações de todas as consultas
        for (Especialidade especialidade : especialidades){
            for (Clinica clinica : especialidade.getClinicas()){
                for (Dia dia : clinica.getAgenda()){
                    for (Consulta consulta : dia.getConsultasMarcadas()){
                        if (consulta.getPaciente().getNome().equals(this.nome)){
                            System.out.print(++contador + ". ");
                            consulta.informacoes();

                            consultaMap.put(consulta, dia.getConsultasMarcadas());
                        }
                    }
                }
            }
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("Consulta: ");
        int consultaNum = sc.nextInt() - 1; // Pega input de qual consulta deve ser exluida

        contador = 0;

        for (var entry : consultaMap.entrySet()) {
            if (contador == consultaNum){
                entry.getValue().remove(entry.getKey());// Remove a consulta, da arrayList de consultas
            }
            contador++;
        }

        System.out.println();
        System.out.println("\t\tConsulta desmarcada com Sucesso");
        System.out.println();
        System.out.println();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
