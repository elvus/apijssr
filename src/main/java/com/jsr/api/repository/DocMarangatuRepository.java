package com.jsr.api.repository;

import java.util.List;

import com.jsr.api.model.DocMarangatu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocMarangatuRepository extends JpaRepository<DocMarangatu, Long> {
    @Query(name = "DocMarangatu.GenerateDocument")
    public List<DocMarangatu> GenerateDocument(String timbrado, String fecha_inicio, String fecha_fin);
}
