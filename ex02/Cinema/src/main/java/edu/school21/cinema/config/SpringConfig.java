package edu.school21.cinema.config;


import edu.school21.cinema.repositories.*;
import edu.school21.cinema.services.ImagesService;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${storage.path}")
    private String path;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UsersRepository usersRepository() {
        return new UsersRepositoryImpl(jdbcTemplate(), encoder(), infoRepository());
    }

    @Bean
    public InfoRepository infoRepository() {
        return new InfoRepositoryImpl(jdbcTemplate());
    }

    @Bean
    public UsersService usersService() {
        return new UsersService(usersRepository());
    }

    @Bean
    public ImageRepository imageRepository() {
        return new ImageRepositoryImpl(jdbcTemplate());
    }

    @Bean
    public ImagesService imagesService() {
        return new ImagesService(imageRepository());
    }
    @Bean
    public String path() {
        return this.path;
    }

}
