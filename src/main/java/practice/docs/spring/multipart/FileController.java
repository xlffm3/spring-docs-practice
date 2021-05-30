package practice.docs.spring.multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    ResourceLoader resourceLoader;

    @PostMapping("/file")
    public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile) {
        return multipartFile.getContentType();
    }

    @GetMapping("/file/{fileName}")
    public ResponseEntity<Resource> fileDownload(@PathVariable String fileName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        File file = resource.getFile();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" +
                        resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()))
                .body(resource);
    }
}
