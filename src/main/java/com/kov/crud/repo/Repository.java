package com.kov.crud.repo;

import com.kov.crud.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
}
