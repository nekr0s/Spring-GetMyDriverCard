package nekr0s.project.card_users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import nekr0s.project.card_users.models.Attachment;
import nekr0s.project.card_users.service.base.AttachmentService;

@RestController
@RequestMapping("api/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping
    @ResponseBody
    public Attachment submitAttachment(@RequestBody Attachment attachment) {
        return attachmentService.add(attachment);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public List<Attachment> getAll() {
        return attachmentService.getAll();
    }
}