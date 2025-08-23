package bootcamp.Coleções;
import java.util.*;

public class Listas{
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        //adicionar valores
        nomes.add("Pedro");
        nomes.add("Gabriel");
        nomes.add("Raul");
        nomes.add("Ricardo");
        nomes.add("Pedro"); //Aceita valor duplicado
        System.out.println(nomes);

        //mudar um valor
        nomes.set(1, "João");
        System.out.println(nomes);

        //acessar por índice
        System.out.println(nomes.get(3));

        //remover por valor
        nomes.remove("Pedro");
        System.out.println(nomes);

        //removar por índice
        nomes.remove(2);
        System.out.println(nomes);

        //Pare ter o tamanho da array semelhante ao length em js
        System.out.println(nomes.size()); 

        //Verificar se a array list tem um elemento e retorna como boolean
        System.out.println("A lista contém Raul? " + nomes.contains("Raul"));

        nomes.add("teste1");
        //Para limpar tudo
        System.out.println("Limpando a lista com clear... ");
        nomes.clear();
        System.out.println("Lista vazia");

        nomes.add("Lista limpar pelo clear");
        System.out.println(nomes);

        // List<Int> numeros = new ArrayList<>();
        
        // numeros.add(10);
        // numeros.add(20);
        // numeros.add(30);
        // numeros.add(40);


        // System.out.println(numeros.get(3));


    }
}