package com.ofss.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import com.ofss.bean.Employee;
import com.ofss.bean.Status;

public class EmployeeService {
	static HashMap<Integer, Employee> employeeIdMap = getEmployeeIdMap();

	public EmployeeService() {
		super();

		if (employeeIdMap == null) {
			employeeIdMap = new HashMap<Integer, Employee>();
			// Creating some objects of Employee while initializing
			Employee gEmployee = new Employee(1, "Gyana", "Truesaas-service");
			Employee aEmployee = new Employee(2, "Anurag", "Truesaas-service");
			Employee arEmployee = new Employee(3, "Arvind", "Truesaas-UI");
			Employee niEmployee = new Employee(4, "Neeta", "Truesaas-UI");
			Employee rEmployee = new Employee(5, "Ram", "Truesaas-service");
			employeeIdMap.put(1, gEmployee);
			employeeIdMap.put(2, aEmployee);
			employeeIdMap.put(3, arEmployee);
			employeeIdMap.put(4, niEmployee);
			employeeIdMap.put(5, rEmployee);
		}
	}

	public List getAllEmployess() {
		// System.out.println("Service getAllEmployess");
		List<Employee> employees = new ArrayList<Employee>(employeeIdMap.values());
		return employees;
	}

	public List<Employee> getAllEmployessByProjectName(String projectName) {
		List<Employee> employees = new ArrayList<Employee>();
		employeeIdMap.values().forEach(employee -> {
			if (projectName != null && projectName.equalsIgnoreCase(employee.getEmployeeProject())) {
				employees.add(employee);
			}
		});
		return employees;
	}

	public List<Employee> getAllEmployessName(String eName) {
		List<Employee> employees = new ArrayList<Employee>();
		employeeIdMap.values().forEach(employee -> {
			if (eName != null && eName.equalsIgnoreCase(employee.getEmployeName())) {
				employees.add(employee);
			}
		});
		return employees;
	}

	public Response getEmployee(int empid) {
		Employee employee = employeeIdMap.get(empid);
		return Response.status(200).entity(employee).build();
	}

	public Status addEmployee(Employee employee) {
		if (employee.getEmployeeId() == 0)
			return new Status("Failed", "Employee id should not be zero");
		employee.setEmployeeId(employeeIdMap.size() + 1);
		employeeIdMap.put(employee.getEmployeeId(), employee);
		return new Status("SUCCESS", "Employee Id: " + employeeIdMap.get(employee.getEmployeeId()).getEmployeeId());
	}

	public Status updateEmployee(int empId, Employee employee) {
		boolean flag = false;
		if (empId <= 0)
			return new Status("Failed ", "Employee id does not exist ");

		for (Employee emp : employeeIdMap.values()) {
			if (empId == emp.getEmployeeId()) {
				flag = true;
				employee.setEmployeeId(empId);
				employeeIdMap.put(empId, employee);
				return new Status("Success ", "Updated details for the employee id" + empId);
			}
		}
		if (flag)
			return new Status("Success ", "Update Details for Employee id " + empId);
		else
			return new Status("Failed ", "Employee id does not exist ");
	}

	public Status deleteEmployee(int empid) {
		employeeIdMap.remove(empid);
		return new Status("SUCCESS", "Deleted employee id: " + empid);
	}

	public static HashMap<Integer, Employee> getEmployeeIdMap() {
		return employeeIdMap;
	}

}
