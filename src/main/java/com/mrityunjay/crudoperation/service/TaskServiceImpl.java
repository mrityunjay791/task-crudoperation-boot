package com.mrityunjay.crudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrityunjay.crudoperation.exception.MyCustomException;
import com.mrityunjay.crudoperation.model.Task;
import com.mrityunjay.crudoperation.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public boolean deleteTask(long taskId) {

		Task task = taskRepository.findById(taskId).orElseThrow(() -> {
			throw new MyCustomException("Note", "id", taskId);
		});

		taskRepository.delete(task);

		return true;
	}

	@Override
	public Task updateTask(Task task, long taskId) {
		Task taskTemp = taskRepository.findById(taskId).orElseThrow(() -> {
			throw new MyCustomException("Update Task", "taskId", taskId);
		});

		taskTemp.setContent(task.getContent());
		taskTemp.setTitle(task.getTitle());
		return taskRepository.save(taskTemp);
	}

}
