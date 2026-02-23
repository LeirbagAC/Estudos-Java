package estudos.colecoes;

//List é como se fosse o contrato e ArrayList a implementação real
import java.util.List;
import java.util.ArrayList;

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

        //Para limpar tudo
        System.out.println("Limpando a lista com clear... ");
        nomes.clear();
        System.out.println("Lista vazia");
        nomes.add("Lista limpar pelo clear");
        System.out.println(nomes);

        //Verifica se está vazio
        System.out.println(nomes.isEmpty());

        //Para trabalhar com sublistas
        List<String> frutas = new ArrayList<>();
        frutas.add("Maça");
        frutas.add("Uva");
        frutas.add("melância");
        frutas.add("Péra");
        frutas.add("Melão");


        List<String> subListFrutas = frutas.subList(1, 4); //índice inicial é inclusivo, mas o final não
        System.out.println("Sublista de frutas 1 até 4: " + subListFrutas);

        //A sublista é uma visão da original, ou seja, se muda ela a original também muda
        subListFrutas.set(0, "Laranja");
        System.out.println(frutas);

        //E para criar uma independente é dessa forma
        List<String> copiaFrutas = new ArrayList<>(frutas.subList(2, 5));
        System.out.println("Sublista cópia de frutas: " + copiaFrutas);


        List<Integer> numeros = new ArrayList<>();
        
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);


        System.out.println(numeros.get(3));


    }
}