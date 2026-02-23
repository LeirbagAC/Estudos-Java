package estudos.playground;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import estudos.model.ContaBancaria;
import estudos.service.Operacao;

public class LaboratorioLambda {
    public static void main(String[] args) {
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

        //Depositar em todas
        contas.forEach((c) -> c.depositar(50));

        System.out.println("-----------");

        //OBS: O removeIf é destrutivo. Ele vai na sua lista original e apaga os dados. Se você precisar da lista original depois, já era.
        //Filtrar tudo que for <= a 600 de saldo
//        contas.removeIf(c -> c.getSaldo() <= 2000);
//        System.out.println("Contas restantes: "  + contas.size());
//
//        System.out.println("-----------");

        //Usando a interface Operação para fazer uma potência
        Operacao potencia = (a, b) -> (int) Math.pow(a, b);
        System.out.println(potencia.calcular(2, 3));

        System.out.println("-----------");

        //Filtrar todos os valores ímpares
//        contas.removeIf(c -> {
//            return c.getSaldo() % 2 != 0;
//        });
//        System.out.println("Contas restantes: "  + contas.size());

        System.out.println("-----------");

        //Teste simples com stream
        List<ContaBancaria> contasDosRicos = contas.stream()
                .filter(c -> c.getSaldo() > 1000)
                .collect(Collectors.toList());

        System.out.println("Lista Original: " + contas.size());
        System.out.println("Lista Ricos: " + contasDosRicos.size());

    }
}
