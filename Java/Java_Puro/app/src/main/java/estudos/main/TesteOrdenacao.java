package estudos.main;
import estudos.model.ContaBancaria;
import java.util.ArrayList;
import java.util.List;

public class TesteOrdenacao {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();
        ContaBancaria c1 = new ContaBancaria("Gabriel", 1000);
        ContaBancaria c2 = new ContaBancaria("Pedro", 500);
        ContaBancaria c3 = new ContaBancaria("Felipe", 2000);
        ContaBancaria c4 = new ContaBancaria("Raul", 3100);
        ContaBancaria c5 = new ContaBancaria("João", 540);

        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
        contas.add(c4);
        contas.add(c5);

//        for(ContaBancaria conta : contas) {
//            conta.consultarSaldo();
//        }
        //Para imprimir com lambda
        contas.forEach(c -> c.consultarSaldo());
        System.out.println("-------------------------");

        contas.sort((conta1, conta2) ->Double.compare(conta1.getSaldo(), conta2.getSaldo()));


        System.out.println("--- Depois da ordenação ---");
        contas.forEach(c -> System.out.println(c.getSaldo()));
    }

}
