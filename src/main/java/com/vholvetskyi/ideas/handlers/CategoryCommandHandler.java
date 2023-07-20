package com.vholvetskyi.ideas.handlers;

import com.vholvetskyi.ideas.dao.CategoryDao;
import com.vholvetskyi.ideas.input.UserInputCommand;
import com.vholvetskyi.ideas.model.Category;

import java.util.List;

public class CategoryCommandHandler extends BaseCommandHandler {

    private static final String COMMAND_NAME = "category";

    private CategoryDao categoryDao;

    public CategoryCommandHandler() {
        this.categoryDao = new CategoryDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        switch (command.getAction()) {
            case "list":
                System.out.println("List of categories...");
                List<Category> categories = categoryDao.findAll();
                categories.forEach(System.out::println);
                break;

            case "add":
                System.out.println("Add category");
                String categoryName = command.getParam().get(0);
                categoryDao.add(new Category(categoryName));
                break;

            default: {
                throw new IllegalArgumentException(
                        String.format("Unknown action: %s from command: %s",
                                command.getAction(), command.getCommand()));
            }
        }

    }
}
