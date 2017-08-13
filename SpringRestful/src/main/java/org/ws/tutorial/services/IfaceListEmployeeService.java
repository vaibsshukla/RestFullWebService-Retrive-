package org.ws.tutorial.services;

import java.util.List;

import org.ws.tutorial.model.Employee;

public interface IfaceListEmployeeService {

	public List<Employee> getAllEmployees(int firstResult, int maxResult);
	public Employee getEmployee(int id);
	public Object getTotalPages();}
