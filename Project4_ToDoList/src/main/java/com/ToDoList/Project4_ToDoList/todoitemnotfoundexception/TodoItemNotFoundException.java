package com.ToDoList.Project4_ToDoList.todoitemnotfoundexception;

public class TodoItemNotFoundException extends RuntimeException{
public TodoItemNotFoundException(int id)
{
	super("Todo item not found with id:"+id);
}
}
