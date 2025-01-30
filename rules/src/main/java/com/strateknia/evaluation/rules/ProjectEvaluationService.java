package com.strateknia.evaluation.rules;

import com.strateknia.evaluation.common.entity.Criteria;
import com.strateknia.evaluation.common.entity.Determination;
import com.strateknia.evaluation.common.entity.Project;

import java.util.List;

public interface ProjectEvaluationService {

    void init() throws Exception;

    Determination evaluate(Project project, Criteria criteria);

    Determination evaluate(Project project, List<Criteria> criteria);
}
