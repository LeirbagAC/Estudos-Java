package bootcamp.poo;

public class ContaBancaria{
    public String nome;
    private float saldo;
    public float chequeEspecial;

    public ContaBancaria(String nome, float saldo) {
        this.nome = nome;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecialValor();
    }

    //Consultar saldo
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float novoSaldo) {
        this.saldo += novoSaldo;
    }

    //Apesar de ter um setter que faz uma função parecida é fundamental ter o método depositar para não acessar o saldo diretamente
    public void depositar(float valor) {
        if(valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            float novoSaldo = this.saldo += valor;
            System.out.println("Novo saldo após o depósito: R$" + novoSaldo);
        }
    }

    //Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
    public void sacar(float valor) {
        if(valor <= 0) {
            System.out.println("Valor inválido pra saque!");
            return;
        }

        float saldoDisponivel = this.saldo + this.chequeEspecial;

        if(valor <= saldoDisponivel) {
            this.saldo -= valor;

            //Verifica se emtrou no cheque especial
            if(isNoChequeEspecial()) {
                float valorUsadoCheque = Math.abs(saldo);
                float taxa = valorUsadoCheque * 0.2f;
    
                saldo -= taxa;
    
                System.out.printf("Você usou o cheque especial. Foi cobrada uma taxa de R$%.2f\n", taxa);
            } else {
                System.out.println("Saldo realizado com sucesso.");
            }

        } else {
            System.out.println("Saque não autorizado. Valor ultrapassa o saldo + cheque especial.");
        }
    }

    //Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
    //Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado
    private float chequeEspecialValor() {
        if(this.saldo > 0 && this.saldo <= 500) {
            return chequeEspecial = 50;
        } else {
            return chequeEspecial = this.saldo * 0.5f;
        }
    }

    public void consultarChequeEspecial() {
        System.out.println("Cheque Especial no valor de: R$" + chequeEspecial);
    }

    public boolean isNoChequeEspecial() {
        return saldo < 0;
    }

        
}