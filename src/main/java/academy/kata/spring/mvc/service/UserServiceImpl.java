package academy.kata.spring.mvc.service;

import academy.kata.spring.mvc.dao.UserDao;
import academy.kata.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.saveUser(user);
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.of(userDao.getUser(id));
    }
}
