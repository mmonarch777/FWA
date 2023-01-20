package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UsersRepository {
    Optional<User> findUser(HttpServletRequest request);

    boolean saveUser(HttpServletRequest request);

}
