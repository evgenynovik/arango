package com.javaperformer.dao.configuration;

import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;
import org.springframework.context.annotation.Configuration;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;

@Configuration
@EnableArangoRepositories(basePackages = { "com.javaperformer.dao" })
public class ArangoConfiguration extends AbstractArangoConfiguration {

    @Override
    public Builder arango() {
        return new ArangoDB.Builder()
                .host("192.168.99.100", 8529)
                .password("password")
                .user("root");
    }

    @Override
    public String database() {
        return "network_elements";
    }
}
