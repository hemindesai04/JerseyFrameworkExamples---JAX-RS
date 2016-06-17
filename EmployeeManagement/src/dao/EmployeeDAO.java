package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import pojo.EmployeeInfo;

public class EmployeeDAO {
	
	public ArrayList<EmployeeInfo> getAllEmployees(Connection connection) throws Exception{
		ArrayList<EmployeeInfo> employeeList = new ArrayList<EmployeeInfo>();
		try{
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM employee");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeInfo employeeinfo = new EmployeeInfo();
				employeeinfo.setName(rs.getString("name"));
				employeeinfo.setDepartment(rs.getString("department"));
				employeeinfo.setId(rs.getInt("id"));
				employeeinfo.setPhone(rs.getString("phone"));
				employeeList.add(employeeinfo);
			}
			return employeeList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public EmployeeInfo getEmployee(Connection connection, int id) throws Exception{
		EmployeeInfo employeeinfo = new EmployeeInfo();
		try{
			String sql = "SELECT * FROM employee WHERE id ="+ id;
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				employeeinfo.setName(rs.getString("name"));
				employeeinfo.setId(rs.getInt("id"));
				employeeinfo.setDepartment(rs.getString("department"));
				employeeinfo.setPhone(rs.getString("phone"));
			}
		}
		catch (Exception e){
			throw e;
		}
		return employeeinfo;
	}
		
	public void addEmployee(Connection connection, EmployeeInfo empinfo) throws Exception{
		try{
			String sql = "INSERT into employee(id, name, department, phone) values (" + empinfo.getId() + "," + "'"+empinfo.getName()+"'" + "," + "'" + empinfo.getDepartment() + "'" + "," + "'" + empinfo.getPhone() + "'" + ")";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.executeUpdate();		
		}
		catch (Exception e){
			throw e;
		}
	}
	
	public void updateEmployee(Connection connection, EmployeeInfo empinfo) throws Exception{
		try{
			String sql = "UPDATE employee SET id=" + empinfo.getId() +"," + " name=" + "'" + empinfo.getName() + "'" + "," + " department=" + "'" + empinfo.getDepartment() + "'" + "," + "phone=" + "'" +empinfo.getPhone() + "'" + " where id=" + empinfo.getId();
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.executeUpdate();		
		}
		catch (Exception e){
			throw e;
		}
	}
	
	public void deleteEmployee(Connection connection, int id) throws Exception{
		try{
			String sql = "DELETE from employee where id=" + id;
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.executeUpdate();		
		}
		catch (Exception e){
			throw e;
		}
	}
}
