package bootcamp.poo;

public class ContaBancaria{
    private float saldo;

    public ContaBancaria(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float novoSaldo) {
        this.saldo += novoSaldo;
    }

    //Apesar de ter um setter que faz uma função parecida é fundamental ter o método depositar para não acessar o saldo diretamente
    public float depositar(float valor) {
        return this.saldo += valor;
    }

        
}