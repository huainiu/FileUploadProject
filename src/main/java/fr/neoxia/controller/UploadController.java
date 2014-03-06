package fr.neoxia.controller;

/**
 * Created by marwa on 14/02/2014.
 */

import fr.neoxia.model.UploadedFile;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {




      attachmentFile attachmentFile = new attachmentFile();

    @RequestMapping("/fileUploadForm")
    public ModelAndView getUploadForm(
            @ModelAttribute("uploadedFile") UploadedFile uploadedFile,
            BindingResult result) {
        return new ModelAndView("uploadForm");
    }

    @RequestMapping("/fileUpload")
    public ModelAndView fileUploaded(
            @ModelAttribute("uploadedFile") UploadedFile uploadedFile,
            BindingResult result) throws Exception {

        MultipartFile file = uploadedFile.getFile();


        String fileName = file.getOriginalFilename();

        if (result.hasErrors()) {
            return new ModelAndView("uploadForm");
        }

        attachmentFile.setupNode();
        attachmentFile.mapperAttachment(file);



        return new ModelAndView("showFile", "message", fileName);
    }

    @RequestMapping("/home")
    public ModelAndView getHome()
          {
ModelAndView model = new ModelAndView("home");
        return model ;
    }
}

