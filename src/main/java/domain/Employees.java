package domain;

import java.util.ArrayList;
import java.util.List;

public class Employees {

	private List<Employee> employees = new ArrayList<Employee>();

	public Employees() {
		this.employees.add(new Employee("001","sadj",1,"chaisi"));
		this.employees.add(new Employee("002","safj",1,"chaisi"));
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void setEmployees(Employee employee) {
		this.employees.add(employee);
	}
	
}
