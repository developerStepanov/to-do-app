package com.example.ToDoList.service;

import com.example.ToDoList.dtos.TaskDTO;
import com.example.ToDoList.entities.Task;
import com.example.ToDoList.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<TaskDTO> getTasks() {
        List<TaskDTO> taskDtos = taskRepository.findAll()
                                                .stream()
                                                .map(task -> modelMapper.map(task, TaskDTO.class))
                                                .collect(Collectors.toList());

        return taskDtos;
    }

    public void addTask(TaskDTO taskDTO) {
        Task task = modelMapper.map(taskDTO, Task.class);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        try {
            taskRepository.delete(task.get());
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("Task with id: " + id + " not found");
        }
    }
}
