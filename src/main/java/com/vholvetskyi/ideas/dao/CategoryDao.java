package com.vholvetskyi.ideas.dao;

import com.vholvetskyi.ideas.model.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDao {

    private static final Path CATEGORIES_TXT = Paths.get("./categories.txt");

    public List findAll() {
        try {
            List<String> lines = Files.readAllLines(CATEGORIES_TXT);
            List<Category> categories = new ArrayList<>();
            for (String line : lines) {
                categories.add(new Category(line));
            }
            return categories;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void add(Category category) {
        try {
            List<String> lines = Files.readAllLines(CATEGORIES_TXT);
            lines.add(category.getName());
            Files.writeString(CATEGORIES_TXT, String.join("\n", lines));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
