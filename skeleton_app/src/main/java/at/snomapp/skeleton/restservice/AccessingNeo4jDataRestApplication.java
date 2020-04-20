package at.snomapp.skeleton.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EntityScan(basePackages = {"at.snomapp.skeleton.APPC"})
@EnableNeo4jRepositories(basePackages = "at.snomapp.skeleton.repo")
public class AccessingNeo4jDataRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccessingNeo4jDataRestApplication.class, args);
    }
}
