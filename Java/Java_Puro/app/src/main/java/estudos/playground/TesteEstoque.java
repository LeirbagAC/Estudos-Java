package estudos.playground;

import estudos.dao.ProdutoDao;
import estudos.model.Produto;
import java.util.List;

public class TesteEstoque {
    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoDao();

        //Isso NUNCA deve ser feito em produção. É só para ambiente de estudo/testes
        dao.limparTabela();

        Produto p1 = new Produto("Coca-Cola", 5.50, 10);
        Produto p2 = new Produto("Doritos", 8.00, 5);
        Produto p3 = new Produto("Cadeira", 450.00, 1);
        Produto p4 = new Produto("Coxinha", 8.00, 12);

        dao.salvar(p1);
        dao.salvar(p2);
        dao.salvar(p3);
        dao.salvar(p4);

        System.out.println("\n--- Lista de Produtos ----/");
        List<Produto> lista = dao.listarTodos();

        lista.forEach(System.out::println);

        System.out.println("\n/----- DELETE -----/");

        dao.deletar(p3);
//        dao.deletar(p1);
        System.out.println("Produto deletado com sucesso");


    }
}