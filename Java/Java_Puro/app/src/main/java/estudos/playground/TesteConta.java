package estudos.playground;

import estudos.model.ContaBancaria;
import estudos.utils.SaldoInsuficienteException;

public class TesteConta {
    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria("Gabriel", 600);

        try {
            minhaConta.sacar(1000);
            System.out.println("---------");
        } catch (SaldoInsuficienteException mensagem) {
            System.out.println("Erro ao sacar: " + mensagem.getMessage());
        }
//
//        try {
//            minhaConta.sacar(801);
//        } catch (SaldoInsuficienteException e) {
//            System.out.println("Erro ao sacar: " + e.getMessage());
//        }


    }

}
