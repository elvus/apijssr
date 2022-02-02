package com.jsr.api.controller;

import java.util.List;

import com.jsr.api.model.Document;
import com.jsr.api.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping("/document")
    public List<Document> getDocument(){
        return documentRepository.GenerateDocument();
    }
    
}
