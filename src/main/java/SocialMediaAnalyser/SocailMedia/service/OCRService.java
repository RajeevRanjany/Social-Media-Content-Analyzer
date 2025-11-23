package SocialMediaAnalyser.SocailMedia.service;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

@Service
public class OCRService {

    @Value("${tesseract.datapath}")
    private String tessDataPath;

    public String extractText(MultipartFile file) throws Exception {
        String fileType = file.getContentType();

        if (fileType == null) {
            throw new RuntimeException("Invalid file format");
        }

        if (fileType.equals("application/pdf")) {
            return extractFromPDF(file.getInputStream());
        } else if (fileType.startsWith("image/")) {
            return extractFromImage(file);
        } else {
            throw new RuntimeException("Only PDF or Image files are allowed!");
        }
    }

    private String extractFromPDF(InputStream inputStream) throws Exception {
        PDDocument document = PDDocument.load(inputStream);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        document.close();
        return text.trim();
    }

    private String extractFromImage(MultipartFile file) throws Exception {
        BufferedImage image = ImageIO.read(file.getInputStream());
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath);
        tesseract.setLanguage("eng");  // <--- ADD THIS
        return tesseract.doOCR(image).trim();
    }

}