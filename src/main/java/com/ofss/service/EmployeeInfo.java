package com.ofss.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
@Path("/")
public class EmployeeInfo {
	private Integer empId;
	
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	/*public EmployeeInfo() {
		super();
	}*/
	/*public EmployeeInfo(int empId) {
		this.empId=empId;
	}*/
	@GET
	@Path("/get")
	public String getEmployeeInfo() {
		return "Get Message "+empId;
	}
	@GET
	@Path("/getinfo")
	public String getinfoMsg() {
		return "Get info";
	}
	
	@GET
	@Path("/{employeeName}")
	public String getemployeeInfoMessage(@PathParam("employeeName") String employeeName ,@PathParam("empId") int empId) {
		System.out.println("Inside getEmployeeInfoMessage()");
		return "Employee ID: "+empId + " " +"EmployeeName: "+employeeName;
	}
	
	/*@Path("locator")
    public EmployeeInfo getEmployeeSubResource() {
        return new EmployeeInfo();
    }*/

	public String getMessage() {
		return "Success";
	}
}
