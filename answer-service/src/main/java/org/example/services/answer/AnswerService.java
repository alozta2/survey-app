package org.example.services.answer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.example.services.answer.model.Answer;
import org.example.services.answer.repository.AnswerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Answer API", version = "1.0", description = "Documentation Answer API v1.0")
)
public class AnswerService {

    public static void main(String[] args) {
        SpringApplication.run(AnswerService.class, args);
    }

    @Bean
    AnswerRepository repository() {
        AnswerRepository repository = new AnswerRepository();
        repository.add(new Answer(1L, "7,868,872,451"));
        repository.add(new Answer(1L, "5,000,000,000"));
        repository.add(new Answer(1L, "42"));
        repository.add(new Answer(2L, "White"));
        repository.add(new Answer(2L, "White"));
        repository.add(new Answer(2L, "Orange"));
        repository.add(new Answer(2L, "Black"));
        repository.add(new Answer(3L, "2"));
        repository.add(new Answer(3L, "128"));
        repository.add(new Answer(3L, "256"));
        return repository;
    }
}
