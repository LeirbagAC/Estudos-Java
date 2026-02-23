package estudos.playground;

import estudos.playground.Robo;
import estudos.service.Operacao;

public class estudoLambda {
    public static void main(String[] args) {
        Robo meuRobo = new Robo();
        meuRobo.receberOrdem(() -> System.out.println("Olá, humanos! (Com lambda)"));

        Operacao soma = (a, b) -> a + b;
        System.out.println(soma.calcular(5, 4));

        Operacao multiplicacao = (a, b) -> a * b;
        System.out.println(multiplicacao.calcular(5, 4));


    }
}
