package nekr0s.project.card_users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.enums.RequestStatus;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    List<Request> getAllByUserId(int userId);

    Request getByRequestId(int requestId);

    @Modifying
    @Transactional
    @Query("update Request r set r.requestStatus = ?2 where r.requestId = ?1")
    void setRequestStatusById(int requestId, RequestStatus requestStatus);
}
