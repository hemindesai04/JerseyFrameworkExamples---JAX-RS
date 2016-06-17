package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
public class EmployeeInfo {
	
	private String name;
	private String department;
	private String phone;
	private int id;
	
	public EmployeeInfo(){}
	
	public EmployeeInfo(int id, String name, String department, String phone){
		this.id = id;
		this.name = name;
		this.department = department;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	
	@XmlElement
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	
	@XmlElement
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

}
