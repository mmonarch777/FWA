package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class UsersRepositoryImpl implements UsersRepository{

    private final JdbcTemplate jdbc;
    private final  PasswordEncoder encoder;
    public UsersRepositoryImpl(JdbcTemplate jdbc, PasswordEncoder encoder) {
        this.jdbc = jdbc;
        this.encoder = encoder;
    }

    @Override
    public boolean saveUser(HttpServletRequest request) {
        AtomicBoolean checkUser = new AtomicBoolean(false);

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        if (name.isEmpty() || surname.isEmpty() || !StringUtils.isNumeric(phone) || password.isEmpty()) {
            return false;
        }
        getAllUsers().forEach(user -> {
            if (user.getName().equals(name) && user.getSurname().equals(surname) && user.getPhone().equals(phone)) {
                checkUser.set(true);
            }
        });

        if (!checkUser.get()) {
            jdbc.update("insert into users(name, surname, phone, password) values(?, ?, ?, ?)",
                    name,
                    surname,
                    phone,
                    encoder.encode(password));
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return jdbc.query("select * from users", new PersonMapper());
    }

    public class PersonMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("phone"),
                    resultSet.getString("password")
            );
        }
    }
}
