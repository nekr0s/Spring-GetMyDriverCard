package nekr0s.project.card_users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import nekr0s.project.card_users.models.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> getAllByUserId(int userId);

    Request getByRequestId(int requestId);

    @Modifying
    @Query("update Request r set r.requestStatus = ?1 where r.requestId = ?2")
    void setRequestStatusById(int status, int requestId);
}
