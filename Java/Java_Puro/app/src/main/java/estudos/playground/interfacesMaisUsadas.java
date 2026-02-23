package estudos.playground;

import estudos.utils.SaldoInsuficienteException;
import estudos.model.ContaBancaria;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class interfacesMaisUsadas {
    public static void main(String[] args) throws SaldoInsuficienteException {
        List<ContaBancaria> contas = new ArrayList<>();

        ContaBancaria c1 = new ContaBancaria("Gabriel", 1007);
        ContaBancaria c2 = new ContaBancaria("Pedro", 500);
        ContaBancaria c3 = new ContaBancaria("Felipe", 2003);
        ContaBancaria c4 = new ContaBancaria("Raul", 3100);
        ContaBancaria c5 = new ContaBancaria("João", 541);

        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
        contas.add(c4);
        contas.add(c5);

        contas.forEach(c -> c.consultarSaldo());

        System.out.println("-------");
        c1.sacar(1020);
        System.out.println("-------");

        Predicate<ContaBancaria> contaNegativada = conta -> conta.getSaldo() < 0;//Interface é o TIPO de dado. Ela define a Lógica. Ela não faz nada sozinha, ela só "existe" esperando ser usada.
        contas.removeIf(contaNegativada); //É a AÇÃO que aceita a interface como argumento e decide o que fazer com ela.
        contas.forEach(ContaBancaria::consultarSaldo); //Jeito mais rápido de escrever lambda nesse caso

        System.out.println("=== ANTES DO removeIf ===");
        contas.forEach(c -> System.out.printf("%s: R$ %.2f%n",
                c.getTitular(), c.getSaldo()));

        // Para remover saldos PARES (nomes mais claros)
        Predicate<ContaBancaria> saldoPar = c -> c.getSaldo() % 2 == 0;
        contas.removeIf(saldoPar);

        System.out.println("\n=== DEPOIS DO removeIf (saldos PARES removidos) ===");
        contas.forEach(c -> System.out.printf("%s: R$ %.2f%n",
                c.getTitular(), c.getSaldo()));

    }
}
