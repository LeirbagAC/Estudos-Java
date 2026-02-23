package org.gabriel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 1. ESTEREÓTIPO (Stereotype Annotation)
// @Component avisa ao Spring: "Gerencie esta classe. Crie uma instância dela e coloque no Container."
// Sem isso (e sem o @Bean no AppConfig), o Spring ignoraria essa classe.
@Component
//@Scope("prototype")
public class Alien {

    // 4. TIPOS PRIMITIVOS
    // Como é 'int', o valor padrão é 0. Se fosse 'Integer', seria null.
    // O @Value pode ser usado aqui para injetar valores de arquivos .properties.
    @Value("21") //Usar value para valores mutáveis ou que sejam secretos, ex: @Value("${api.key}")
    private int age;

    // 5. PROGRAMAR PARA INTERFACE
    // Usamos 'Computer' (interface) e não 'Laptop' (classe).
    // Isso é o Desacoplamento. O Alien aceita qualquer coisa que seja um Computer.

    // --- TIPO 1: FIELD INJECTION (Injeção pelo Atributo) ---
    // NÃO RECOMENDADO atualmente.
    // Dificulta testes unitários (mocking) e esconde dependências.
    // @Autowired
    // @Qualifier("laptop") // Usado para desempatar se houver Desktop e Laptop
    private Computer com;

    // Construtor Padrão (Default)
    // O Spring usa este se não houver injeção via construtor configurada.
    public Alien() {
        System.out.println("Alien Object Created");
    }

    public void Idade() {
        System.out.println("A idade com value é: " + age);
    }

    // --- TIPO 2: CONSTRUCTOR INJECTION (Injeção pelo Construtor) ---
    // RECOMENDADO (Padrão de Mercado).
    // Vantagens:
    // 1. Garante que o Alien nunca existirá sem um computador (estado consistente).
    // 2. Permite usar 'final' na variável 'com' (imutabilidade).
    // 3. Facilita testes unitários (new Alien(new MockComputer())).
    @Autowired
    public Alien(Computer com) {
        this.com = com;
        System.out.println("Alien criado JÁ COM o computador");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    // --- TIPO 3: SETTER INJECTION (Injeção pelo Setter) ---
    // Útil para dependências OPCIONAIS.
    // O objeto é criado vazio e a dependência é "plugada" depois.
    // Se você descomentar o @Autowired aqui, ele vai tentar injetar novamente.
    // @Autowired
    // @Qualifier("desktop") // Força o uso do Desktop, ignorando o @Primary do Laptop (se houver)
    public void setCom(Computer com) {
        this.com = com;
        System.out.println("Setter chamado: Computador entregue");
    }

    public void code() {
        System.out.println("Coding");
        // Aqui o polimorfismo acontece. O Alien não sabe se é Desktop ou Laptop,
        // ele só sabe que o objeto tem o método .compile().
        com.compile();
    }
}