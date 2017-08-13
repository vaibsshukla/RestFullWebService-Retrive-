package org.ws.tutorial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.ws.tutorial.model.Employee;

@Repository
public class ListEmployeeImpl implements IfaceListEmployee {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Employee> getAllEmployees(int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		return getNextList(firstResult, maxResult);
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return manager.find(Employee.class, id);
	}
	public List<Employee> getNextList(int firstResult, int maxResult)
	{
		Query query = manager.createQuery("select e from Employee e");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Object getTotalPages() {
		return manager.createQuery("select count(e) from Employee e").getSingleResult();
	}

}
