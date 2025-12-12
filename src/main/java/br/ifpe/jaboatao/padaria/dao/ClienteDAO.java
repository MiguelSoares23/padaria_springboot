package br.ifpe.jaboatao.padaria.dao;

import org.springframework.jdbc.core.simple.jdbcClient;
import org.springframework.stereotype.Repository;
import br.ifpe.jaboatao.padaria.models.Cliente;
import java.util.List;

@Repository
public class ClienteDAO {
    private final JdbcClient jdbcClient;

    public ClienteDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void create(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (?, ?, ?)";
        jdbcCliente.sql(sql)
            .param(cliente.getNome())
            .param(cliente.getCpf())
            .param(cliente.getTelefone())
            .update();
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        return jdbcClient.sql(sql)
            .query((rs, rowNum) -> {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                return c;
            }).list();
    }

    public Cliente findById(int id) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        return jdbcClient.sql(sql)
            .param(id)
            .query((rs, rowNum) -> {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                return c;
            }).optional().orElse(null);
    }

    public List<Cliente> findByNome(String nome) {
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        return jdbcClient.sql(sql)
            .param("%" + nome + "%")
            .query((rs, rowNum) -> {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                return c;
            }).list();
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE cliente SET nome=?, cpf=?, telefone=? WHERE id_cliente=?";
        jdbcClient.sql(sql)
            .param(cliente.getNome())
            .param(cliente.getCpf())
            .param(cliente.getTelefone())
            .param(cliente.getIdCliente())
            .update();
    }

    public void delete(int id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        jdbcClient.sql(sql).param(id).update();
    }

}
