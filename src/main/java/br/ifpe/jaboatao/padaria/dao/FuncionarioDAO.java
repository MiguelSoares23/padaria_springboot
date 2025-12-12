package br.ifpe.jaboatao.padaria.dao;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import br.ifpe.jaboatao.padaria.models.Funcionario;
import java.util.List;

@Repository
public class FuncionarioDAO {
    private final JdbcClient jdbcClient;
    
    public FuncionarioDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    public void create(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cargo, salario) VALUES (?, ?, ?)";
        jdbcClient.sql(sql)
            .param(funcionario.getNome())
            .param(funcionario.getCargo())
            .param(funcionario.getSalario())
            .update();
    }
    
    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM funcionario";
        return jdbcClient.sql(sql)
            .query((rs, rowNum) -> {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getFloat("salario"));
                return f;
            }).list();
    }
    
    public Funcionario findById(int id) {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        return jdbcClient.sql(sql)
            .param(id)
            .query((rs, rowNum) -> {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getFloat("salario"));
                return f;
            }).optional().orElse(null);
    }
    
    public List<Funcionario> findByNome(String nome) {
        String sql = "SELECT * FROM funcionario WHERE nome LIKE ?";
        return jdbcClient.sql(sql)
            .param("%" + nome + "%")
            .query((rs, rowNum) -> {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getFloat("salario"));
                return f;
            }).list();
    }
    
    public void update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome=?, cargo=?, salario=? WHERE id_funcionario=?";
        jdbcClient.sql(sql)
            .param(funcionario.getNome())
            .param(funcionario.getCargo())
            .param(funcionario.getSalario())
            .param(funcionario.getIdFuncionario())
            .update();
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        jdbcClient.sql(sql).param(id).update();
    }
}