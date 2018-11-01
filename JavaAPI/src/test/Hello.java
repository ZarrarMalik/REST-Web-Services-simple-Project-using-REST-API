package test;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello() 
	{
		String resource="<?xml version='1.0' ?>" +
	"<message> Hi Zee, This is Hello from Xml</message>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJson() {
		String resource= null;
		return resource;
	}
	
	
	/*
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHtml() {
		String resource= "<h2> Hie Zee, This is Hello from Html</h2>";
		return resource;
	}*/
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHtml(@QueryParam("name") String name, @QueryParam("cardNo") String cardNo, @QueryParam("amount") int amount) {
		System.out.println("The Name is " + name);
		System.out.println("The amount is " + amount);
		String response;
		
		if(amount>1000) {
			System.out.println("The amount is huge, can't handle it");
			response = "Credit Card is Declined";
		}
		else {
			System.out.println("It is not that bad to handle this amount, we can do this");
			response="Credit Card can take this all day long, CARD APPROVED";
		}
		
		return "<html>" + "<title>" + "CREDIT CARD AUTHORIZATION" + name +"</title>"+
		"<body> <h2>" + response +"</h2></body>" + "</html>";
	}
	
}


