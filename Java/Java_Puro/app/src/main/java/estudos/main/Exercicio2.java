package estudos.main;
import estudos.model.Carro;

public class Exercicio2 {
    public static void main(String[] args) {
    Carro meuCarro = new Carro();
    meuCarro.verStatusCompleto();

    meuCarro.ligarCarro();
    meuCarro.acelerar(); // Deve dar erro (ponto morto)
    
    meuCarro.aumentarMarcha(); // Vai para a 1ª
    meuCarro.acelerar(); // Agora funciona
    meuCarro.acelerar();
    meuCarro.verStatusCompleto();

    meuCarro.virarDireita(); // Funciona

    // Tenta desligar em movimento
    meuCarro.desligarCarro(); // Deve dar erro

    meuCarro.frear();
    meuCarro.frear();
    meuCarro.reduzirMarcha(); // Vai para ponto morto
    meuCarro.verStatusCompleto();

    meuCarro.desligarCarro(); // Agora funciona
    meuCarro.verStatusCompleto();
    }
}
