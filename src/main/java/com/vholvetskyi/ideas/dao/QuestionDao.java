package com.vholvetskyi.ideas.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vholvetskyi.ideas.model.Answer;
import com.vholvetskyi.ideas.model.Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionDao {

    private static Logger LOG = Logger.getLogger(QuestionDao.class.getName());
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
            LOG.log(Level.WARNING, "Error on qetQuestions", e);
            return new ArrayList<>();
        }
    }

    public void add(Question question) {
            List<Question> questions = getQuestions();
            questions.add(question);
            saveQuestions(questions);
    }

    public Optional<Question> findOne(String questionName) {
        return getQuestions().stream()
                .filter(q -> q.getName().equals(questionName))
                .findFirst();
    }

    public void addAnswer(Question question, Answer answer) {
        List<Question> questions = getQuestions();
        for (Question q : questions) {
            if (Objects.equals(q.getName(), question.getName())) {
                q.getAnswers().add(answer);
            }
        }
        saveQuestions(questions);
    }

    private void saveQuestions(List<Question> questions) {
        String jsonValue = null;
        try {
            jsonValue = objectMapper.writeValueAsString(questions);
            Files.writeString(QUESTIONS_FILE, jsonValue);
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on saveQuestion", e);
        }
    }
}
