package com.example.ToDoList.config.beans;

import com.example.ToDoList.entities.Task;
import com.example.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DatabaseLoader implements ApplicationRunner {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Task task1 = new Task();
        task1.setName("Cleaning");
        task1.setDescription("Clean your room");
        taskRepository.save(task1);

        Task task2 = new Task();
        task2.setName("Shopping");
        task2.setDescription("Buy 0.5 chicken meat, 2 carrots, 1 onion, 1 choco bar ");
        taskRepository.save(task2);
    }
}
