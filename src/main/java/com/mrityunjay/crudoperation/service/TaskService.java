package com.mrityunjay.crudoperation.service;

import java.util.List;

import com.mrityunjay.crudoperation.model.Task;

public interface TaskService {

	public List<Task> getTasks();
	
	public Task createTask(Task task);
	
	public boolean deleteTask(long taskId);
	
	public Task updateTask(Task task, long taskId);
}
