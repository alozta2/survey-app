package org.example.services.question.controller;

import org.example.services.question.client.AnswerClient;
import org.example.services.question.dto.EditDto;
import org.example.services.question.model.Question;
import org.example.services.question.repository.QuestionRepository;
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
import java.util.Map;

@RestController
public class QuestionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionRepository repository;

    @Autowired
    AnswerClient answerClient;

    @PostMapping
    public Question add(@RequestBody Question question) {
        LOGGER.info("Question add {}", question);
        return repository.add(question);
    }

    @PostMapping("/{id}")
    public Question edit(@PathVariable("id") Long id, @RequestBody EditDto editDto) {
        LOGGER.info("Question id {} edit {}", id, editDto.getNewValue());
        return repository.edit(id, editDto);
    }

    @DeleteMapping("/{id}")
    public Question delete(@PathVariable("id") Long id) {
        LOGGER.info("Question id {} delete {}", id);
        return repository.delete(id);
    }

    @GetMapping
    public List<Question> findAll() {
        LOGGER.info("Questions find all");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable("id") Long id) {
        LOGGER.info("Question find by id {}", id);
        return repository.findById(id);
    }

    @GetMapping("/{id}/with-answers")
    public Question findByIdWithAnswers(@PathVariable("id") Long id) {
        LOGGER.info("Question find id {} with answers", id);
        Question question = repository.findById(id);
        question.setAnswers(answerClient.findByQuestion(question.getId()));
        return question;
    }

    @GetMapping("/distribution-map")
    public Map<String, Map<String, Long>> getDistributionMap() {
        LOGGER.info("Calculating distribution map");
        return repository.calculateDistributionMap();
    }
}
