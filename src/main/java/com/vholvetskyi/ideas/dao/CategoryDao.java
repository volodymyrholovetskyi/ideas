package com.vholvetskyi.ideas.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vholvetskyi.ideas.model.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDao {

    private static Logger LOG = Logger.getLogger(CategoryDao.class.getName());
    private static final Path CATEGORIES_TXT = Paths.get("./categories.txt");

    private ObjectMapper objectMapper;

    public CategoryDao() {
        this.objectMapper = new ObjectMapper();
    }

    private List<Category> getCategories() {
        try {
            return objectMapper.readValue(Files.readString(CATEGORIES_TXT),
                    new TypeReference<>() {
            });
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on qetCategories", e);
            return new ArrayList<>();
        }
    }

    public List<Category> findAll() {
        return getCategories();
    }

    public void add(Category category) {
        try {
            List<Category> categories = getCategories();
            categories.add(category);
            String jsonValue = objectMapper.writeValueAsString(categories);
            Files.writeString(CATEGORIES_TXT, jsonValue);
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addCategory", e);
        }
    }

    public Optional<Category> findOne(String categoryName) {
        return getCategories()
                .stream()
                .filter(c -> c.getName().equals(categoryName))
                .findFirst();
    }
}
