package com.strateknia.evaluation.server.repository;

import com.strateknia.evaluation.common.entity.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Criteria> {

    Optional<Criteria> findByTypeAndIndustry(Integer type, String industry);
}
