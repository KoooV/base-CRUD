package com.kov.crud.service;

import com.kov.crud.model.Task;
import com.kov.crud.repo.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Optional<Task> findById(Long id){
        Optional<Task> task = repository.findById(id);
        if(task.isPresent()){
            log.info("getById found with id {}", id);
        }else{
            log.info("getById not found with id {}",id);
        }
        return task;
    }

    public Optional<Task> getByTitle(String title){
        Optional<Task> entity = repository.findByTitle(title);
        if(entity.isPresent()){
            log.info("getByTitle found with title {}", title);
        }
        else{
            log.info("getByTitle not found with title {}", title);
        }
        return entity;
    }

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task save(Task task){
        return repository.save(task);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Task update(Task updated, Long id){
        Task task = repository.getById(id);
        task.setTitle(updated.getTitle());
        task.setDescription(updated.getDescription());
        task.setCompleted(updated.isCompleted());
        return repository.save(task);
    }

}
