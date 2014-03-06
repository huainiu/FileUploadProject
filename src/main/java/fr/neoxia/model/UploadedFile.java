package fr.neoxia.model;

/**
 * Created by marwa on 14/02/2014.
 */
import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {


    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }




}




