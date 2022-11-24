import java.util.*;

public class Principal {
    public static void main(String[] args){
        ArrayList<Especialidade> especialidades = setUpEspecialidades();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean estaRodando = true;

        while(estaRodando){
            System.out.println("1. Paciente \t 2. Clinica \t 0. Sair");

            int usuarioTipo = sc.nextInt();
            System.out.println();

            if (usuarioTipo == 1){
                System.out.println("1. Primeiro acesso \t 2. Login");
                int login = sc.nextInt();

                if (login == 1){
                    usuarios.add(cadastrarUsuario());

                }
                else if (login == 2){
                    Usuario usuarioAtual = verificarUsuario(usuarios);

                    if(usuarioAtual != null){
                        boolean estaLogado = true;

                        while(estaLogado){
                            System.out.println("1. Marcar Consulta \t 2. Visualizar consultas \t 3. Cancelar consulta \t 0. Logout");
                            int opcoesUsuario = sc.nextInt();
                            System.out.println();

                            if (opcoesUsuario == 1){
                                Especialidade especialidadeEscolhida = selecionarEspecialidade(especialidades);

                                Clinica clinicaEscolhida = especialidadeEscolhida.selecionarClinica();

                                Dia diaEscolhido = clinicaEscolhida.selecionarDia();

                                diaEscolhido.selecionarHorario(usuarioAtual, clinicaEscolhida, especialidadeEscolhida);
                            }
                            else if (opcoesUsuario == 2){
                                usuarioAtual.consultasMarcadas(especialidades);


                            }
                            else if (opcoesUsuario == 0){
                                estaLogado = false;
                            }
                        }
                    }
                    else{
                        System.out.println();
                        System.out.println("Usuário não encontrado. Tente novamente");
                        System.out.println();
                    }
                }
            }
            else if (usuarioTipo == 2){
                Map<String, ArrayList<Consulta>> todasConsultas = consultasClinicas(especialidades);

                System.out.println("------------------------------------------------------------------------------------");
                System.out.printf("%-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente","Clinica","Especialidade","Tipo");
                for (ArrayList<Consulta> consultas : todasConsultas.values()) {
                    System.out.println();
                    for (Consulta consulta : consultas) {
                        consulta.informacoes();
                    }
                }
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println();
            }
            else if (usuarioTipo == 0){
                estaRodando = false;
            }
        }
        System.out.println();
        System.out.println("Volte sempre");
    }

    public static Usuario cadastrarUsuario(){
        Scanner sc = new Scanner(System.in);

        System.out.println();
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

        System.out.println();
        System.out.println("Usuário cadastrado com sucesso. Faça o login");
        System.out.println();

        return new Usuario(nome, cpf, nasc, sexo, fone);
    }
    public static Usuario verificarUsuario(ArrayList<Usuario> usuarios){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Digitar CPF para logar");
        String cpf = sc.nextLine();

        for (Usuario usuario : usuarios){
            if (cpf.equals(usuario.getCpf())){
                System.out.println();
                System.out.println("Bem vindo " + usuario.getNome());
                System.out.println();
                return usuario;
            }
        }

        return null;
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
    public static Map<String ,ArrayList<Consulta>> consultasClinicas(ArrayList<Especialidade> especialidades){
        Map<String ,ArrayList<Consulta>> todasConsultas = new HashMap<>();

        ArrayList<Consulta> consultas = new ArrayList<>();

        boolean temConsulta = false;

        for (Especialidade especialidade : especialidades){
            for (Clinica clinica : especialidade.getClinicas()){
                consultas = new ArrayList<>();

                for (Dia dia : clinica.getAgenda()){
                    if (dia.getConsultasMarcadas().size() > 0){
                        consultas.addAll(dia.getConsultasMarcadas());
                        temConsulta = true;
                    }
                }
                if(temConsulta){
                    if (todasConsultas.containsKey(clinica.getNome())){
                        todasConsultas.get(clinica.getNome()).addAll(consultas);
                    }
                    else{
                        todasConsultas.put(clinica.getNome(), consultas);
                    }
                    temConsulta = false;
                }
            }
        }

        return todasConsultas;
    }
    public static ArrayList<Especialidade> setUpEspecialidades(){
        Clinica santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        Clinica santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti");
        Clinica santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade dermatologia = new Especialidade("Dermatologia", santaVitoria, santoAntonio, santaBarbara);

        santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti");

        Especialidade pediatria = new Especialidade("Pediatria", santaVitoria, santoAntonio);

        santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");

        Especialidade oftalmologia = new Especialidade("Oftalmologia", santaVitoria);

        santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti");
        santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade cardiologia = new Especialidade("Cardiologia", santaVitoria, santoAntonio, santaBarbara);

        santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade endocrinologia = new Especialidade("Endocrinologia", santaVitoria, santaBarbara);

        santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade geriatria = new Especialidade("Geriatria", santaVitoria, santoAntonio, santaBarbara);

        santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade infectologia = new Especialidade("Infectologia", santaVitoria, santaBarbara);

        return new ArrayList<>(Arrays.asList(dermatologia, pediatria, oftalmologia, cardiologia, endocrinologia, geriatria, infectologia));
    }
}