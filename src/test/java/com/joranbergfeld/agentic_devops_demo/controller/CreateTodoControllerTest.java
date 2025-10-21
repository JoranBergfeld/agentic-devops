package com.joranbergfeld.agentic_devops_demo.controller;

import com.joranbergfeld.agentic_devops_demo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CreateTodoController.class)
class CreateTodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    void showCreatePage_shouldReturnCreateTodoView() throws Exception {
        mockMvc.perform(get("/todos/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("create-todo"));
    }

    @Test
    void createTodo_shouldRedirectToTodosPage() throws Exception {
        mockMvc.perform(post("/todos/create")
                        .param("title", "Test Todo")
                        .param("description", "Test Description"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/todos"));
    }
}
