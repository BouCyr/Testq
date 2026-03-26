package com.example.testq.out.llm;

import java.util.List;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

public class QuizGenerationManager {

    private static final String LLM_API_URL = "https://api.example.com/generateQuiz"; // Replace with actual LLM API URL
    private String apiKey;

    public QuizGenerationManager(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<String> generateQuizQuestions(String lessonContent) throws IOException {
        JSONArray questionsArray = callLLMApi(lessonContent);
        List<String> questions = new ArrayList<>();

        for (int i = 0; i < questionsArray.length(); i++) {
            questions.add(questionsArray.getString(i));
        }

        return questions;
    }

    private JSONArray callLLMApi(String lessonContent) throws IOException {
        URL url = new URL(LLM_API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setDoOutput(true);

        JSONObject requestJson = new JSONObject();
        requestJson.put("lessonContent", lessonContent);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(requestJson.toString().getBytes());
            os.flush();
        }

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            return new JSONArray(response.toString());
        } else {
            throw new IOException("Failed to call LLM API: " + conn.getResponseMessage());
        }
    }
}