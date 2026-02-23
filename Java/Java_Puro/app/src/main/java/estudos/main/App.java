package estudos.main;
import estudos.model.ContaBancaria;

public class App {

    public static void main(String[] args) {
        System.out.println("--- Cenário 1: Saque usando cheque especial ---");
        ContaBancaria conta1 = new ContaBancaria("Gabriel", 1000.00);
        conta1.consultarSaldo(); 
        conta1.consultarChequeEspecial(); 
        
        System.out.println("\nTentando sacar R$1200.00...");
        //conta1.sacar(1200.00); //Isso aparece mensagem de erro agora por conta da throws no método sacar em ContaBancaria. Para consertar tem que usar um try/catch

        System.out.println("\n--- Cenário 2: Depósito para cobrir o cheque especial e pagar taxa ---");
        System.out.println("Depositando R$500.00...");
        conta1.depositar(500.00);


    }
}
