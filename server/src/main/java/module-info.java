module server.module {
    requires jakarta.persistence;
    requires static lombok;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.security.config;
    requires spring.security.core;
    requires spring.security.web;
    requires spring.web;
    requires org.slf4j;

    requires common.module;
    requires rules.module;
    requires com.fasterxml.jackson.databind;
}