package at.snomapp.skeleton.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// sample application demonstrating how to work with Rest endpoints
//@EnableTransactionManagement
//@SpringBootApplication
//@ComponentScan(basePackages = {"at.snomapp.skeleton"})
//@EntityScan(basePackages = {"at.snomapp.skeleton.restservice"})
//@EnableNeo4jRepositories(basePackages = "at.snomapp.skeleton.restservice")
public class AccessingNeo4jDataRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccessingNeo4jDataRestApplication.class, args);
    }
}
