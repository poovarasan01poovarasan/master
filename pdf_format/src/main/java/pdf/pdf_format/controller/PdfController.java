package pdf.pdf_format.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pdf.pdf_format.service.PdfService;

import java.io.IOException;

@RestController
public class PdfController {
    @Autowired
   private PdfService pdfService;
    @GetMapping("/get")
    public String get() throws IOException {
        pdfService.imgpdf();
        return "hello poovarasan..";
    }
    @GetMapping("/send")
    public String create() throws IOException {
        pdfService.createPdf () ;
        return "hello master..";
    }
}
