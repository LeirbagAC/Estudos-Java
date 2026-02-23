package estudos.playground;

import estudos.model.ContaBancaria;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class desafioStreamJdbc {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();

        ContaBancaria c1 = new ContaBancaria("Gabriel", 1007);
        ContaBancaria c2 = new ContaBancaria("Pedro", 500);
        ContaBancaria c3 = new ContaBancaria("Felipe", 2003);

        contas.add(c1);
        contas.add(c2);
        contas.add(c3);

        try {
            System.out.println("Tentando conectar...");

            Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ContaBancaria",
                    "root",
                    "Ga4325"
            );
            System.out.println("✅ Conexão realizada com sucesso!");

            String sql = "insert into conta (nome, saldo) values (?, ?)";

            contas.stream().forEach(conta -> {
                try(PreparedStatement stmt = conexao.prepareStatement(sql)) { //Cometi esse erro que até dá certo para inserir, mas dessa forma não é eficiente para tabelas grandes
                    stmt.setString(1, conta.getTitular());
                    stmt.setDouble(2, conta.getSaldo());
                    stmt.executeUpdate();

                    System.out.println("Inserido:  " + conta.getTitular());
                } catch (SQLException e) {
                    System.out.println("Ero ao inserir " + conta.getTitular() + ": " + conta.getSaldo());
                }
            });

        } catch (SQLException e) {
            System.out.println("❌ Falha ao conectar!");
            e.printStackTrace();
        }
    }
}
