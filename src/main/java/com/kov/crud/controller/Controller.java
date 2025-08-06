package com.kov.crud.controller;

import com.kov.crud.model.Task;
import com.kov.crud.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class Controller {
    private final Service service;

    @GetMapping
    public List<Task> getAllTasks(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id){
        return service.update(task, id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.delete(id);
    }




}
