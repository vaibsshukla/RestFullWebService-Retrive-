package org.ws.tutorial.utility.sort;

import java.util.Comparator;

import org.ws.tutorial.model.Employee;

public class SortByType  {

	public static class SortByName implements Comparator<Employee>{
		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.getFirstName().compareTo(emp2.getFirstName());
		}
	}

	public static class SortByHiringDate implements Comparator<Employee>{
		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.getHireDate().compareTo(emp2.getHireDate());
		}
	}
}
