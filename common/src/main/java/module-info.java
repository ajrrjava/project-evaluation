module common.module {
    requires jakarta.persistence;
    requires static lombok;
    requires com.fasterxml.jackson.annotation;

    exports com.strateknia.evaluation.common.entity;
}