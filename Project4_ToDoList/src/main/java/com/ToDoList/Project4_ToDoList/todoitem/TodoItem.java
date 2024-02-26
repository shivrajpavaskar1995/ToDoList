package com.ToDoList.Project4_ToDoList.todoitem;

public class TodoItem {

	private int id;
	private String description;
	private boolean completed;
	public TodoItem(int id, String description, boolean completed) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	
	
	
	
}
