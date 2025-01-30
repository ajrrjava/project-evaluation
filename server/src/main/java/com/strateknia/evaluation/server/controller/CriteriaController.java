package com.strateknia.evaluation.server.controller;

import com.strateknia.evaluation.common.entity.*;
import com.strateknia.evaluation.rules.DroolsEngine;
import com.strateknia.evaluation.server.repository.CriteriaRepository;
import com.strateknia.evaluation.server.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class CriteriaController {

    @Autowired
    private CriteriaRepository repository;

    @PostMapping("/criteria")
    public ResponseEntity<Criteria> post(@RequestBody Criteria criteria) {
        log.info("Adding criteria: {}", criteria);

        Criteria c = repository.save(criteria);

        return ResponseEntity.ok().body(c);
    }

    @PutMapping("/criteria")
    public ResponseEntity<Criteria> put(@RequestBody Criteria criteria) {
        log.info("Updating criteria: {}", criteria);

        Criteria c = repository.save(criteria);

        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/criteria/{id}")
    public ResponseEntity<Criteria> delete(@PathVariable UUID id) {
        log.info("Deleting criteria with id: {}", id);

        repository.deleteById(Criteria.builder().id(id).build());

        return ResponseEntity.ok().build();
    }
}
