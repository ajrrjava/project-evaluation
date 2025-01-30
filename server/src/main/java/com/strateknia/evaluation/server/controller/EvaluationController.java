package com.strateknia.evaluation.server.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.strateknia.evaluation.common.entity.*;
import com.strateknia.evaluation.rules.DroolsEngine;
import com.strateknia.evaluation.server.repository.CriteriaRepository;
import com.strateknia.evaluation.server.repository.FactsRepository;
import com.strateknia.evaluation.server.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class EvaluationController {

    @Autowired
    private ProjectRepository repository;

    @Autowired
    private FactsRepository factsRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private DroolsEngine engine;

    @PostMapping("/evaluate")
    public ResponseEntity<Determination> add(@RequestBody Project project) {
        log.info("Evaluating project: {}", project);

        Optional<Criteria> criteria = criteriaRepository.findByTypeAndIndustry(project.getType(), project.getIndustry());

        if(criteria.isEmpty()) {
            String error = String.format("Unable to find evaluation criteria for project type %d and industry %s",
                    project.getType(), project.getIndustry());
            Determination determination = Determination.builder().error(error).build();
            return ResponseEntity.internalServerError().body(determination);
        }

        Determination determination = engine.evaluate(project, criteria.get());

        log.info("Determination for project {} emitted", project.getProjectName());

        return ResponseEntity.ok().body(determination);
    }

    @PutMapping("/evaluate")
    public ResponseEntity<Project> update(@RequestBody Project project) {
        log.info("Updating project: {}", project);

        Project p = repository.save(project);

        return ResponseEntity.ok().body(p);
    }

    @DeleteMapping("/evaluate/{id}")
    public ResponseEntity<Project> delete(@PathVariable UUID id) {
        log.info("Deleting project with id: {}", id);

        repository.delete(Project.builder().id(id).build());

        return ResponseEntity.ok().build();
    }

}
