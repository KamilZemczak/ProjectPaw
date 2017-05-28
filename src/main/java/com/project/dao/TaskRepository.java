package com.project.dao;

import org.springframework.data.repository.CrudRepository;
import com.project.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    
}
