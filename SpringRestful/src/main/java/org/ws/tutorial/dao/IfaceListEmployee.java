package org.ws.tutorial.dao;

import java.util.List;

import org.ws.tutorial.model.Employee;

public interface IfaceListEmployee {
	
	public List<Employee> getAllEmployees(int firstResult, int maxResult);
	public Employee getEmployee(int id);
	public Object getTotalPages();
}
