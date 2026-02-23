package estudos.colecoes;

import java.util.HashMap;
import java.util.Map;

public class EstudoMap {
    public static void main(String[] args) {
        
        HashMap<String, Double> frutas = new HashMap<>();

        //Key, value
        frutas.put("Apple", 0.50);
        frutas.put("Orange", 0.75);
        frutas.put("Banana", 0.25);
        frutas.put("Coconut", 1.0);

        //Não aceita repetições e substituí caso tente
        frutas.put("Orange", 100000.0);

        frutas.remove("Apple");
        System.out.println(frutas);


        System.out.println(frutas.get("Coconut"));
        
        if(frutas.containsKey("Apple")) {
            System.out.printf("The price of the Apple is: " + frutas.get("Apple"));  
        } else {
            System.out.println("This fruit dont't exixt.");  
        }

        System.out.println(frutas.size());

        //Como Percorrer (Iterar) um Map
        System.out.println("--- Percorrendo as Chaves ---");
        for(String fruta : frutas.keySet()) {
            Double preco = frutas.get(fruta);
            System.out.println("The price of the " + fruta + " is: " + preco);
        }

        System.out.println("\n--- Apenas os valores ---");
        for(Double fruta1 : frutas.values()) {
            System.out.println("The price are: " + fruta1);
        }

        System.out.println("\n--- Percorrendo os Pares (Chave e Valor) ---");
        for(Map.Entry<String, Double> par : frutas.entrySet()) {
            String fruta3 = par.getKey();
            Double preco3 = par.getValue();
            System.out.println("The price of the " + fruta3 + " is: " + preco3);
        }

        System.out.println("\n--- Forma mais conscisa usando Lambda ---");
        frutas.forEach((fruta, preco) ->
            System.out.println("The price of the " + fruta + " is: " + preco)
        );

        System.out.println("\n--- Outro teste ---");
        HashMap<String, String> capitais = new HashMap<>();
        capitais.put("Brazil", "Brasília");
        capitais.put("Argentina", "Buenos Aires");
        capitais.put("Colômbia", "Bogotá");
        capitais.put("Peru", "Lima");

        for(Map.Entry<String, String> par : capitais.entrySet()) {
            String pais = par.getKey();
            String capital = par.getValue();
            System.out.println("A capital do " + pais + " é: " + capital);

        }

        System.out.println("\n--- Forma mais conscisa usando Lambda ---");
        capitais.forEach((pais, capital) ->
                System.out.println("A capital de " + pais + " é: " + capital)
        );

        /*
        Sobre a forma como declarar um Map ou até mesmo outras coleções:
        Use Map<K,V> variavel = new HashMap<>(); na maior parte dos casos (flexibilidade, boa prática).
        Use HashMap<K,V> só se precisar de algo muito específico dessa classe.
        */


    }
}