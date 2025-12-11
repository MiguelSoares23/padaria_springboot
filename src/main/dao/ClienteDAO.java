
import org.springframework.jdbc.core.simple.jdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO {
    private final JdbcClient jdbcClient;

    public ClienteDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
}
