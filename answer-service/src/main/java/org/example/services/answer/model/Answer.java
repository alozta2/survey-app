package org.example.services.answer.model;

public class Answer {

    private Long id;
    
    private Long questionId;
    
    private String value;
    

    public Answer() {

    }

    public Answer(Long questionId, String value) {
        super();
        this.questionId = questionId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", questionId=" + questionId + ", value=" + value + "]";
    }
}
