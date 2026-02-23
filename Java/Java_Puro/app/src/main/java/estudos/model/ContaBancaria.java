package estudos.model;

import estudos.utils.SaldoInsuficienteException;

public class ContaBancaria{
    public String nome;
    private double saldo;
    public double limiteChequeEspecial;
    private double valorUsadoChequeEspecial = 0;

    public ContaBancaria(String nome, double saldoInicial) {
        this.nome = nome;

        if(saldoInicial > 0) {
            this.saldo += saldoInicial;
        } else {
            this.saldo = 0;
            System.out.println("Depósito inicial inválido. O saldo começará em R$0,00.");
        }

        this.limiteChequeEspecial = calcularLimiteChequeEspecial(saldoInicial);
    }
    
    // --- MÉTODOS DE CONSULTA ---
    public void consultarSaldo() {
        System.out.printf("Saldo atual de %s: R$%.2f\n", this.nome, this.saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do Cheque Especial: R$%.2f\n", this.limiteChequeEspecial);
        if(isUsandoChequeEspecial()) {
            System.out.printf("Valor usado no Cheque Especial: R$%.2f", Math.abs(saldo));
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getTitular() {
        return this.nome;
    }

    public boolean isUsandoChequeEspecial() {
        return this.saldo < 0;
    }

    // --- MÉTODOS DE OPERAÇÃO ---
    public void depositar(double valor) {
        if(valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } 

        if(this.valorUsadoChequeEspecial > 0) {
            double taxa = this.valorUsadoChequeEspecial * 0.20;
            System.out.printf("TAXA: Cobrada taxa de 20%% sobre R$%.2f (uso do cheque especial), no valor de R$%.2f\n", this.valorUsadoChequeEspecial, taxa);
            this.saldo -= taxa;
            this.valorUsadoChequeEspecial = 0;
        }

        this.saldo += valor;
        System.out.printf("Depósito de R$%.2f realizado com sucesso.\n", valor);
        consultarSaldo();
    }

    //Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
    public void sacar(double valor) throws SaldoInsuficienteException{
        if(valor <= 0) {
            System.out.println("Valor inválido pra saque!");
            return;
        }

        double saldoDisponivel = this.saldo + this.limiteChequeEspecial;

        if(valor <= saldoDisponivel) {
            this.saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado com sucesso.\n", valor);

            //Verifica se entrou no cheque especial
            if(isUsandoChequeEspecial()) {
                this.valorUsadoChequeEspecial = Math.abs(this.saldo);
                System.out.println("Atenção: Você entrou no cheque especial.");
            } 
            consultarSaldo();

        } else {
            throw new SaldoInsuficienteException("Saque não autorizado. Valor ultrapassa o saldo + cheque especial.");
        }
    }

    // --- MÉTODOS INTERNOS (PRIVADOS) ---
    private double calcularLimiteChequeEspecial(double saldoInicial) {
        if(saldoInicial > 0 && saldoInicial <= 500) {
            return 50;
        } else if(saldoInicial > 500) {
            return saldoInicial * 0.5;
        } else {
            return 0;
        }
    }        
}