package bootcamp;
import bootcamp.poo.ContaBancaria;

public class App {

    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria(1200);

        float verSaldo = conta1.getSaldo();
        System.out.println("Saldo: R$" + verSaldo);

        //Para mudar o valor do saldo - Setter
        // conta1.setSaldo(150);
        // System.out.println("Novo saldo: R$" + conta1.getSaldo());

        

    }
}
