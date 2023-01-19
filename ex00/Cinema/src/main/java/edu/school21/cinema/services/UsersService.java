package edu.school21.cinema.services;

import edu.school21.cinema.repositories.UsersRepository;

import javax.servlet.http.HttpServletRequest;

public class UsersService {
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean saveUser(HttpServletRequest request) {
        return usersRepository.saveUser(request);
    }
}
