package academy.kata.spring.mvc.dao;

import academy.kata.spring.mvc.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u from User u").getResultList();
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.createQuery("DELETE FROM User WHERE id = :userId").setParameter("userId", userId).executeUpdate();
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class, userId);
    }
}
