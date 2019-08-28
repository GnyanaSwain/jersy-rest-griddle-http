package com.ofss.controller;

import java.util.List;
import java.util.Properties;

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

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.ofss.bean.Employee;
import com.ofss.bean.Status;
import com.ofss.service.EmployeeInfo;
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
	
	@POST
	@Path("/Kafkasendmsg")
	@Produces(MediaType.APPLICATION_JSON)
	public Status sendKafkaMsg(Employee employee) {
		return employeeService.sendKafkaMessage(employee);
		//return "Message Posted to Kafka topic 'empmsg_topic' successfully!!";
	}
	
	@GET
	@Path("/Kafkagetmsg")
	@Produces(MediaType.APPLICATION_JSON)
	public void getKafkaMsg() {
		 employeeService.getKafkaMessage();
		//return "Message Posted to Kafka topic 'empmsg_topic' successfully!!";
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
	@Path("/employeeinfo/{empId}")
	public EmployeeInfo getEmployeeInfo() {
		System.out.println("Befor calling EmployeeInfo");
		//return "Hello";
		/*EmployeeInfo info=new EmployeeInfo();		
		return info.getMessage();*/
		//return new EmployeeInfo(empId);
		return new EmployeeInfo();
	}
}
