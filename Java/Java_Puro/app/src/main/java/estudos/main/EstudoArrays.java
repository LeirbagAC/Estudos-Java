package estudos.main;

public class EstudoArrays {

    public static void main(String[] args) {
        //Primeiro jeito de fazer uma array. Usado quando se sabe o tamanho dela
        String[] listaCompras = new String[4];
        listaCompras[0] = "Ovos";
        listaCompras[1] = "Leite";
        listaCompras[2] = "Batata";
        listaCompras[3] = "Alho";
        

        for(String lista : listaCompras) {
            System.out.println(lista);
        }

        System.out.println("#####");

        //Segundo jeito, feito quando os dados são constantes ou já conhecidos no momento da codificação
        String[] veiculos = {"Carro", "Moto", "Avião"};

        for(String veiculo : veiculos) {
            System.out.println(veiculo);
        }

        System.out.println("#####");

        String[] semana = new String[7];
        semana[0] = "Segunda";
        semana[1] = "terça";
        semana[2] = "Quarta";
        semana[3] = "Quinta";
        semana[4] = "Sexta";
        semana[5] = "Sabado";
        semana[6] = "Domingo";

        for(String dia : semana) {
            System.out.println(dia);
        }

        System.out.println("#####");

        String[] feriados = {"Natal", "Pascoa", "Ano novo", "Carnaval"};

        for(String feriado : feriados) {
            System.out.println(feriado);
        }

        // for (int i = 0; i < feriados.length; i++) {
        //     System.out.println(feriados[i]);
        // }
    }
}
