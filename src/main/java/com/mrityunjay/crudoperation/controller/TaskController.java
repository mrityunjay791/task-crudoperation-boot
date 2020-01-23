package com.mrityunjay.crudoperation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrityunjay.crudoperation.model.Task;
import com.mrityunjay.crudoperation.service.TaskService;

/**
 * This controller class will be used for mapping task related request.
 * 
 * @author mrityunjaykumar
 *
 */
@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	
	/**
	 * Get request mapping for all tasks.
	 * 
	 * @return list of task.
	 */
	@GetMapping("/get-tasks")
	public List<Task> getTasks() {
		return taskService.getTasks();
	}
	
	/**
	 * This is used for mapping create task request.
	 * 
	 * @param task
	 * @return newly created task.
	 */
	@PostMapping("/create-task")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	/**
	 * Used to map delete request..
	 * 
	 * @param taskId
	 * @return boolean value.
	 */
	@DeleteMapping("/delete-task")
	public boolean deleteTask(@RequestParam("taskId") Long taskId) {
		return taskService.deleteTask(taskId);
	}
	
	
	/**
	 * Mapping request for updating task details.
	 * 
	 * @param task
	 * @return
	 */
	@PutMapping("/update-task/{taskId}")
	public Task updateTask(@PathVariable Long taskId, @Valid @RequestBody Task task) {
		return taskService.updateTask(task, taskId);
	}
}
