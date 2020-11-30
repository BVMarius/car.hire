package ro.agilehub.javacourse.car.hire.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.PreparedStatement;

public class UserJdbcRepositoryImpl implements UserJdbcRepository{
    @Autowired
    private DataSource dataSource;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateUser(String email, String password
            , String username, String firstName,
                           String lastName, Integer country, Integer id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = """
                update consumers
                                set email = ?,
                                password = ?,
                                username = ?,
                                first_name= ?,
                                last_name =?,
                                country_id = ?
                                where id = ?
                """;

        jdbcTemplate.execute(sql,
                (PreparedStatement ps) ->
                {
                    ps.setString(1,email);
                    ps.setString(2,password);
                    ps.setString(3, username);
                    ps.setString(4,firstName);
                    ps.setString(5,lastName);
                    ps.setInt(6, country);
                    ps.setInt(7,id);
                    return ps.execute();
                });
    }

    @Override
    public <T> void detachEntity(T entity) {
                entityManager.detach(entity);
    }
}
