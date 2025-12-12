package br.ifpe.jaboatao.padaria.dao;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import br.ifpe.jaboatao.padaria.models.Padaria;
import java.util.List;

@Repository
public class PadariaDAO {
    private final JdbcClient jdbcClient;
    
    public PadariaDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public void create(Padaria padaria) {
        String sql = "INSERT INTO padaria (nome, endereco) VALUES (?, ?)";
        jdbcClient.sql(sql)
            .param(padaria.getNome())
            .param(padaria.getEndereco())
            .update();
    }
    
    public List<Padaria> findAll() {
        String sql = "SELECT * FROM padaria";
        return jdbcClient.sql(sql)
            .query((rs, rowNum) -> {
                Padaria p = new Padaria();
                p.setIdPadaria(rs.getInt("id_padaria"));
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereco"));
                return p;
            }).list();
    }
    
    public Padaria findById(int id) {
        String sql = "SELECT * FROM padaria WHERE id_padaria = ?";
        return jdbcClient.sql(sql)
            .param(id)
            .query((rs, rowNum) -> {
                Padaria p = new Padaria();
                p.setIdPadaria(rs.getInt("id_padaria"));
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereco"));
                return p;
            }).optional().orElse(null);
    }
    
    public List<Padaria> findByNome(String nome) {
        String sql = "SELECT * FROM padaria WHERE nome LIKE ?";
        return jdbcClient.sql(sql)
            .param("%" + nome + "%")
            .query((rs, rowNum) -> {
                Padaria p = new Padaria();
                p.setIdPadaria(rs.getInt("id_padaria"));
                p.setNome(rs.getString("nome"));
                p.setEndereco(rs.getString("endereco"));
                return p;
            }).list();
    }
    
    public void update(Padaria padaria) {
        String sql = "UPDATE padaria SET nome=?, endereco=? WHERE id_padaria=?";
        jdbcClient.sql(sql)
            .param(padaria.getNome())
            .param(padaria.getEndereco())
            .param(padaria.getIdPadaria())
            .update();
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM padaria WHERE id_padaria = ?";
        jdbcClient.sql(sql).param(id).update();
    }
}
