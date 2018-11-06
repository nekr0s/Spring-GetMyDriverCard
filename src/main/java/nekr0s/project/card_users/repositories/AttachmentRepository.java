package nekr0s.project.card_users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nekr0s.project.card_users.models.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
