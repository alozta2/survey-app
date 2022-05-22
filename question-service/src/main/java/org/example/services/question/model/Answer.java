package org.example.services.question.model;

public class Answer {

    private Long id;

    private String value;

    public Answer() {

    }

    public Answer(String value) {
        super();
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

    @Override
    public String toString() {
        return "Answer [id=" + id + ", value=" + value + "]";
    }
}
