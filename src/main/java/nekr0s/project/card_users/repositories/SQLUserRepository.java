package nekr0s.project.card_users.repositories;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.repositories.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SQLUserRepository implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Request> getSpecificUserRequests(int userId) {
        List<Request> requests;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            requests = session.createQuery("from Request where user.userId = :paramId")
                    .setParameter("paramId", userId)
                    .list();
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return requests;
    }

    @Override
    public List<Request> getAllUserRequests() {
        List result;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            result = session.createQuery("From Request").list();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.createQuery("from User").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public User getById(int id) {
        User result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(User.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }


    @Override
    public void update(int id, User user) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            User userToChange = session.get(User.class, id);

            userToChange.setEmail(user.getEmail());
            userToChange.setPassword(user.getPassword());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
