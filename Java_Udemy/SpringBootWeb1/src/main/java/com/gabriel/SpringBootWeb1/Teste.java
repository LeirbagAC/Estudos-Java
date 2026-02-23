package com.gabriel.SpringBootWeb1;

public class Teste {
    public static void main(String[] args) {

        double a = 2, b = 5, c = 3;
        double delta = (b * b) - 4 * a * c;

        if (delta > 0) {
            double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);

            System.out.printf("O valor do delta é: %.2f\n", delta);
            System.out.println("A equação tem duas raízes reais e diferentes:");
            System.out.println("Raiz 1 = " + raiz1);
            System.out.println("Raiz 2 = " + raiz2);

        } else if (delta == 0) {
            double raiz = -b / (2 * a);

            System.out.printf("O valor do delta é: %.2f\n", delta);
            System.out.println("A equação tem uma raiz real (ou duas iguais):");
            System.out.println("Raiz = " + raiz);

        } else {
            System.out.printf("O valor do delta é: %.2f\n", delta);
            System.out.println("A equação não tem raízes reais.");
        }
    }
}
