package com.springboot.todo.model;

import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class Todo {

	@Id
	private String id;

	@Size(max = 100)
	private String title;

	@Size(max = 500)
	private String description;

	Todo() {
	}

	public Todo(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Todo [id=%s, title=%s,description=%s]", id, title, description);
	}

}
