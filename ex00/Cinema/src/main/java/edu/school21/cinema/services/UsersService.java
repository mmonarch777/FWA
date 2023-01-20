package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class UsersService {
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean saveUser(HttpServletRequest request) {
        return usersRepository.saveUser(request);
    }

    public Optional<User> findUser(HttpServletRequest request) {
        return usersRepository.findUser(request);
    }
}
