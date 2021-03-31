package uz.pdp.appdatarest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appdatarest.dto.Result;
import uz.pdp.appdatarest.dto.response.ResponseAttachment;
import uz.pdp.appdatarest.entity.Attachment;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public interface AttachmentService {

    Result upload(MultipartHttpServletRequest request);

    List<Attachment> findAll();

    ResponseAttachment findOne(Integer id, HttpServletResponse response);

    Result delete(Integer id);

}
