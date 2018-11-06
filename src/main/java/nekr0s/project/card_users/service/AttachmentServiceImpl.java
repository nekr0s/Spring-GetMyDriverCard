package nekr0s.project.card_users.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javassist.NotFoundException;
import nekr0s.project.card_users.models.Attachment;
import nekr0s.project.card_users.repositories.AttachmentRepository;
import nekr0s.project.card_users.service.base.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


    @Override
    public Attachment add(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment getById(int attachmentId) throws NotFoundException {
        Optional<Attachment> attachment = attachmentRepository.findById(attachmentId);
        if (attachment.isPresent()) return attachment.get();
        else throw new NotFoundException("Attachment not found.");
    }

    @Override
    public List<Attachment> getAll() {
        return attachmentRepository.findAll();
    }
}
