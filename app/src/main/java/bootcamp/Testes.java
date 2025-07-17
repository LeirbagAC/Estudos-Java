package bootcamp;

public class Testes {
    public record Pessoa(String nome, int idade) {}

    public static void main(String[] args) {
        Pessoa p = new Pessoa("Gabriel", 20);

        System.out.println(p.nome());  
        System.out.println(p.idade()); 
    }
}