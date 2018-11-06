package nekr0s.project.card_users.service.base;

import java.util.List;

import javassist.NotFoundException;
import nekr0s.project.card_users.models.Attachment;

public interface AttachmentService {
    Attachment add(Attachment attachment);

    Attachment getById(int attachmentId) throws NotFoundException;

    List<Attachment> getAll();
}
