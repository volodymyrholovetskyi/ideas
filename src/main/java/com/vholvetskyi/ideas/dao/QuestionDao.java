package com.vholvetskyi.ideas.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vholvetskyi.ideas.model.Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class QuestionDao {

    private ObjectMapper objectMapper;

    public QuestionDao() {
        this.objectMapper = new ObjectMapper();
    }

    private static final Path QUESTIONS_FILE = Paths.get("./questions.txt");

    public List<Question> findAll() {
        return getQuestions();
    }

    private List<Question> getQuestions() {
        try {
            return objectMapper.readValue(Files.readString(QUESTIONS_FILE), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(Question question) {
        try {
            List<Question> questions = getQuestions();
            questions.add(question);
            String jsonValue = objectMapper.writeValueAsString(questions);
            Files.writeString(QUESTIONS_FILE, jsonValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
