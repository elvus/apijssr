package com.jsr.api.repository;

import java.util.List;
import com.jsr.api.model.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentRepository extends JpaRepository<Document, Long>{
    @Query(name = "Document.GenerateDocument")
    public List<Document> GenerateDocument(String timbrado, String fecha_inicio, String fecha_fin);
}
