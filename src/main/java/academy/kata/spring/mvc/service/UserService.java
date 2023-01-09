package academy.kata.spring.mvc.service;

import academy.kata.spring.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    void delete(int id);

    void save(User user);

    User getUser(Integer id);

    Optional<User> findById(int id);
}
