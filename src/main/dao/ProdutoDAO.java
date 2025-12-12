package br.ifpe.jaboatao.padaria.dao;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import br.ifpe.jaboatao.padaria.models.Produto;
import java.util.List;

@Repository
public class ProdutoDAO {
    private final JdbcClient jdbcClient;
    
    public ProdutoDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public void create(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, qtd_estoque, categoria) VALUES (?, ?, ?, ?)";
        jdbcClient.sql(sql)
            .param(produto.getNome())
            .param(produto.getPreco())
            .param(produto.getQtdEstoque())
            .param(produto.getCategoria())
            .update();
    }
    
    public List<Produto> findAll() {
        String sql = "SELECT * FROM produto";
        return jdbcClient.sql(sql)
            .query((rs, rowNum) -> {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQtdEstoque(rs.getInt("qtd_estoque"));
                p.setCategoria(rs.getString("categoria"));
                return p;
            }).list();
    }
    
    public Produto findById(int id) {
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
        return jdbcClient.sql(sql)
            .param(id)
            .query((rs, rowNum) -> {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQtdEstoque(rs.getInt("qtd_estoque"));
                p.setCategoria(rs.getString("categoria"));
                return p;
            }).optional().orElse(null);
    }
    
    public List<Produto> findByNome(String nome) {
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        return jdbcClient.sql(sql)
            .param("%" + nome + "%")
            .query((rs, rowNum) -> {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQtdEstoque(rs.getInt("qtd_estoque"));
                p.setCategoria(rs.getString("categoria"));
                return p;
            }).list();
    }
    
    public void update(Produto produto) {
        String sql = "UPDATE produto SET nome=?, preco=?, qtd_estoque=?, categoria=? WHERE id_produto=?";
        jdbcClient.sql(sql)
            .param(produto.getNome())
            .param(produto.getPreco())
            .param(produto.getQtdEstoque())
            .param(produto.getCategoria())
            .param(produto.getIdProduto())
            .update();
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        jdbcClient.sql(sql).param(id).update();
    }
}
