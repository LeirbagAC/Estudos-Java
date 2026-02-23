package estudos.playground;

import estudos.service.Acao;

public class Robo {
    public void receberOrdem(Acao acao) {
        acao.executar();
    }
}
