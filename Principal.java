import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        ArrayList<Especialidade> especialidades = setUpEspecialidades();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean estaRodando = true;

        while(estaRodando){
            System.out.println("1. Paciente \t 2. Clinica \t 0. Sair");
            int usuarioTipo = sc.nextInt();

            if (usuarioTipo == 1){
                System.out.println("1. Primeiro acesso \t 2. Login");
                int login = sc.nextInt();

                if (login == 1){
                    usuarios.add(cadastrarUsuario());
                }
                else if (login == 2){
                    boolean estaCadastrado = verificarUsuario(usuarios);

                    if(estaCadastrado){
                        Especialidade especialidadeEscolhida = selecionarEspecialidade(especialidades);

                        Clinica clinicaEscolhida = selecionarClinica(especialidadeEscolhida.getClinicas());

                        Dia diaEscolhido = selecionarDia(clinicaEscolhida.getAgenda());

                        selecionarHorario(diaEscolhido, usuarios.get(0), clinicaEscolhida, especialidadeEscolhida);
                    }
                    else{
                        System.out.println("Usuário não encontrado");
                    }
                }
            }
            else if (usuarioTipo == 0){
                estaRodando = false;
            }
        }
    }

    public static boolean verificarUsuario(ArrayList<Usuario> usuarios){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digitar Cpf");
        String cpf = sc.nextLine();

        for (Usuario usuario : usuarios){
            if (cpf.equals(usuario.getCpf())){
                return true;
            }
        }

        return false;
    }
    public static Usuario cadastrarUsuario(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Data de nascimento: ");
        String nasc = sc.nextLine();
        System.out.print("Sexo: ");
        String sexo = sc.nextLine();
        System.out.print("Telefone: ");
        String fone = sc.nextLine();

        return new Usuario(nome, cpf, nasc, sexo, fone);
    }
    public static void selecionarHorario(Dia diaEscolhido, Usuario paciente, Clinica clinica, Especialidade especialidade){
        Scanner sc = new Scanner(System.in);
        int[] horarios = diaEscolhido.getHorarios();

        System.out.println("Qual o melhor horário para a consulta?");

        for (int i = 0; i < horarios.length; i++){
            if (horarios[i] == 0){
                System.out.print((i + 8) + "h   ");
            }
        }
        System.out.println();

        int hora = sc.nextInt();

        System.out.println("1. Particular \t 2. Plano de Saúde");
        int tipo = sc.nextInt();

        Consulta consulta = null;

        if (tipo == 1){
            consulta = new ConsultaParticular(hora, paciente, clinica, especialidade, 120);
        }
        else if (tipo == 2){
            consulta = new ConsultaPlano(hora, paciente, clinica, especialidade, "Amil", 123);
        }

        diaEscolhido.marcarConsulta(hora, consulta);
        System.out.println("Consulta marcada com sucesso");
    }
    public static Dia selecionarDia(ArrayList<Dia> agenda){
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o melhor dia para a consulta?");

        for (int i = 0; i < agenda.size(); i++){
            System.out.print((i + 1) + ". " + agenda.get(i).getNome() + "   ");
        }
        System.out.println();

        return agenda.get(sc.nextInt() - 1);
    }
    public static Clinica selecionarClinica(ArrayList<Clinica> clinicas){
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual clínica deseja marcar consulta?");

        for (int i = 0; i < clinicas.size(); i++){
            System.out.print((i + 1) + ". " + clinicas.get(i).getNome() + "   ");
        }
        System.out.println();

        return clinicas.get(sc.nextInt() - 1);
    }
    public static Especialidade selecionarEspecialidade(ArrayList<Especialidade> especialidades){
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual especialidade está procurando?");

        for (int i = 0; i < especialidades.size(); i++){
            System.out.print((i + 1) + ". " + especialidades.get(i).getNome() + "   ");
        }
        System.out.println();

        return especialidades.get(sc.nextInt() - 1);
    }
    public static ArrayList<Especialidade> setUpEspecialidades(){
        Clinica santaMarta = new Clinica("Santa Marta", 1111111, "Av. josé campos");
        Clinica santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti");
        Clinica santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade dermatologia = new Especialidade("Dermatologia", santaMarta, santoAntonio, santaBarbara);

        santaMarta = new Clinica("Santa Marta", 1111111, "Av. josé campos");
        santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti");

        Especialidade pediatria = new Especialidade("Pediatria", santaMarta, santoAntonio);

        santaMarta = new Clinica("Santa Marta", 1111111, "Av. josé campos");

        Especialidade oftalmologia = new Especialidade("Oftalmologia", santaMarta);

        santaMarta = new Clinica("Santa Marta", 1111111, "Av. josé campos");
        santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti");
        santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade cardiologia = new Especialidade("Cardiologia", santaMarta, santoAntonio, santaBarbara);

        santaMarta = new Clinica("Santa Marta", 1111111, "Av. josé campos");
        santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade endocrinologia = new Especialidade("Endocrinologia", santaMarta, santaBarbara);

        return new ArrayList<>(Arrays.asList(dermatologia, pediatria, oftalmologia, cardiologia, endocrinologia));
    }
}
