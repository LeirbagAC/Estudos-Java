package estudos.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConexaoBanco {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_estudos";
        String usuario = "root";
        String senha = "Ga4325";

        try {
            System.out.println("Tentando conectar...");

            // A mágica acontece aqui:
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ Conexão realizada com sucesso!");
            String sql = "INSERT INTO contas (titular, saldo) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, "Gabriel");
            stmt.setDouble(2, 5000);

            stmt.execute();
            System.out.println("Gravado com sucesso");

            stmt.close();

            // Sempre feche a conexão quando acabar!
            conexao.close();

        } catch (SQLException e) {
            System.out.println("❌ Falha ao conectar!");
            e.printStackTrace();
        }
    }
}