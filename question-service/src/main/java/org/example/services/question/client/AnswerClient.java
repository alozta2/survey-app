package org.example.services.question.client;

import org.example.services.question.model.Answer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "answer-service")
public interface AnswerClient {

    @GetMapping("/question/{questionId}")
    List<Answer> findByQuestion(@PathVariable("questionId") Long questionId);
}
