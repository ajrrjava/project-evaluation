package com.strateknia.evaluation.server.repository;

import com.strateknia.evaluation.common.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Project> {

}
