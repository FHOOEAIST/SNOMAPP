package at.snomapp.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"at.fhhagenberg.APPC"})
public class SkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }

}
