import java.util.*;

public class Usuario {
    private String nome;
    private String cpf;
    private String endereco;
    private String sexo;
    private String telefone;

    public Usuario(String nome, String cpf, String endereco, String sexo, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public void consultasMarcadas(ArrayList<Especialidade> especialidades){

        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente","Clinica","Especialidade","Tipo");
        System.out.println();

        boolean temConsulta = false;

        // Imprimir informações de todas as consultas
        for (Especialidade especialidade : especialidades) {
            for (Clinica clinica : especialidade.getClinicas()) {
                for (Dia dia : clinica.getAgenda()) {
                    for (Consulta consulta : dia.getConsultasMarcadas()) {
                        if (consulta.getPaciente().getNome().equals(this.nome)) {
                            consulta.informacoes();
                            temConsulta = true;
                        }
                    }
                }
            }
            if (temConsulta){
                temConsulta = false;
                System.out.println();
            }
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void desmarcarConsulta(ArrayList<Especialidade> especialidades){
        Map<Consulta, ArrayList<Consulta>> consultaMap = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);

        int contador = 0;

        System.out.println("Digite o numero da consulta que deseja cancelar");
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("   %-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente","Clinica","Especialidade","Tipo");
        System.out.println();

        boolean temConsulta = false;

        // Imprimir informações de todas as consultas
        for (Especialidade especialidade : especialidades){
            for (Clinica clinica : especialidade.getClinicas()){
                for (Dia dia : clinica.getAgenda()){
                    for (Consulta consulta : dia.getConsultasMarcadas()){
                        if (consulta.getPaciente().getNome().equals(this.nome)){
                            System.out.print(++contador + ". ");
                            consulta.informacoes();
                            temConsulta = true;

                            consultaMap.put(consulta, dia.getConsultasMarcadas());
                        }
                    }
                }
            }
            if (temConsulta){
                temConsulta = false;
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("Consulta: ");
        int consultaNum = sc.nextInt() - 1; // Pega input de qual consulta deve ser exluida

        contador = 0;

        System.out.println();
        System.out.println("Tem certeza que deseja desmarcar?");
        System.out.println("1. Sim \t 2. Não");
        int confirmacao = sc.nextInt();
        System.out.println();

        if(confirmacao == 1){ // Desmarcação confirmada
            for (var entry : consultaMap.entrySet()) {
                if (contador == consultaNum){
                    entry.getValue().remove(entry.getKey());// Remove a consulta, da arrayList de consultas
                }
                contador++;
            }

            System.out.println("\t\tConsulta desmarcada com Sucesso");
            System.out.println();
        }
        else if (confirmacao == 2){ // Desmarcação cancelada
            System.out.println("\t\tDesmarcação cancelada");
            System.out.println();
        }
    }

    public void pesquisarConsulta(ArrayList<Especialidade> especialidades) {
        Scanner sc = new Scanner(System.in);


        System.out.println("1. Consulta Particular \t 2. Consulta pelo plano");
        int consultaTipo = sc.nextInt();
        System.out.println();

        boolean temConsulta = false;


        if (consultaTipo == 1) { // Imprime consultas particulares
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.printf("   %-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente", "Clinica", "Especialidade", "Tipo");
            System.out.println();

            // Imprimir informações de todas as consultas
            for (Especialidade especialidade : especialidades) {
                for (Clinica clinica : especialidade.getClinicas()) {
                    for (Dia dia : clinica.getAgenda()) {
                        for (Consulta consulta : dia.getConsultasMarcadas()) {
                            if (consulta.getPaciente().getNome().equals(this.nome) && consulta instanceof ConsultaParticular) {
                                consulta.informacoes();
                                temConsulta = true;
                            }
                        }
                    }
                }
                if (temConsulta){
                    temConsulta = false;
                    System.out.println();
                }
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println();

        }
        else if (consultaTipo == 2) { // Imprime Consultas pelo plano
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.printf("   %-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente", "Clinica", "Especialidade", "Tipo");
            System.out.println();

            // Imprimir informações de todas as consultas
            for (Especialidade especialidade : especialidades) {
                for (Clinica clinica : especialidade.getClinicas()) {
                    for (Dia dia : clinica.getAgenda()) {
                        for (Consulta consulta : dia.getConsultasMarcadas()) {
                            if (consulta.getPaciente().getNome().equals(this.nome) && consulta instanceof ConsultaPlano) {
                                consulta.informacoes();
                                temConsulta = true;
                            }
                        }
                    }
                }
                if (temConsulta){
                    temConsulta = false;
                    System.out.println();
                }
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    public void atualizarCadastro(){
        Scanner sc = new Scanner(System.in);

        boolean estaAtualizando = true;

        while(estaAtualizando){
            this.toString(); // Imprime todos os dados do usuário

            System.out.println();
            System.out.print("Digite o numero do item que deseja atualizar: ");
            int itemInt = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if (itemInt == 1){ // Atualiza o nome
                System.out.print("Digite o novo nome: ");
                this.nome = sc.nextLine();
            }
            else if (itemInt == 2){ // Atualiza o cpf
                System.out.print("Digite o novo CPF: ");
                this.cpf = sc.nextLine();
            }
            else if (itemInt == 3){ // Atualiza o endereço
                System.out.print("Digite o novo endereço: ");
                this.endereco = sc.nextLine();
            }
            else if (itemInt == 4){ // Atualiza o sexo
                System.out.print("Digite o novo sexo: ");
                this.sexo = sc.nextLine();
            }
            else if (itemInt == 5){ // Atualiza o telefone
                System.out.print("Digite o novo telefone: ");
                this.telefone = sc.nextLine();
            }

            System.out.println();
            System.out.println("1. Alterar outro item \t 2. Salvar alterações");
            int continuar = sc.nextInt();
            System.out.println();

            if (continuar == 1) // Continua no loop para alterar outro dado
                continue;
            else if (continuar == 2) { // Sai do loop
                System.out.println("\t\tCadastro atualizado com sucesso");
                break;
            }
        }
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    @Override
    public String toString() {
        System.out.println("1. Nome: " + nome);
        System.out.println("2. CPF: " + cpf);
        System.out.println("3. Endereco: " + endereco);
        System.out.println("4. Sexo: " + sexo);
        System.out.println("5. Telefone: " + telefone);
        return null;
    }
}
