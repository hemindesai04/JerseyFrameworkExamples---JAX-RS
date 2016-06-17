package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.EmployeeDAO;
import pojo.EmployeeInfo;

public class EmployeeModel {
	
	public EmployeeModel(){}

		public List<EmployeeInfo> getAllEmployees()throws Exception {
			ArrayList<EmployeeInfo> employeeList = null;
			try {
				DbConnection database = new DbConnection();
				Connection connection = database.getConnection();
				EmployeeDAO empdao = new EmployeeDAO();
				employeeList = empdao.getAllEmployees(connection);
				if(employeeList.isEmpty())
					return null;
				
			} catch (Exception e) {
				throw e;
			}
			return employeeList;
		}

		public EmployeeInfo getEmployee(int id) throws Exception {
			// TODO Auto-generated method stub
			EmployeeInfo empInfo = null;
			try{
				DbConnection database = new DbConnection();
				Connection connection = database.getConnection();
				EmployeeDAO empdao = new EmployeeDAO();
				empInfo = empdao.getEmployee(connection, id);
				if(empInfo.getId()!=id)
					return null;
			} catch (Exception e){
				throw e;
			}
			return empInfo;
		}

/*		public int addEmployee(EmployeeInfo empInfo) throws Exception {
			// TODO Auto-generated method stub
				
				List<EmployeeInfo> empList = null;
				try{
					empList = getAllEmployees();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean userExists = false;
				for(EmployeeInfo empinfo : empList){
					if(empinfo.getId()==empInfo.getId()){
							userExists = true;
							break;
					}
					if(!userExists){
						DbConnection database = new DbConnection();
						Connection connection = null;
						try {
							connection = database.getConnection();
							EmployeeDAO empdao = new EmployeeDAO();
							empdao.addEmployee(connection, empInfo);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							throw e;
						}
						return 1;
					}
			}
			return 0;	
		}*/
		
		public int addEmployee(EmployeeInfo empInfo) throws Exception {
			// TODO Auto-generated method stub
			EmployeeInfo empi = getEmployee(empInfo.getId());
			if(empi == null){
				DbConnection database = new DbConnection();
				Connection connection = null;
				try {
					connection = database.getConnection();
					EmployeeDAO empdao = new EmployeeDAO();
					empdao.addEmployee(connection, empInfo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw e;
				}
				return 1;
			}
			return 0;
		}

		public int updateEmployee(EmployeeInfo empInfo) throws Exception {
			// TODO Auto-generated method stub
			EmployeeInfo empi = getEmployee(empInfo.getId());
			if(empi!= null){
				DbConnection database = new DbConnection();
				Connection connection = null;
				try {
					connection = database.getConnection();
					EmployeeDAO empdao = new EmployeeDAO();
					empdao.updateEmployee(connection, empInfo);
					return 1;
				}
				catch (Exception e){
					throw e;
				}
			}
			return 0;
		}

		public int deleteUser(int id) throws Exception {
			// TODO Auto-generated method stub
			EmployeeInfo empi = getEmployee(id);
 			if(empi != null){
 				DbConnection database = new DbConnection();
				Connection connection = null;
				try {
					connection = database.getConnection();
					EmployeeDAO empdao = new EmployeeDAO();
					empdao.deleteEmployee(connection, id);
					return 1;
				}
				catch (Exception e){
					throw e;
				}	
 			}
			return 0;
		}
		
		
}
