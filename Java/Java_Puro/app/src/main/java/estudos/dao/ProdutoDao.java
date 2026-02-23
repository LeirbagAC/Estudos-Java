package estudos.dao;

import estudos.model.Produto;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDao {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java_estudos", "root", "Ga4325");
    }

    public void salvar (Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try(Connection connection = getConnection();                  //Para retorna o id que o banco gera
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());

            stmt.execute();

            //Para setar o id gerado pelo banco com o do java
            ResultSet idsGerados = stmt.getGeneratedKeys();
            if(idsGerados.next()) {
                int idNovo = idsGerados.getInt(1);
                produto.setId(idNovo);
                System.out.println("Produto salvo com id gerado pelo Banco: " + idNovo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT *FROM produtos";

        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco")); //Tem que ser escrita do mesmo jeito, se não dá erro.
                p.setQuantidade(rs.getInt("quantidade"));

                produtos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
   }

   public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, preco = ?, quantidade = ? WHERE id = ?;";

        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

   public void deletar(Produto produto) {
        String sql = "DELETE FROM produtos WHERE id=?;";

        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, produto.getId());
            stmt.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
   }

   public void limparTabela() {
        String sql = "TRUNCATE produtos;";

        try(Connection c = getConnection();
            PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

}
