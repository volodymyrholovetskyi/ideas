package com.vholvetskyi.ideas.handlers;

import com.vholvetskyi.ideas.dao.CategoryDao;
import com.vholvetskyi.ideas.dao.QuestionDao;
import com.vholvetskyi.ideas.input.UserInputCommand;
import com.vholvetskyi.ideas.model.Answer;
import com.vholvetskyi.ideas.model.Category;
import com.vholvetskyi.ideas.model.Question;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class AnswerCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(AnswerCommandHandler.class.getName());
    private static final String COMMAND_NAME = "answer";

    private QuestionDao questionDao;
    private CategoryDao categoryDao;

    public AnswerCommandHandler() {
        this.questionDao = new QuestionDao();
        this.categoryDao = new CategoryDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        if (command.getAction() == null) {
            throw new IllegalArgumentException("Action can't be null");
        }
        switch (command.getAction()) {
            case LIST:
                LOG.info("List of answer...");
                if (command.getParam().size() != 1) {
                    throw new IllegalArgumentException("Wrong command format. Check help for more information");
                }
                String questionName = command.getParam().get(0);
                Question question = questionDao.findOne(questionName)
                        .orElseThrow(() -> new IllegalArgumentException("Question not found: " + questionName));
                displayQuestion(question);
                break;

            case ADD:
                LOG.info("Add answer");
                if (command.getParam().size() != 2) {
                    throw new IllegalArgumentException("Wrong command format. Check help for more information");
                }
                questionName = command.getParam().get(0);
                String answerName = command.getParam().get(1);

                question = questionDao.findOne(questionName)
                        .orElseThrow(() -> new IllegalArgumentException("Question not found: " + questionName));
                questionDao.addAnswer(question, new Answer(answerName));
                break;

            default: {
                throw new IllegalArgumentException(
                        String.format("Unknown action: %s from command: %s",
                                command.getAction(), command.getCommand()));
            }
        }
    }

    private void displayQuestion(Question question) {
        LOG.info(question.getName());
        question.getAnswers().forEach(System.out::println);
    }
}
