package estudos.playground;

import estudos.model.ContaBancaria;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class estudoStream {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();

        ContaBancaria c1 = new ContaBancaria("Gabriel", 1007);
        ContaBancaria c2 = new ContaBancaria("Pedro", 300);
        ContaBancaria c3 = new ContaBancaria("Felipe", 0);
        ContaBancaria c4 = new ContaBancaria("Raul", 12000);
        ContaBancaria c5 = new ContaBancaria("João", 1000);

        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
        contas.add(c4);
        contas.add(c5);

        List<String> nomesPositivos = contas.stream()
                .filter(c -> c.getSaldo() > 0)
                .map(c -> c.getTitular())
                .collect(Collectors.toList());
        System.out.println(nomesPositivos);

        //Lazy Evaluation: As operações intermediárias (filter, map, sorted) são preguiçosas. Isso significa que, se você escrever o código abaixo, NADA acontece:
//        Stream<ContaBancaria> stream = contas.stream()
//                .filter(c -> {
//                    System.out.println("Filtrando: " + c.getTitular());
//                    return c.getSaldo() > 0;
//                });

        System.out.println("-------------------------------------");

        List<String>  vips = contas.stream()
                .filter(c -> c.getSaldo() > 1000)
                .sorted((conta1, conta2) -> Double.compare(conta1.getSaldo(), conta2.getSaldo()))
                .map(ContaBancaria::getTitular)
                .toList();

        System.out.println(vips);

        System.out.println("-------------------------------------");
        double somaTotal = contas.stream()
                .mapToDouble(ContaBancaria::getSaldo)
                .sum();
        System.out.println("Patrimônio do Banco: " + somaTotal);

    }
}
