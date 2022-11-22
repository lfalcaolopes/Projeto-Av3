import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        ArrayList<Especialidade> especialidades = setUpEspecialidades();

        Dia dia = especialidades.get(1).getClinicas().get(1).getAgenda().get(1);

        dia.marcarConsulta(16);
        int[] horarios = dia.getHorarios();



        int h = 8;
        for(int hora : horarios){


            if (hora == 0){
                System.out.println(h + "h está disponivel");
            } else{
                System.out.println(h + "h não está disponivel");
            }

            h++;
        }
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
