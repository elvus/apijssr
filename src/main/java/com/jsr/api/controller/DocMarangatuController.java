package com.jsr.api.controller;

import java.util.List;
import java.util.Map;

import com.jsr.api.model.DocMarangatu;
import com.jsr.api.repository.DocMarangatuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DocMarangatuController {
    @Autowired
    private DocMarangatuRepository repository;

    @RequestMapping("/marangatu")
    public List<DocMarangatu> getDocument(@RequestBody Map<String, String> params){
        return repository.GenerateDocument(params.get("timbrado").toString(), params.get("fecha_inicio").toString(), params.get("fecha_fin").toString());
    }
}
