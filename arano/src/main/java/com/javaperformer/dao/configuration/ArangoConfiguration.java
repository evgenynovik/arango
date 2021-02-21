package com.javaperformer.dao.configuration;

import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;

@Configuration
@EnableArangoRepositories(basePackages = "com.javaperformer.dao")
public class ArangoConfiguration extends AbstractArangoConfiguration {

    @Value("${arango.host}")
    private String host;
    @Value("${arango.port}")
    private int port;
    @Value("${arango.password}")
    private String password;
    @Value("${arango.user}")
    private String user;
    @Value("${arango.database}")
    private String database;

    @Override
    public Builder arango() {
        return new ArangoDB.Builder()
                .host(host, port)
                .password(password)
                .user(user);
    }

    @Override
    public String database() {
        return database;
    }
}
