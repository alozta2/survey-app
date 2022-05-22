package org.example.services.answer.repository;

import org.example.services.answer.dto.ResponseDto;
import org.example.services.answer.model.Answer;
import org.example.services.answer.model.Question;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepository {

    private List<Answer> answers = new ArrayList<>();

    public Answer add(Answer answer) {
        answer.setId((long) (answers.size()+1));
        answers.add(answer);
        return answer;
    }

    public Answer respondQuestion(Question question, ResponseDto responseDto) {
        if(question == null) {
            return null;
        }

        Answer answer = new Answer(question.getId(), responseDto.getNewValue());
        add(answer);

        return answer;
    }

    public Answer delete(Long id) {
        if(id == null) {
            return null;
        }

        Answer answer = findById(id);
        if(answer != null) {
            answers.remove(answer);
        }
        return answer;
    }

    public Answer findById(Long id) {
        return answers.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Answer> findAll() {
        return answers;
    }

    public List<Answer> findByQuestion(Long questionId) {
        return answers.stream()
                .filter(a -> a.getQuestionId().equals(questionId))
                .toList();
    }
}
