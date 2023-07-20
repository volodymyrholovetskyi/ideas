package com.vholvetskyi.ideas.handlers;

import com.vholvetskyi.ideas.dao.CategoryDao;
import com.vholvetskyi.ideas.dao.QuestionDao;
import com.vholvetskyi.ideas.input.UserInputCommand;
import com.vholvetskyi.ideas.model.Category;
import com.vholvetskyi.ideas.model.Question;

import java.util.List;
import java.util.Optional;

public class QuestionCommandHandler extends BaseCommandHandler {
    private static final String COMMAND_NAME = "question";

    private QuestionDao questionDao;
    private CategoryDao categoryDao;

    public QuestionCommandHandler() {
        this.questionDao = new QuestionDao();
        this.categoryDao = new CategoryDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        switch (command.getAction()) {
            case LIST:
                System.out.println("List of questions...");
                List<Question> categories = questionDao.findAll();
                categories.forEach(System.out::println);
                break;

            case ADD:
                System.out.println("Add question");
                String categoryName = command.getParam().get(0);
                String questionName = command.getParam().get(1);
                Category category = categoryDao.findOne(categoryName)
                        .orElseThrow(() -> new IllegalArgumentException("Category not found: " + categoryName));
                questionDao.add(new Question(questionName, category));
                break;

            default: {
                throw new IllegalArgumentException(
                        String.format("Unknown action: %s from command: %s",
                                command.getAction(), command.getCommand()));
            }
        }

    }
}
