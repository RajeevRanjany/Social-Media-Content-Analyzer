package SocialMediaAnalyser.SocailMedia.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    @Value("${GEMINI_API_KEY}")
    private String apiKey;

    private final OkHttpClient client = new OkHttpClient();

    public String getSuggestions(String text) throws Exception {

        String prompt = "You are a social media optimization assistant. "
                + "Analyze the following text and provide: "
                + "1) Relevant, short hashtags "
                + "2) Emojis for better engagement "
                + "3) A rewritten short and catchy caption "
                + "4) A powerful call-to-action "
                + "\n\nContent:\n" + text;

        MediaType mediaType = MediaType.parse("application/json");
        String requestBodyText = "{"
                + "\"contents\":[{\"parts\":[{\"text\":\"" + prompt.replace("\"", "\\\"") + "\"}]}]"
                + "}";

        RequestBody requestBody = RequestBody.create(requestBodyText, mediaType);

        Request request = new Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey)
                .post(requestBody)
                .header("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            return "Error from AI: " + response.body().string();
        }

        return response.body().string();
    }
}
