package com.ofss.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ofss.bean.Employee;
import com.ofss.bean.Status;
import com.ofss.service.EmployeeService;

@Path("employees")
public class EmployeeController {
	EmployeeService employeeService = new EmployeeService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getEmployees() {
		// System.out.println("Controller getEmployees()");
		List listOfemployees = employeeService.getAllEmployess();
		return listOfemployees;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") int id) {
		return employeeService.getEmployee(id);
	}

	@GET
	@Path("search/EmployeeProject/{projectname}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> searchByProjectName(@PathParam("projectname") String projectname) {
		List<Employee> listOfemployees = employeeService.getAllEmployessByProjectName(projectname);
		return listOfemployees;
	}

	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> searchByName(@QueryParam("ename") String ename) {
		List<Employee> listOfemployees = employeeService.getAllEmployessName(ename);
		return listOfemployees;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Status addEmployee(Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateEmployee(@PathParam("id") int id, Employee employee) {
		return employeeService.updateEmployee(id, employee);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmployee(@PathParam("id") int id) {
		employeeService.deleteEmployee(id);

	}
}
