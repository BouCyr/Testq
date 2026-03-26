package com.example.testq.service.lessons;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DocumentService {

    private final String uploadDir = "path/to/upload/directory"; // Adjust the path accordingly

    // Method to handle document upload
    public String uploadDocument(MultipartFile file) throws IOException {
        Path path = Paths.get(uploadDir, file.getOriginalFilename());
        Files.copy(file.getInputStream(), path);
        return "Document uploaded successfully: " + path.toString();
    }

    // Method to extract content from a document (for example, PDF, DOCX, etc.)
    public String extractDocumentContent(String filePath) throws IOException {
        // Implementation for extracting content based on document type
        // This is just a placeholder
        return "Extracted content from: " + filePath;
    }

    // Method to remove a document
    public String removeDocument(String fileName) throws IOException {
        Path path = Paths.get(uploadDir, fileName);
        Files.deleteIfExists(path);
        return "Document removed successfully: " + fileName;
    }
}
