module rules.module {
    requires common.module;
    requires org.kie.api;
    requires org.kie.internal.api;
    requires jakarta.persistence;
    requires com.fasterxml.jackson.annotation;

    exports com.strateknia.evaluation.rules;
}