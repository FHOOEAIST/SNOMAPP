package at.snomapp.restservice;

import org.springframework.boot.SpringApplication;

// sample application demonstrating how to work with Rest endpoints
//@EnableTransactionManagement
//@SpringBootApplication
//@ComponentScan(basePackages = {"at.snomapp"})
//@EntityScan(basePackages = {"at.snomapp.restservice"})
//@EnableNeo4jRepositories(basePackages = "at.snomapp.restservice")
public class AccessingNeo4jDataRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccessingNeo4jDataRestApplication.class, args);
    }
}
