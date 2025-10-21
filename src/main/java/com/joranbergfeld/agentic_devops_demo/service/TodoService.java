package com.joranbergfeld.agentic_devops_demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final Logger log = LoggerFactory.getLogger(TodoService.class);
    private final List<String> todos;

    public TodoService() {
        todos = new ArrayList<>();
        todos.add("Learn Spring Boot");
        todos.add("Build a web application");
        todos.add("Master Thymeleaf");
        todos.add("Implement error handling");
    }

    public List<String> getAllTodos() {
        log.info("Fetching all todos");
        return todos;
    }

    public void addTodo(String todo) {
        if (todo != null && !todo.trim().isEmpty()) {
            todos.add(todo.trim());
            log.info("Added todo: {}", todo);
        }
    }
}
