package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Info;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

public class InfoRepositoryImpl implements InfoRepository{
    private JdbcTemplate jdbc;

    public InfoRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public void saveInfo(Integer id, String ip) {
        jdbc.update("insert into info(owner, ip) values (?, ?)", id, ip);
    }

    @Override
    public List<Info> getInfo(Integer id) {
        return jdbc.query("select * from info where owner=?",
                new Object[]{id},
                new int[]{Types.INTEGER},
                new InfoMapper());
    }

    public class InfoMapper implements RowMapper<Info> {
        @Override
        public Info mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Info(resultSet.getTimestamp("date"),
                    resultSet.getString("ip"));
        }
    }
}
