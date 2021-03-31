package uz.pdp.appdatarest.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appdatarest.dto.Result;
import uz.pdp.appdatarest.dto.response.ResponseAttachment;
import uz.pdp.appdatarest.entity.Attachment;
import uz.pdp.appdatarest.entity.AttachmentContent;
import uz.pdp.appdatarest.repository.AttachmentContentRepository;
import uz.pdp.appdatarest.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    final AttachmentRepository attachmentRepository;
    final AttachmentContentRepository attachmentContentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository,
                                 AttachmentContentRepository attachmentContentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentContentRepository = attachmentContentRepository;
    }

    @SneakyThrows
    @Override
    public Result upload(MultipartHttpServletRequest request) {

        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        Attachment attachment = new Attachment();
        if (file != null) {
            attachment.setName(file.getOriginalFilename());
            attachment.setSize(file.getSize());
            attachment.setContentType(file.getContentType());

            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setAttachment(savedAttachment);
            attachmentContent.setBytes(file.getBytes());

            attachmentContentRepository.save(attachmentContent);
            return new Result("File saqlandi!", true, savedAttachment.getId());
        }

        return new Result("File yuklanmadi!", false);
    }

    @Override
    public List<Attachment> findAll() {
        return attachmentRepository.findAll();
    }

    @SneakyThrows
    @Override
    public ResponseAttachment findOne(Integer id, HttpServletResponse response) {
        ResponseAttachment responseAttachment = new ResponseAttachment();

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findAttachmentContentByAttachmentId(attachment.getId());
            if (optionalAttachmentContent.isPresent()) {
                AttachmentContent attachmentContent = optionalAttachmentContent.get();

                response.setHeader("Content-Disposition",
                        "attachment; filename=\"" + attachment.getName() + "\"");
                response.setContentType(attachment.getContentType());
                //FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());

                responseAttachment.setName(optionalAttachment.get().getName());
                responseAttachment.setSize(optionalAttachment.get().getSize());
                responseAttachment.setContentType(optionalAttachment.get().getContentType());
                responseAttachment.setMainContent(optionalAttachmentContent.get().getBytes());

                return responseAttachment;
            }
        }
        return null;
    }


    @Override
    public Result delete(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {

            attachmentRepository.deleteById(id);
            attachmentContentRepository.deleteAllByAttachment_Id(id);
            return new Result("Maxsulot rasmi o'chirildi!", true);
        }
        return new Result("Bunday rasm topilmadi!", false);
    }
}
