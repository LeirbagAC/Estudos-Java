package estudos.playground;

import estudos.model.ContaBancaria; // Certifique-se que o import está certo
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class desafioStreamJdbcCorrecao {
    public static void main(String[] args) {
        // 1. Criando a lista na memória (Fonte)
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaBancaria("Gabriel", 1007));
        contas.add(new ContaBancaria("Pedro", 500));
        contas.add(new ContaBancaria("Felipe", 2003));

        // 2. Conectando e Preparando (Try-with-resources para fechar sozinho)
        try (
                Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContaBancaria", "root", "Ga4325");
                PreparedStatement stmt = conexao.prepareStatement("INSERT INTO conta (nome, saldo) VALUES (?, ?)")
        ) {
            System.out.println("✅ Conexão realizada!");

            // 3. O Pulo do Gato (Stream + JDBC)
            contas.forEach(conta -> {
                try {
                    // Preenchemos os dados DA CONTA ATUAL do loop
                    stmt.setString(1, conta.getTitular());
                    stmt.setDouble(2, conta.getSaldo());

                    // Executa o INSERT para esta conta
                    stmt.executeUpdate();

                    System.out.println("Inserido: " + conta.getTitular());

                } catch (SQLException e) {
                    // O Lambda obriga a tratar o erro aqui dentro
                    System.out.println("Erro ao inserir " + conta.getTitular());
                    e.printStackTrace();
                }
            });

        } catch (SQLException e) {
            System.out.println("❌ Falha Geral na Conexão!");
            e.printStackTrace();
        }
    }
}