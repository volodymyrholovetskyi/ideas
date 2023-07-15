package com.vholvetskyi.ideas.model;

import java.util.List;

public class Question {
    private String name;

    private Category category;

    private List<Answer> answers;

    public Question(String name, Category category, List<Answer> answers) {
        this.name = name;
        this.category = category;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
