package com.example.testq.out.llm;

import java.io.IOException;
import java.util.List;
import langchain4j.LLM;
import langchain4j.LLMRequest;
import langchain4j.LLMResponse;

public class DocumentExtractionManager {
    private final LLM llm; // Instance of the LLM API client

    public DocumentExtractionManager(LLM llm) {
        this.llm = llm;
    }

    public LLMResponse extractTextAndMeaningFromImage(String imagePath) throws IOException {
        // Create a request for the LLM API
        LLMRequest request = new LLMRequest();
        request.setInputImage(imagePath);
        // Invoke the LLM API to extract text and meaning
        return llm.call(request);
    }

    public List<String> extractKeywords(String imagePath) throws IOException {
        // Extract keywords using the LLM API
        LLMResponse response = extractTextAndMeaningFromImage(imagePath);
        // Assume the response has method to retrieve keywords
        return response.getKeywords();
    }
}
