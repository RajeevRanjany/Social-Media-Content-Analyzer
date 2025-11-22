package SocialMediaAnalyser.SocailMedia.service;

import org.springframework.stereotype.Service;

@Service
public class SuggestionService {

    public String getSuggestions(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "No text detected. Please try with a clearer document or image.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Engagement Suggestions:\n");

        int wordCount = text.split("\\s+").length;


        if (wordCount < 20) {
            sb.append("- Content is quite short. Add a bit more context or details.\n");
        } else if (wordCount > 200) {
            sb.append("- Content is long. Try making it more concise for better readability.\n");
        }


        if (!text.matches(".*[🤩🔥✨💯❤️😎].*")) {
            sb.append("🤩🔥✨💯❤️😎].\n");
        }

        if (!text.contains("#")) {
            sb.append("✨we can add here hashtags (e.g. #travel, #fitness, #coding).\n");
        }

        if (!text.toLowerCase().matches(".*(follow|check|subscribe|share|visit|learn more|link in bio).*")) {
            sb.append("“Follow for more”, “Check the link in bio”).\n");
        }

        if (!text.contains("?")) {
            sb.append("(e.g., “What do you think?”).\n");
        }

        String result = sb.toString();
        if (result.equals("Engagement Suggestions:\n")) {
            return "Looks good! Your post already has good engagement elements";
        }
        return result;
    }
}
