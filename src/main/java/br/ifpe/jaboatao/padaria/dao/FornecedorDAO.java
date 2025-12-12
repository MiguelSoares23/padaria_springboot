package br.ifpe.jaboatao.padaria.dao;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import br.ifpe.jaboatao.padaria.models.Fornecedor;
import java.util.List;

@Repository
public class FornecedorDAO {
    private final JdbcClient jdbcClient;
    
    public FornecedorDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public void create(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (nome, telefone, produto_fornecido) VALUES (?, ?, ?)";
        jdbcClient.sql(sql)
            .param(fornecedor.getNome())
            .param(fornecedor.getTelefone())
            .param(fornecedor.getProdutoFornecido())
            .update();
    }
    
    public List<Fornecedor> findAll() {
        String sql = "SELECT * FROM fornecedor";
        return jdbcClient.sql(sql)
            .query((rs, rowNum) -> {
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setProdutoFornecido(rs.getString("produto_fornecido"));
                return f;
            }).list();
    }
    
    public Fornecedor findById(int id) {
        String sql = "SELECT * FROM fornecedor WHERE id_fornecedor = ?";
        return jdbcClient.sql(sql)
            .param(id)
            .query((rs, rowNum) -> {
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setProdutoFornecido(rs.getString("produto_fornecido"));
                return f;
            }).optional().orElse(null);
    }
    
    public List<Fornecedor> findByNome(String nome) {
        String sql = "SELECT * FROM fornecedor WHERE nome LIKE ?";
        return jdbcClient.sql(sql)
            .param("%" + nome + "%")
            .query((rs, rowNum) -> {
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setProdutoFornecido(rs.getString("produto_fornecido"));
                return f;
            }).list();
    }
    
    public void update(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET nome=?, telefone=?, produto_fornecido=? WHERE id_fornecedor=?";
        jdbcClient.sql(sql)
            .param(fornecedor.getNome())
            .param(fornecedor.getTelefone())
            .param(fornecedor.getProdutoFornecido())
            .param(fornecedor.getIdFornecedor())
            .update();
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
        jdbcClient.sql(sql).param(id).update();
    }
}
