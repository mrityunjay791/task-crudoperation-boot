package com.mrityunjay.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrityunjay.crudoperation.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
