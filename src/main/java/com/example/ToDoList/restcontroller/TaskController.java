package com.example.ToDoList.restcontroller;

import com.example.ToDoList.dtos.TaskDTO;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/task")
    public void addTask(@RequestBody TaskDTO taskDTO) {
        taskService.addTask(taskDTO);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseBody
    public ResponseEntity<String> handleNotFindResourceException(Exception ex) {
        System.out.println("The error with exception: " + ex.getMessage());
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
