package nekr0s.project.card_users.repositories;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.repositories.base.RequestRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SQLRequestRepository implements RequestRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Request getRequestById(int id) {
        Request request;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            request = session.get(Request.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return request;
    }

    @Override
    public List<Request> getUserRequests(int userId) {
        List<Request> requests;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            requests = session.createQuery("from Request where user.userId = :paramId")
                    .setParameter("paramId", userId)
                    .list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return requests;
    }

    @Override
    public List<Request> getAllRequests() {
        List result;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("From Request").list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void updateRequestStatus(int requestId, int requestStatus) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Request requestToChange = session.get(Request.class, requestId);
            requestToChange.setRequestStatus(requestStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
