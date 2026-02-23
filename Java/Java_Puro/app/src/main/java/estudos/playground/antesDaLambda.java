package estudos.playground;

import estudos.playground.Robo;
import estudos.service.Acao;

public class antesDaLambda {
    public static void main(String[] args) {
        //Jeito antigo de fazer as coisas
        Robo meuRobo = new Robo();

        meuRobo.receberOrdem(new Acao() {
            @Override
            public void executar() {
                System.out.println("Olá, humanos! (Jeito antigo)");
            }
        });

        meuRobo.receberOrdem(new Acao() {
            @Override
            public void executar() {
                System.out.println("Olá, humanos2! (Jeito antigo)");
            }
        });

    }
}