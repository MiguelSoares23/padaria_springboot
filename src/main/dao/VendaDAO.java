package br.ifpe.jaboatao.padaria.dao;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import br.ifpe.jaboatao.padaria.models.Venda;
import java.sql.Date;
import java.util.List;

@Repository
public class VendaDAO {
    private final JdbcClient jdbcClient;
    
    public VendaDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public void create(Venda venda) {
        String sql = "INSERT INTO venda (data, id_cliente, id_funcionario, valor_total) VALUES (?, ?, ?, ?)";
        jdbcClient.sql(sql)
            .param(Date.valueOf(venda.getData()))
            .param(venda.getIdCliente())
            .param(venda.getIdFuncionario())
            .param(venda.getValorTotal())
            .update();
    }
    
    public List<Venda> findAll() {
        String sql = "SELECT * FROM venda";
        return jdbcClient.sql(sql)
            .query((rs, rowNum) -> {
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("id_venda"));
                v.setData(rs.getDate("data").toLocalDate());
                v.setIdCliente(rs.getInt("id_cliente"));
                v.setIdFuncionario(rs.getInt("id_funcionario"));
                v.setValorTotal(rs.getFloat("valor_total"));
                return v;
            }).list();
    }
    
    public Venda findById(int id) {
        String sql = "SELECT * FROM venda WHERE id_venda = ?";
        return jdbcClient.sql(sql)
            .param(id)
            .query((rs, rowNum) -> {
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("id_venda"));
                v.setData(rs.getDate("data").toLocalDate());
                v.setIdCliente(rs.getInt("id_cliente"));
                v.setIdFuncionario(rs.getInt("id_funcionario"));
                v.setValorTotal(rs.getFloat("valor_total"));
                return v;
            }).optional().orElse(null);
    }
    
    public List<Venda> findByCliente(int idCliente) {
        String sql = "SELECT * FROM venda WHERE id_cliente = ?";
        return jdbcClient.sql(sql)
            .param(idCliente)
            .query((rs, rowNum) -> {
                Venda v = new Venda();
                v.setIdVenda(rs.getInt("id_venda"));
                v.setData(rs.getDate("data").toLocalDate());
                v.setIdCliente(rs.getInt("id_cliente"));
                v.setIdFuncionario(rs.getInt("id_funcionario"));
                v.setValorTotal(rs.getFloat("valor_total"));
                return v;
            }).list();
    }
    
    public void update(Venda venda) {
        String sql = "UPDATE venda SET data=?, id_cliente=?, id_funcionario=?, valor_total=? WHERE id_venda=?";
        jdbcClient.sql(sql)
            .param(Date.valueOf(venda.getData()))
            .param(venda.getIdCliente())
            .param(venda.getIdFuncionario())
            .param(venda.getValorTotal())
            .param(venda.getIdVenda())
            .update();
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM venda WHERE id_venda = ?";
        jdbcClient.sql(sql).param(id).update();
    }
}