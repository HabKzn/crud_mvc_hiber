package academy.kata.spring.mvc.service;

import academy.kata.spring.mvc.dao.UserDao;
import academy.kata.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void delete(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void save(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.of(userDao.getUser(id));
    }


}
