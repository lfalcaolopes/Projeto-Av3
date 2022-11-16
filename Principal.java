public class Principal {
    public static void main(String[] args){


        Consulta cpa = new ConsultaParticular("ontem", 16,true, 320);

        Consulta cpl = new ConsultaPlano("amanha", 18,true, "amil", 123);

        System.out.println(cpa.getDataConsulta());

    }
}
