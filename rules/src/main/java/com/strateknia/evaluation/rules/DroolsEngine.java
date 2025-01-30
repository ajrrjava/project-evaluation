package com.strateknia.evaluation.rules;

import com.strateknia.evaluation.common.entity.Criteria;
import com.strateknia.evaluation.common.entity.Determination;
import com.strateknia.evaluation.common.entity.Facts;
import com.strateknia.evaluation.common.entity.Project;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;

import java.util.List;
import java.util.Properties;

public class DroolsEngine implements ProjectEvaluationService {

    private KieContainer kieContainer;

    @Override
    public void init() throws Exception {
        KieServices kieServices = KieServices.get();

        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("rules.properties"));

        List<String> rules = List.of(properties.getProperty("rules.drl", "").replace(" ", "").split(","));

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        for (String rule : rules) {
            String rulePath = "com.strateknia.evaluation.rules/" + rule;
            kieFileSystem.write(ResourceFactory.newClassPathResource(rulePath));
        }

        KieBuilder builder = kieServices.newKieBuilder(kieFileSystem);
        builder.buildAll();

        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
    }

    @Override
    public Determination evaluate(Project project, Criteria criteria) {
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();

        Determination determination = Determination.builder().qualification(0).build();
        kieSession.setGlobal("determination", determination);

        kieSession.execute(List.of(project, criteria));

        return (Determination) kieSession.getGlobals().get("determination");
//        return determination;
    }

    @Override
    public Determination evaluate(Project project, List<Criteria> criteria) {
        return null;
    }
}
