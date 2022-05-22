package org.example.services.question;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.example.services.question.model.Question;
import org.example.services.question.repository.QuestionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Question API", version = "1.0", description = "Documentation Question API v1.0")
)
public class QuestionService {

    public static void main(String[] args) {
        SpringApplication.run(QuestionService.class, args);
    }

    @Bean
    QuestionRepository repository() {
        QuestionRepository repository = new QuestionRepository();
        repository.add(new Question("What is the population of the world?"));
        repository.add(new Question("What is the color known as #FFFFFF in hex color palette?"));
        repository.add(new Question("What is character count in ASCII table?"));
        return repository;
    }
}
