package org.ws.tutorial.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ws.tutorial.dao.IfaceListEmployee;
import org.ws.tutorial.model.Employee;

@Service
@Transactional
public class ListEmployeeService implements IfaceListEmployeeService {

	@Autowired
	private IfaceListEmployee employeeDao;
	
	@Override
	public List<Employee> getAllEmployees(int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees(firstResult, maxResult);
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(id);
	}

	@Override
	public Object getTotalPages() {
		// TODO Auto-generated method stub
		return employeeDao.getTotalPages();
	}


}
