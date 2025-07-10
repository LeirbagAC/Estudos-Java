package bootcamp;
import bootcamp.poo.ContaBancaria;

public class App {

    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("Gabriel", 1200);

        float consultarSaldo = conta1.getSaldo();
        System.out.println("Saldo: R$" + consultarSaldo);
        
        conta1.consultarChequeEspecial();

        // System.out.println(conta1.sacar(1200));
        // conta1.depositar(100);

        conta1.sacar(1801);

    }
}
