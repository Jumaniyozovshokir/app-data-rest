package uz.pdp.appdatarest.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appdatarest.dto.Result;
import uz.pdp.appdatarest.dto.response.ResponseAttachment;
import uz.pdp.appdatarest.entity.Attachment;
import uz.pdp.appdatarest.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request) {
        return attachmentService.upload(request);
    }

    @GetMapping
    public List<Attachment> getAll() {
        return attachmentService.findAll();
    }

    @GetMapping("/download/{id}")
    public ResponseAttachment getOne(@PathVariable Integer id, HttpServletResponse response) {
        return attachmentService.findOne(id, response);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return attachmentService.delete(id);
    }

}
