package estudos.banco;
import java.sql.*;


public class Teste {
    public static void main(String [] args) {
        try {
            System.out.println("Tentando conectar...");
            Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_estudos",
                    "root",
                    "Ga4325"
            );
            System.out.println("Conexão realizada com sucesso.");

//            String sql = "select titular from chequeEspecial where id = 3";
            String sql = "insert into chequeEspecial(titular) values (?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1,"Thanatos");
            stmt.execute();
            System.out.println("Valor gravado com sucesso!");

//            ResultSet resultado = stmt.executeQuery();
//            String teste = resultado.next() ?
//                    "O titular da conta de id 2 é: " + resultado.getString("Titular") :
//                    "Não tem ninguém no cheque especial.";
//            System.out.println(teste);

//            if(resultado.next()) {
//                String nome = resultado.getString("Titular");
//                System.out.println("O titular da conta de id 2 é: " + nome);
//            } else {
//                System.out.println("Não tem ninguém no cheque especial.");
//            }

//            resultado.close();
            stmt.close();
            conexao.close();

        }  catch(SQLException e) {
            System.out.println("X Falha ao conectar");
            e.printStackTrace();
        }
    }
}
