package com.example.ToDoList;

import com.example.ToDoList.dtos.TaskDTO;
import com.example.ToDoList.entities.Task;
import com.example.ToDoList.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ToDoListApplication.class)
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    public void setup() {
        // Initialize your test data or perform any setup here
    }

    @Test
    public void test_createTask() throws Exception {
        TaskDTO taskDTO = new TaskDTO("New Task", "New Descriptipn");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/task")
                        .content(asJsonString(taskDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Task savedTask = taskRepository.findById(1L).get();

        assert savedTask.getName().equals(taskDTO.getName());
        assert savedTask.getDescription().equals(taskDTO.getDescription());
    }

    // Helper method to convert objects to JSON
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
