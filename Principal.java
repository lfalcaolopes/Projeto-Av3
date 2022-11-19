import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args){
        ArrayList<Clinica> clinicas = setUpClinica();

        Dia dia = clinicas.get(1).getAgenda().getSemana().get(1);

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

    public static ArrayList<Clinica> setUpClinica(){
        Especialidade dermatologia = new Especialidade("Dermatologia");
        Especialidade pediatria = new Especialidade("Pediatria");
        Especialidade oftalmologia = new Especialidade("Oftalmologia");
        Especialidade cardiologia = new Especialidade("Cardiologia");
        Especialidade endocrinologia = new Especialidade("Endocrinologia");

        Clinica santaMarta = new Clinica("Santa Marta", 1111111, "Av. josé campos", dermatologia, pediatria, cardiologia);
        Clinica santoAntonio = new Clinica("Santo Antonio", 2222222, "Av. larissa cavalcanti", dermatologia, oftalmologia, cardiologia);
        Clinica santaBarbara = new Clinica("Santa Barbara", 3333333, "Av. luis eduardo", dermatologia, pediatria, oftalmologia, cardiologia, endocrinologia);

        return new ArrayList<Clinica>(Arrays.asList(santaMarta, santoAntonio, santaBarbara));
    }
}
