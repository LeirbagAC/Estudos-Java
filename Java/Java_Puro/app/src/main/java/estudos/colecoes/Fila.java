package estudos.colecoes;
import java.util.Queue;
import java.util.LinkedList;


public class Fila {
    public static void main(String[] args) {
        //queue é um interface en não uma classe e ela extends Collection, então pode usar todos os métodos dela
        Queue<String> fila = new LinkedList<String>();
        fila.offer("Gabriel");
        fila.offer("Raul");
        fila.offer("Karen");
        fila.offer("Ricardo");
        fila.offer("Steve");

        System.out.println(fila);

        fila.poll();
        fila.poll();
        fila.poll();
        System.out.println(fila);

        System.out.println(fila.contains("Steve"));

        fila.poll();
        System.out.println(fila.peek());

    }
}
