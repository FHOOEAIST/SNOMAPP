package at.snomapp.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// ! conflicts with neo4j
// ! removed until bug is fixed (see trello board)
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@SpringBootApplication
// ! conflicts with neo4j
// ! removed until bug is fixed (see trello board)
//@EnableSwagger2WebMvc
@EntityScan(basePackages = "at.snomapp.skeleton.domain")
@EnableNeo4jRepositories(basePackages = "at.snomapp.skeleton.repo")
@Configuration
@EnableWebMvc

public class SkeletonApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/")
                .addResourceLocations("classpath:/templates/");   }

}
