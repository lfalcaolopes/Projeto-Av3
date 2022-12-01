import java.util.*;

// todo: filtrar consultas pelo tipo

public class Principal {
    public static void main(String[] args){
        ArrayList<Especialidade> especialidades = setUpEspecialidades(); // Configurar especialidades quais clinicas atendem
        ArrayList<Usuario> usuarios = new ArrayList<>(); // Registro de todos os usuarios
        setUpConsultas(especialidades, usuarios); // Configura as consultas predefinidas aleatoriamente
        Scanner sc = new Scanner(System.in);

        boolean estaRodando = true;

        while(estaRodando){
            System.out.println("1. Paciente \t 2. Clinica \t 0. Sair");

            int usuarioTipo = sc.nextInt();
            System.out.println();

            if (usuarioTipo == 1){ // Rota do paciente
                System.out.println("1. Primeiro acesso \t 2. Login");
                int login = sc.nextInt();

                if (login == 1){ // Cadastrar usuário
                    usuarios.add(cadastrarUsuario()); // Adicionar usuário no registro

                }
                else if (login == 2){ // Login
                    Usuario usuarioAtual = verificarUsuario(usuarios); // Confere se usuário está cadastrado pelo cpf

                    if(usuarioAtual != null){
                        boolean estaLogado = true;

                        while(estaLogado){ // Loop para se manter logado
                            System.out.println("1. Marcar Consulta \t 2. Visualizar consultas \t 3. Cancelar consulta \t 0. Logout");
                            int opcoesUsuario = sc.nextInt();
                            System.out.println();
                            System.out.println();

                            if (opcoesUsuario == 1){ // Marcar consulta
                                Especialidade especialidadeEscolhida = selecionarEspecialidade(especialidades); // Salva especialidade desejada

                                Clinica clinicaEscolhida = especialidadeEscolhida.selecionarClinica(); // Salva clinica desejada

                                Dia diaEscolhido = clinicaEscolhida.selecionarDia(); // Salva dia desejado

                                selecionarHorario(diaEscolhido, usuarioAtual, clinicaEscolhida, especialidadeEscolhida); // Marca consulta no horario selecionado
                            }
                            else if (opcoesUsuario == 2) // Visualizar consultas
                                usuarioAtual.consultasMarcadas(especialidades);

                            else if (opcoesUsuario == 3) // Cancelar consulta
                                usuarioAtual.desmarcarConsulta(especialidades);

                            else if (opcoesUsuario == 0) // Logout
                                estaLogado = false;

                        }
                    }
                    else{
                        System.out.println();
                        System.out.println("Usuário não encontrado. Tente novamente");
                        System.out.println();
                    }
                }
            }
            else if (usuarioTipo == 2){ // Mostrar consultas de todas as clinicas
                Map<String, ArrayList<Consulta>> todasConsultas = consultasClinicas(especialidades); // Dicionario com nome da clinica e suas consultas do dia

                System.out.println("---------------------------------------------------------------------------------------");
                System.out.printf("   %-10s%-10s%-15s%-17s%-20s%-20s%n", "Dia", "Horario", "Paciente","Clinica","Especialidade","Tipo");
                for (ArrayList<Consulta> consultas : todasConsultas.values()) { // Loop para acessar consultas do dia
                    System.out.println();
                    for (Consulta consulta : consultas) { // Loop para acessar cada consulta
                        consulta.informacoes(); // Print informações da consulta
                    }
                }
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println();
            }
            else if (usuarioTipo == 0){ // Sair do programa
                estaRodando = false;
            }
        }
        System.out.println();
        System.out.println("Volte sempre");
    }

    public static Usuario cadastrarUsuario(){
        Scanner sc = new Scanner(System.in);

        // Pegar dados do usuário
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
        System.out.println("\t\tUsuário cadastrado com sucesso. Faça o login");
        System.out.println();

        return new Usuario(nome, cpf, nasc, sexo, fone); // Instanciar um usuário com as informações
    }
    public static Usuario verificarUsuario(ArrayList<Usuario> usuarios){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Digitar CPF para logar");
        String cpf = sc.nextLine();

        for (Usuario usuario : usuarios){
            if (cpf.equals(usuario.getCpf())){ // Confere se o Cpf informado no login é igual a algum cpf cadastrado
                System.out.println();
                System.out.println("\t\tBem vindo " + usuario.getNome());
                System.out.println();
                return usuario; // Retorna o usuário que possui o mesmo cpf que o informado
            }
        }

        return null;
    }
    public static Especialidade selecionarEspecialidade(ArrayList<Especialidade> especialidades){
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual especialidade está procurando?");

        // Imprime todas as especialidades disponiveis
        for (int i = 0; i < especialidades.size(); i++){
            System.out.print((i + 1) + ". " + especialidades.get(i).getNome() + "   ");
        }
        System.out.println();

        // Retorna a especialidade escolhida
        return especialidades.get(sc.nextInt() - 1);
    }
    public static void selecionarHorario(Dia dia, Usuario paciente, Clinica clinica, Especialidade especialidade){
        Scanner sc = new Scanner(System.in);
        int[] horarios = dia.getHorarios();

        System.out.println();

        System.out.println("Qual o melhor horário para a consulta?");

        // Imprime todos os horarios disponiveis
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

        if (tipo == 1){ // Cadastrar consulta particular
            consulta = new ConsultaParticular(dia, hora, paciente, clinica, especialidade, 120);
        }
        else if (tipo == 2){ // Cadastrar consulta pelo plano
            System.out.print("Nome do plano: ");
            String nomePlano = sc.nextLine();
            System.out.print("Numero do plano: ");
            int numPlano = sc.nextInt();
            System.out.println();

            consulta = new ConsultaPlano(dia, hora, paciente, clinica, especialidade, nomePlano, numPlano);
        }

        dia.marcarConsulta(hora, consulta); // Agendar a consulta cadastrada
        System.out.println("\t\tConsulta marcada com sucesso");
        System.out.println();
    }
    public static Map<String ,ArrayList<Consulta>> consultasClinicas(ArrayList<Especialidade> especialidades){
        Map<String ,ArrayList<Consulta>> todasConsultas = new HashMap<>();

        boolean temConsulta = false;

        for (Especialidade especialidade : especialidades){
            for (Clinica clinica : especialidade.getClinicas()){
                ArrayList<Consulta> consultas = new ArrayList<>();

                // Juntar todas as consultas da clinica na mesma arraylist
                for (Dia dia : clinica.getAgenda()){
                    if (dia.getConsultasMarcadas().size() > 0){
                        consultas.addAll(dia.getConsultasMarcadas()); // Adiciona as consultas do dia
                        temConsulta = true;
                    }
                }
                if(temConsulta){
                    if (todasConsultas.containsKey(clinica.getNome())){ // Se a clinica já foi adicionada no hashmap
                        todasConsultas.get(clinica.getNome()).addAll(consultas); // Adiciona as consultas com as outras ja cadastradas
                    }
                    else{
                        todasConsultas.put(clinica.getNome(), consultas); // Adiciona a clinica e as consultas
                    }
                    temConsulta = false;
                }
            }
        }

        return todasConsultas; // Retorna as clinicas e suas consultas
    }
    public static ArrayList<Especialidade> setUpEspecialidades(){
        // Cadastrar clinica
        Clinica santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        Clinica santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti");
        Clinica santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        // Cadastrar especialidades e quais clinicas atendem
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

        Especialidade geriatria = new Especialidade("Geriatria", santaVitoria, santaBarbara);

        santaVitoria = new Clinica("Santa Vitoria", 1111111, "Av. josé campos");
        santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo");

        Especialidade infectologia = new Especialidade("Infectologia", santaVitoria, santaBarbara);

        return new ArrayList<>(Arrays.asList(dermatologia, pediatria, oftalmologia, cardiologia, endocrinologia, geriatria, infectologia));
    }
    public static void setUpConsultas(ArrayList<Especialidade> especialidades, ArrayList<Usuario> usuarios){
        Random random = new Random();

        // Adicionar usuarios falsos para simular as consultas
        usuarios.add(new Usuario("Alex Costa", "1111", "123", "m", "123"));
        usuarios.add(new Usuario("Vicente", "2222", "123", "m", "123"));
        usuarios.add(new Usuario("Raire", "3333", "123", "m", "123"));

        for (int i = 0; i < 7; i++){
            // Escolhe um usuario aleatorio
            int index = random.nextInt(usuarios.size());
            Usuario paciente = usuarios.get(index);

            // Escolhe uma especialidade aleatoria
            index = random.nextInt(especialidades.size());
            Especialidade especialidade = especialidades.get(index);

            // Escolhe uma clinica aleatoria
            index = random.nextInt(especialidade.getClinicas().size());
            Clinica clinica = especialidade.getClinicas().get(index);

            // Escolhe um dia aleatorio
            index = random.nextInt(clinica.getAgenda().size());
            Dia dia = clinica.getAgenda().get(index);

            // Escolhe uma hora aleatoria
            int hora;
            index = random.nextInt(dia.getHorarios().length);
            if (index == 4 || index == 5){
                hora = index + 10;
            }
            else{
                hora = index + 8;
            }

            Consulta consulta;

            // Escolhe um tipo de consulta aleatoria
            if(random.nextInt(2) == 1){
                consulta = new ConsultaParticular(dia, hora, paciente, clinica, especialidade, 120);
            }
            else{
                consulta = new ConsultaPlano(dia, hora, paciente, clinica, especialidade, "amil", 123);
            }

            // Marca consulta
            dia.marcarConsulta(hora, consulta);
        }
    }
}