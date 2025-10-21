package com.joranbergfeld.agentic_devops_demo.controller;

import com.joranbergfeld.agentic_devops_demo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "todos";
    }
}
