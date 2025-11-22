package SocialMediaAnalyser.SocailMedia.controller;

import SocialMediaAnalyser.SocailMedia.service.OCRService;
import SocialMediaAnalyser.SocailMedia.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private OCRService ocrService;

    @Autowired
    private SuggestionService suggestionService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String extractedText = ocrService.extractText(file);
            String suggestions = suggestionService.getSuggestions(extractedText);

            Map<String, String> response = new HashMap<>();
            response.put("text", extractedText);
            response.put("suggestions", suggestions);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
