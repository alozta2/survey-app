package org.example.services.question.repository;


import org.example.services.question.client.AnswerClient;
import org.example.services.question.dto.EditDto;
import org.example.services.question.model.Answer;
import org.example.services.question.model.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionRepository {

    @Autowired
    AnswerClient answerClient;

    private List<Question> questions = new ArrayList<>();

    public Question add(Question question) {
        question.setId((long) (questions.size()+1));
        questions.add(question);
        return question;
    }

    public Question edit(Long id, EditDto editDto) {
        if(id == null || editDto == null || editDto.getNewValue() == null) {
            return null;
        }
        boolean isEdited = false;
        Question editedQuestion = null;
        for(Question q : questions) {
            if(q.getId().equals(id)) {
                q.setValue(editDto.getNewValue());
                editedQuestion = q;
                isEdited = true;
            }
        }
        return isEdited ? editedQuestion : null;
    }

    public Question delete(Long id) {
        if(id == null) {
            return null;
        }

        Question question = findById(id);
        if(question != null) {
            questions.remove(question);
        }
        return question;
    }

    public Question findById(Long id) {
        return questions.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Map<String, Map<String, Long>> calculateDistributionMap() {
        Map<String, Map<String, Long>> distributionMap = new HashMap<>();
        for(Question q : questions) {
            distributionMap.put(q.getValue(), answerClient.findByQuestion(q.getId()).stream()
                    .collect(Collectors.groupingBy(Answer::getValue, Collectors.counting())));
        }
        return distributionMap;
    }

    public List<Question> findAll() {
        return questions;
    }
}
