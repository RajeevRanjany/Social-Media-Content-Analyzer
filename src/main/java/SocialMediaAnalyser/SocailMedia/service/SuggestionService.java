package SocialMediaAnalyser.SocailMedia.service;

import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SuggestionService {

    @Value("${GEMINI_API_KEY}")
    private String apiKey;

    private final OkHttpClient client = new OkHttpClient();

    public String getSuggestions(String text) throws Exception {

        if (text == null || text.trim().isEmpty()) {
            return "⚠ No text detected. Please upload a clearer document or image.";
        }


        String prompt = "You are a social media optimization assistant. "
                + "Based on the text below, provide ONLY:\n"
                + "1) Best hashtags (short, relevant)\n"
                + "2) Emojis for better engagement\n"
                + "3) A rewritten catchy & short caption\n"
                + "4) A strong call-to-action line\n\n"
                + "Return response clearly formatted with line breaks.\n\n"
                + "Text:\n" + text;


        MediaType mediaType = MediaType.parse("application/json");
        String requestBodyText =
                "{ \"contents\": [{ \"role\": \"user\", \"parts\": [{ \"text\": \"" +
                        prompt.replace("\"", "\\\"") + "\" }] }] }";

        RequestBody requestBody = RequestBody.create(requestBodyText, mediaType);


        Request request = new Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=" + apiKey)
                .post(requestBody)
                .header("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();

        if (!response.isSuccessful()) {
            return "🚨 Error from AI: " + jsonResponse;
        }


        try {
            JSONObject obj = new JSONObject(jsonResponse);
            String extracted = obj
                    .getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");

            return extracted.trim();

        } catch (Exception e) {
            return "AI Response Parsing Error. Raw:\n" + jsonResponse;
        }
    }
}
