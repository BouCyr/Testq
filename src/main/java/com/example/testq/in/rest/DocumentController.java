package com.example.testq.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    // Endpoint for document upload
    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("File is empty!", HttpStatus.BAD_REQUEST);
        }
        // Implement logic to save the file
        return new ResponseEntity<>("Document uploaded successfully!", HttpStatus.OK);
    }

    // Endpoint for document removal
    @DeleteMapping("/remove/{documentId}")
    public ResponseEntity<String> removeDocument(@PathVariable String documentId) {
        // Implement logic to remove the document based on the provided documentId
        return new ResponseEntity<>("Document removed successfully!", HttpStatus.OK);
    }
}