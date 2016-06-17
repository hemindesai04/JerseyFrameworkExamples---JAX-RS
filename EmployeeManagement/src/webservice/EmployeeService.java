package webservice;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.EmployeeModel;
import pojo.EmployeeInfo;


@Path("/WebService")
public class EmployeeService {
	
	EmployeeModel empmod = new EmployeeModel();
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/employees")
	public List<EmployeeInfo> getAllEmployees(){
		try {
			return empmod.getAllEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/employees/{id}")
	@Produces(MediaType.TEXT_XML)
	public EmployeeInfo getEmployee(@PathParam("id") String id){
			try {
				System.out.println(id);
				return empmod.getEmployee(Integer.parseInt(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	@PUT
	@Path("/employees")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addEmployee(@FormParam("id") int id,
			@FormParam("name") String name,
			@FormParam("department") String department,
			@FormParam("phone") String phone,
			@Context HttpServletResponse servletResponse) throws Exception{
		
			EmployeeInfo empInfo = new EmployeeInfo(id, name, department, phone);
			int result;
			try {
				result = empmod.addEmployee(empInfo);
				if(result==1)
					return "Result Successful";
			}
			catch (Exception e){
				throw e;
			}
			
			return "Result Failure";
	}
	
	@POST
	@Path("/employees")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateEmployee(@FormParam("id") int id,
			@FormParam("name") String name,
			@FormParam("department") String department,
			@FormParam("phone") String phone,
			@Context HttpServletResponse servletResponse) throws Exception{
		
		EmployeeInfo empInfo = new EmployeeInfo(id, name, department, phone);
		int result = empmod.updateEmployee(empInfo);
		if(result == 1)
			return "Result Successful.";
		return "Result Failure.";
	}
	
	@DELETE
	@Path("/employees/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteEmployee(@PathParam("id") int id) throws Exception{
		int result = empmod.deleteUser(id);
		if(result == 1)
			return "Result Successful.";
		return "Result Failure.";
	}
	
}
