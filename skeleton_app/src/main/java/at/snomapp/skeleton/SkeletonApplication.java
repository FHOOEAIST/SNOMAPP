package at.snomapp.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
// ! conflicts with neo4j
// ! removed until bug is fixed (see trello board)
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@SpringBootApplication
// ! conflicts with neo4j
// ! removed until bug is fixed (see trello board)
//@EnableSwagger2WebMvc
@EntityScan(basePackages = "at.snomapp.skeleton.appc")
@EnableNeo4jRepositories(basePackages = "at.snomapp.skeleton.repo")
public class SkeletonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }

}
