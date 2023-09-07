package com.example.ToDoList.restcontroller;

import com.example.ToDoList.dtos.TaskDTO;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody TaskDTO taskDTO) {
        taskService.addTask(taskDTO);
    }
}
