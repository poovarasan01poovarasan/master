package pdf.pdf_format.service.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.stereotype.Service;
import pdf.pdf_format.service.PdfService;

import java.io.File;
import java.io.IOException;

@Service
public class imgpdf  {
   // @Override
    public void imgpdf() throws IOException {
        // Custom page width and height
        float pageWidth = 200;
        float pageHeight =300;

        // Loading an existing document
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(pageWidth, pageHeight));
        doc.addPage(page);

        // Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile("C:\\Users\\Karthick Raja\\Pictures\\Image\\images1.png", doc);
        double  imageWidth=pdImage.getWidth() * 0.5f;
        double imageHeight = pdImage.getHeight() * 0.5f;
        // Calculate image width and height based on the aspect ratio
        double aspectRatio = imageWidth / imageHeight;
        if (pageWidth / aspectRatio <= pageHeight) {
            imageWidth = pageWidth;
            imageHeight = imageWidth / aspectRatio;
        } else {
            imageHeight = pageHeight;
            imageWidth = imageHeight * aspectRatio;
        }

        double x = (pageWidth - imageWidth) / 2;
        double y = (pageHeight - imageHeight) / 2;


        // Creating the PDPageContentStream object
        try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
            // Drawing the image in the PDF document
            contents.drawImage(pdImage,pageWidth/3, (float) (pageHeight-(imageHeight/2)), (float) imageWidth/2, (float) imageHeight/2);
            System.out.println("Image inserted");
        }

        // Saving the document
        doc.save("D:\\New folder\\java_pro\\java_file\\bail.pdf");

        // Closing the document
        doc.close();
    }
}
