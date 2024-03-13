package pdf.pdf_format.service.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;
import pdf.pdf_format.service.PdfService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class moster {

    public void createPdf() throws IOException {
        try (PDDocument document = new PDDocument()) {
            // Set custom page size (width and height in points)
            float pageWidth = 500;
            float pageHeight = 700;
            PDRectangle pageSize = new PDRectangle(pageWidth, pageHeight);
            PDPage page = new PDPage(pageSize);
            document.addPage(page);

            PDFont font = PDType1Font.HELVETICA;
            int fontSize = 12;
            float leading = 1.5f * fontSize;

            PDImageXObject pdImage = PDImageXObject.createFromFile("C:\\Users\\Karthick Raja\\Pictures\\Image\\images1.png", document);

            PDPageContentStream contentStream = new PDPageContentStream(document,page);
            contentStream.drawImage(pdImage, 70, 250);
            contentStream.close();

            String[] paragraphs = {
                    "Forests are made up of a large number of trees grouped together in one location. It helps in the maintenance of oxygen levels since they are a rich source of oxygen that absorbs carbon dioxide exhaled by everyone and helps to sustain the environment.",
                    "Forests aid in the preservation of a pure and clean environment, which we all desire. Forests also aid in the maintenance of the ecology and biodiversity, as well as the evaporation and condensation processes. Forests are important to both humans and animals for a variety of reasons.",
                    "Humans depend on forests for medicines, food, wood, and other necessities, and all wild creatures rely on them for survival and habitat. With today’s expanding human demands, we have been cutting down a lot of trees, which has resulted in the environment becoming depleted.",
                    "Deforestation has resulted in numerous environmental hazards, including global warming, pollution, ozone layer depletion, and so on. It is critical to recognise the value of forests in our lives and to fight to ensure their protection. Depending on the various climatic conditions, the forests exist in various forms like deciduous forests, tropical evergreen forests, etc.",
                    "but they all play a major role in maintaining the ecosystem. With the increasing demands and needs of human beings, the forests are being cut down hence leading to various hazards to the environment. Deforestation has led to a major threat called global warming.Now it is high time for humans to stop cutting down trees and depleting the habitats of animals.",
                    "Forests are made up of a large number of trees grouped together in one location. It helps in the maintenance of oxygen levels since they are a rich source of oxygen that absorbs carbon dioxide exhaled by everyone and helps to sustain the environment.",
                    "Forests aid in the preservation of a pure and clean environment, which we all desire. Forests also aid in the maintenance of the ecology and biodiversity, as well as the evaporation and condensation processes. Forests are important to both humans and animals for a variety of reasons.",
                    "Humans depend on forests for medicines, food, wood, and other necessities, and all wild creatures rely on them for survival and habitat. With today’s expanding human demands, we have been cutting down a lot of trees, which has resulted in the environment becoming depleted.",
                    "Deforestation has resulted in numerous environmental hazards, including global warming, pollution, ozone layer depletion, and so on. It is critical to recognise the value of forests in our lives and to fight to ensure their protection. Depending on the various climatic conditions, the forests exist in various forms like deciduous forests, tropical evergreen forests, etc.",
                    "but they all play a major role in maintaining the ecosystem. With the increasing demands and needs of human beings, the forests are being cut down hence leading to various hazards to the environment. Deforestation has led to a major threat called global warming.Now it is high time for humans to stop cutting down trees and depleting the habitats of animals.",
                    "Forests are made up of a large number of trees grouped together in one location. It helps in the maintenance of oxygen levels since they are a rich source of oxygen that absorbs carbon dioxide exhaled by everyone and helps to sustain the environment.",
                    "Forests aid in the preservation of a pure and clean environment, which we all desire. Forests also aid in the maintenance of the ecology and biodiversity, as well as the evaporation and condensation processes. Forests are important to both humans and animals for a variety of reasons.",
                    "Humans depend on forests for medicines, food, wood, and other necessities, and all wild creatures rely on them for survival and habitat. With today’s expanding human demands, we have been cutting down a lot of trees, which has resulted in the environment becoming depleted.",
                    "Deforestation has resulted in numerous environmental hazards, including global warming, pollution, ozone layer depletion, and so on. It is critical to recognise the value of forests in our lives and to fight to ensure their protection. Depending on the various climatic conditions, the forests exist in various forms like deciduous forests, tropical evergreen forests, etc.",
                    "but they all play a major role in maintaining the ecosystem. With the increasing demands and needs of human beings, the forests are being cut down hence leading to various hazards to the environment. Deforestation has led to a major threat called global warming.Now it is high time for humans to stop cutting down trees and depleting the habitats of animals.",
                    "Forests are made up of a large number of trees grouped together in one location. It helps in the maintenance of oxygen levels since they are a rich source of oxygen that absorbs carbon dioxide exhaled by everyone and helps to sustain the environment.",
                    "Forests aid in the preservation of a pure and clean environment, which we all desire. Forests also aid in the maintenance of the ecology and biodiversity, as well as the evaporation and condensation processes. Forests are important to both humans and animals for a variety of reasons.",
                    "Humans depend on forests for medicines, food, wood, and other necessities, and all wild creatures rely on them for survival and habitat. With today’s expanding human demands, we have been cutting down a lot of trees, which has resulted in the environment becoming depleted.",
                    "Deforestation has resulted in numerous environmental hazards, including global warming, pollution, ozone layer depletion, and so on. It is critical to recognise the value of forests in our lives and to fight to ensure their protection. Depending on the various climatic conditions, the forests exist in various forms like deciduous forests, tropical evergreen forests, etc.",
                    "but they all play a major role in maintaining the ecosystem. With the increasing demands and needs of human beings, the forests are being cut down hence leading to various hazards to the environment. Deforestation has led to a major threat called global warming.Now it is high time for humans to stop cutting down trees and depleting the habitats of animals."

            };


            float startY = pageHeight - 50;
            float startX = 50;
            float margin = startX;

            for (String paragraph : paragraphs) {
                List<String> lines = splitTextIntoLines(paragraph, font, fontSize, pageWidth - 2 * margin);
                for (String line : lines) {
                    if (contentStream != null) {
                        contentStream = new PDPageContentStream(document, page);
                        contentStream.setFont(font, fontSize);
                        contentStream.beginText();
                        contentStream.newLineAtOffset(startX, startY);
                    }

                    if (startY <= 50) {
                        contentStream.endText();
                        contentStream.close();
                        page = new PDPage(pageSize);
                        document.addPage(page);
                        startY = pageHeight - 50;
                        contentStream = new PDPageContentStream(document, page);
                        contentStream.setFont(font, fontSize);
                        contentStream.beginText();
                        contentStream.newLineAtOffset(startX, startY);
                    }

                    contentStream.showText(line);
                    startY -= leading;
                    contentStream.newLineAtOffset(0, -leading);
                }
            }

            if (contentStream != null) {
                contentStream.endText();
                contentStream.close();
            }

            document.save("D:\\New folder\\java_pro\\java_file\\bail.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> splitTextIntoLines(String text, PDFont font, int fontSize, float maxWidth) throws IOException {
        List<String> lines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();
        float currentWidth = 0;

        for (String word : text.split("\\s+")) {
            float wordWidth = font.getStringWidth(word) / 1000 * fontSize + font.getStringWidth(" ") / 1000 * fontSize;
            if (currentWidth + wordWidth > maxWidth) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word).append(" ");
                currentWidth = wordWidth;
            } else {
                currentLine.append(word).append(" ");
                currentWidth += wordWidth;
            }
        }

        if (!currentLine.toString().isEmpty()) {
            lines.add(currentLine.toString());
        }

        return lines;
    }
}



