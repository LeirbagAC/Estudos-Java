     class Carro {
        String marca;
        String modelo;
        String ano;

        String ligar() {
            return "O Carro foi ligado.";
        }

        String desligar() {
            return "O Carro foi desligado.";
        }

        String exibirInformacoes(){
            return "Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano;
        }
    }

public class Main {

    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.marca = "Ford";
        carro.modelo = "Mustang";
        carro.ano = "2022";
        System.out.println(carro.ligar());
        System.out.println(carro.desligar());
        System.out.println(carro.exibirInformacoes());
    }
}
