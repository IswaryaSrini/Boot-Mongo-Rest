package com.springboot.todo.controller;

import com.springboot.todo.model.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todo.repository.TodoRepoImpl;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	private TodoRepoImpl todoRepoImpl;
	
	@GetMapping("/all")
	public ResponseEntity<List<Todo>> retrieveAllTodos() {
		return new ResponseEntity<List<Todo>>(todoRepoImpl.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getSingle/{title}")
	public ResponseEntity<Todo> retrieveTodo(@PathVariable String title) {
		return new ResponseEntity<Todo>(todoRepoImpl.findByTitle(title), HttpStatus.OK);
	}
	
	@PostMapping("/saveSingle")
	public ResponseEntity<String> addTodo(@RequestBody Todo todo) {
		todoRepoImpl.save(todo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
