package com.example.ToDoList.repository;

import com.example.ToDoList.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}