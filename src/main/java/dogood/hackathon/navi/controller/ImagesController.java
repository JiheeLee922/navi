package dogood.hackathon.navi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@AllArgsConstructor
@Slf4j
public class ImagesController {

    @GetMapping(value="/images/{prefix}/{idx}/{fileName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImages(
                @PathVariable String prefix
            ,   @PathVariable String idx
            ,   @PathVariable String fileName
            ,   HttpServletRequest req
    ) throws IOException{
        String rootPath = System.getProperty("user.dir");
        String filePath = rootPath + File.separator + "images" + File.separator + prefix + File.separator + idx + File.separator + fileName;
        try{
            File file = new File(filePath);
            log.info("#### 파일 존재 확인 : {}",file.exists());
        }catch(Exception e){
            log.error(e.getMessage());
        }

        InputStream in = new FileInputStream(filePath);
        byte[] arr = IOUtils.toByteArray(in);
        in.close();
        return arr;
    }
}
