package com.joranbergfeld.agentic_devops_demo.controller;

import com.joranbergfeld.agentic_devops_demo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for creating new todo items.
 * GET method for displaying the page, POST method for handling form submission.
 */
@Controller
@RequestMapping("/todos/create")
public class CreateTodoController {

    private final TodoService todoService;

    public CreateTodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Displays the create todo page.
     * @return
     */
    @GetMapping
    public String showCreatePage() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Handles the submission of a new todo item.
     * @param title
     * @param description
     * @param redirectAttributes
     * @return
     */
    @PostMapping
    public String createTodo(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description", required = false) String description,
            RedirectAttributes redirectAttributes) {
        
        String todoText = description != null && !description.trim().isEmpty()
                ? title + " - " + description
                : title;
        
        todoService.addTodo(todoText);
        redirectAttributes.addFlashAttribute("message", "Todo created successfully!");
        return "redirect:/todos";
    }
}
