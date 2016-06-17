package com.hemin.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ConversionService")
public class F2IandI2FconversionService {
	
	@GET
	@Path("/i2f/{i}")
	@Produces(MediaType.TEXT_XML)
	public String conversionToFeet(@PathParam("i") int i){
		
		int inch = i;
		double feet = 0;
		feet = (double)inch/12;
		
		return "<InchToFeetService>"  
        + "<Inch>" + inch + "</Inch>"  
          + "<Feet>" + feet + "</Feet>"  
         + "</InchToFeetService>";
	}
	
	@GET
	@Path("/f2i/{f}")
	@Produces(MediaType.TEXT_XML)
	public String conversionToInch(@PathParam("f") int f){
		int feet = f;
		int inch = 0;
		inch = feet * 12;
		
		return "<FeetToInchService>"  
        + "<Feet>" + feet + "</Feet>"  
        + "<Inch>" + inch + "</Inch>"  
        + "</FeetToInchService>"; 
	}
}
