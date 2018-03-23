package com.springboot.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.todo.model.Todo;

@Repository
public interface TodoRepoImpl extends MongoRepository<Todo, String> {

public Todo findByTitle(String title)	;
}
