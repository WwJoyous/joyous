package com.whc.pdf.ctrl;

import com.whc.pdf.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: whc
 * @Description:
 * @Date: Create in 11:14 2017/11/7
 */
@RestController
public class PdfCtrl {

    @Autowired
    private PdfService pdfService;

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }

        try {
            return pdfService.upload(file.getBytes(), null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
