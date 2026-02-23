package estudos.colecoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EstudoSet {
    public static void main(String[] args) {
        //Ordem de inserção não é garantida
        Set<String> convidados = new HashSet<>();

        System.out.println("Adicionando convidados...");
        convidados.add("Gabriel");
        convidados.add("Pedro");
        convidados.add("Alice");
        convidados.add("Gabriel");
        convidados.add("Ana");  

        boolean conseguiuAdicionar = convidados.add("Alice");

        System.out.println("Lista de convidados: " + convidados);
        System.out.println("Conseguiu adicionar 'Alice' de novo? " + conseguiuAdicionar);

        boolean convidadoPresente = convidados.contains("Gabriel");
        System.out.println(convidadoPresente);

        convidados.remove("Ana");

        // Esta é a forma padrão e mais eficiente de percorrer um Set
        System.out.println("\n--- Lista de Convidados ---");
        for (String convidado : convidados) {
            // A cada volta do loop, a variável 'convidado' recebe um dos elementos do Set.
            System.out.println("- " + convidado);
        }

        System.out.println("\n----------------------------------\n");

        // --- CASO DE USO: Removendo duplicatas de uma lista ---
        List<Integer> notas = new ArrayList<>();
        notas.add(10); //Duplicata
        notas.add(9);
        notas.add(8);
        notas.add(7);
        notas.add(6);
        notas.add(10); //Duplicata
        notas.add(5);

        System.out.println("Lista de notas original (com duplicatas): " + notas);
        Set<Integer> notasSemDuplicatas = new HashSet<>(notas);
        System.out.println("Lista de notas sem duplicatas: " + notasSemDuplicatas);
    }
}