package org.ws.tutorial.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.StatelessSession;
import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ws.tutorial.model.Employee;
import org.ws.tutorial.services.IfaceListEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
public class RetrivalTest {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private IfaceListEmployeeService service;
	
//	@Test
	public void TestFetchedResult()
	{
		getNextList(10, 10);
	}
	
	public List<Employee> getNextList(int maxResult, int firstPage)
	{
		Query query = em.createQuery("select e from Employee e");
		query.setFirstResult(firstPage);
		query.setMaxResults(maxResult);
		List<Employee> list = query.getResultList();
		return list;
	}
	
	@Test
	public void TestTotalPages(){
		System.out.println(service.getTotalPages());
	}
	
//	@Test
	public void ListAllEmployeeServiceTest(){
		List<Employee> list = service.getAllEmployees(0, 10);		
	}

//	@Test
	public void TestSingleResult()
	{
		Employee e = em.find(Employee.class, 100010);
		System.out.println(e);
	}
//	@Test
	public void ListEmployeeServiceTest(){
		Employee e = em.find(Employee.class, 100010);
		System.out.println(e);		
	}
}
