package org.example.services.answer.model;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private Long id;

    private String value;

    private List<Answer> answers = new ArrayList<>();

    public Question() {

    }

    public Question(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", value=" + value + "]";
    }
}
