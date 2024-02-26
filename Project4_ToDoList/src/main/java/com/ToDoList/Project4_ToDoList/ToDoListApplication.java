package com.ToDoList.Project4_ToDoList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.Project4_ToDoList.todoitem.TodoItem;
import com.ToDoList.Project4_ToDoList.todoitemnotfoundexception.TodoItemNotFoundException;

@SpringBootApplication
@RestController

@RequestMapping("/todos")



public class ToDoListApplication {
	private List<TodoItem> todoItems=new ArrayList<>();
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class,args);
	}



@GetMapping
public List<TodoItem> getAllTodoItems()
{
	return todoItems;
}

@GetMapping("/{id}")
public TodoItem getTodoItemById(@PathVariable int id)
{
	return todoItems.stream()
			.filter(todoItem->todoItem.getId()==id)
			.findFirst()
			.orElseThrow(()->new TodoItemNotFoundException(id));
}

@PostMapping
public TodoItem addTodoItem(@RequestBody TodoItem todoItem)
{
	todoItem.setId(todoItems.size()+1);
	todoItems.add(todoItem);
	return todoItem;
}


@PutMapping
public TodoItem updateTodoItem(@PathVariable int id,@RequestBody TodoItem updatedTodoItem)
{
	TodoItem todoItem=getTodoItemById(id);
	todoItem.setDescription(updatedTodoItem.getDescription());
	todoItem.setCompleted(updatedTodoItem.isCompleted());
	return todoItem;
}

@DeleteMapping("/{id}")
public void deleteTodoItem(@PathVariable int id) {
    todoItems.removeIf(todoItem -> todoItem.getId() == id);
}


}