package org.example.services.answer.client;

import org.example.services.answer.model.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "question-service")
public interface QuestionClient {

    @GetMapping("/{id}")
    Question findById(@PathVariable("id") Long id);
}
