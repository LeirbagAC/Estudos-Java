package bootcamp.Coleções;
import java.util.HashMap;

public class Map {
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
    }
}