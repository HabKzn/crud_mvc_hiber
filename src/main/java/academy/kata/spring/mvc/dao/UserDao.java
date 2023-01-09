package academy.kata.spring.mvc.dao;

import academy.kata.spring.mvc.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void deleteUser(int id);

    void saveUser(User user);

    User getUser(int id);
}
