package org.example.services.answer.controller;

import org.example.services.answer.client.QuestionClient;
import org.example.services.answer.dto.ResponseDto;
import org.example.services.answer.model.Answer;
import org.example.services.answer.repository.AnswerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerController.class);

    AnswerRepository repository;

    @Autowired
    QuestionClient questionClient;
    
    public AnswerController(AnswerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{id}")
    public Answer respond(@PathVariable("id") Long id, @RequestBody ResponseDto responseDto) {
        LOGGER.info("Answer question id {} {}", id, responseDto.getNewValue());
        return repository.respondQuestion(questionClient.findById(id), responseDto);
    }

    @DeleteMapping("/{id}")
    public Answer delete(@PathVariable("id") Long id) {
        LOGGER.info("Answer id {} delete {}", id);
        return repository.delete(id);
    }

    @GetMapping("/{id}")
    public Answer findById(@PathVariable("id") Long id) {
        LOGGER.info("Answer find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/")
    public List<Answer> findAll() {
        LOGGER.info("Answer find");
        return repository.findAll();
    }

    @GetMapping("/question/{questionId}")
    public List<Answer> findByQuestion(@PathVariable("questionId") Long questionId) {
        LOGGER.info("Answer find: questionId={}", questionId);
        return repository.findByQuestion(questionId);
    }
}
