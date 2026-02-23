package estudos.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExecutarConsulta {
    public static void main(String[] args) {
        try{
            System.out.println("Tentando conectar...");

            Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_estudos",
                    "root",
                    "Ga4325"
            );
            System.out.println("Conexão realizada com sucesso!");
            String sql = "select titular from contas where id = 3";
//            String sql = "select titular, saldo from contas";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery(); //apenas para select

            //Quando se cria o ResultSet, o dedo do Java está apontando para o cabeçalho (fora dos dados).
            //Quando se chama .next(), o dedo desce para a linha 1. Se existir dados lá, ele retorna true.
            // Se não tiver nada (ID inexistente), retorna false.
            if(resultado.next()) {
                String nome = resultado.getString("titular");
                System.out.println("O titular da conta de id 3 é: " + nome);
            } else {
                System.out.println("Nenhum titular com o id 3.");
            }

            System.out.println("-------------------------------------");

            while(resultado.next()) {
                String nome = resultado.getString("titular");
                double saldo = resultado.getDouble("saldo");

                System.out.printf("%s tem %f de saldo disponível!\n", nome, saldo);
            }

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("X Falha ao conectar");
            e.printStackTrace();
        }
    }
}
