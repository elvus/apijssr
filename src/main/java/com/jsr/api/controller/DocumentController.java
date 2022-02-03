package com.jsr.api.controller;

import java.io.Console;
import java.util.List;
import java.util.Map;

import com.jsr.api.model.Document;
import com.jsr.api.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value = "/document", method = RequestMethod.POST)
    public List<Document> getDocument(@RequestBody Map<String, String> params){
        return documentRepository.GenerateDocument(params.get("fecha_inicio").toString(), params.get("fecha_fin").toString());
    }
    
}
