package estudos.playground;

import estudos.model.ContaBancaria;
import java.sql.*;

public class SistemaBancario {

    private static final String URL = "jdbc:mysql://localhost:3306/ContaBancaria";
    private static final String USER = "root";
    private static final String PASS = "Ga4325";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASS)){
            System.out.println("Tentando conectar...");
            System.out.println("✅ Sistema conectado ao banco!");

            String sqlUpdate = "UPDATE conta SET saldo = ? WHERE nome = ?";

            try(PreparedStatement stmtUpdate = conexao.prepareStatement(sqlUpdate)) {
                stmtUpdate.setDouble(1, 50.00);
                stmtUpdate.setString(2, "Pedro");

                int linhasAfetadas = stmtUpdate.executeUpdate();
                if(linhasAfetadas > 0) {
                    System.out.println("Saldo de Pedro atualizado com sucesso");
                } else {
                    System.out.println("⚠️ Pedro não foi encontrado para atualizar.");
                }

            }

            String sqlDelete = "DELETE FROM conta WHERE NOME = ?";
            try(PreparedStatement stmtDelete = conexao.prepareStatement(sqlDelete)) {
                stmtDelete.setString(1, "Felipe");

                int linhasAfetadas = stmtDelete.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("🗑️ Conta do Felipe removida com sucesso!");
                } else {
                    System.out.println("⚠️ Felipe não foi encontrado para remover.");
                }
            }

            // ---------------------------------------------------------
            System.out.println("\n--- RELATÓRIO FINAL ---");
            String sqlSelect = "SELECT nome, saldo FROM conta";
            try (PreparedStatement stmtSelect = conexao.prepareStatement(sqlSelect);
                 ResultSet rs = stmtSelect.executeQuery()) {

                while(rs.next()) {
                    System.out.printf("Cliente: %-10s | Saldo: R$ %.2f\n",
                            rs.getString("nome"),
                            rs.getDouble("saldo"));
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
