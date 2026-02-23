package estudos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import estudos.model.ContaBancaria;

class AppTest {

    @Test
    void testeCriacaoDeConta() {
        // 1. Cenário (Arrange)
        ContaBancaria conta = new ContaBancaria("Gabriel", 1000.0);

        // 2. Ação (Act) & 3. Verificação (Assert)
        // Verificamos se o saldo inicial está correto
        assertEquals(1000.0, conta.getSaldo(), "O saldo inicial deve ser 1000");

        // Verificamos se o nome está correto
        assertEquals("Gabriel", conta.getTitular());
    }

    @Test
    void testeDeposito() {
        ContaBancaria conta = new ContaBancaria("Teste", 0);

        conta.depositar(500);

        // Esperamos que o saldo seja 500
        assertEquals(500.0, conta.getSaldo());
    }
}