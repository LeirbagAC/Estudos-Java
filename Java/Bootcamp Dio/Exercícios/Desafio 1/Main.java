import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor do salário? ");
        float valorSalario = scanner.nextFloat();

        System.out.println("Qual o valor do benefício? ");
        float valorBeneficio = scanner.nextFloat();

        float valorImposto = 0;
        if(valorSalario >= 0 && valorSalario <= 1100) {
            valorImposto = 0.05f * valorSalario;
        } else if(valorSalario > 1100 && valorSalario <= 2500) {
            valorImposto = 0.10f * valorSalario;
        } else if(valorSalario > 2500) {
            valorImposto = 0.15f * valorSalario;
        }

        System.out.println(valorSalario);
        System.out.println(valorImposto);
        System.out.println(valorBeneficio);

        float saida = valorSalario - valorImposto + valorBeneficio;
        System.out.printf("Salário após os desconto: %f \n", saida);
    }
}
