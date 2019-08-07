package com.ofss.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String employeName;
	private String employeeProject;

	public Employee() {// needed for JAXB
		super();
	}

	public Employee(int employeeId, String employeName, String employeeProject) {
		super();
		this.employeeId = employeeId;
		this.employeName = employeName;
		this.employeeProject = employeeProject;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeName() {
		return employeName;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	public String getEmployeeProject() {
		return employeeProject;
	}

	public void setEmployeeProject(String employeeProject) {
		this.employeeProject = employeeProject;
	}

}
