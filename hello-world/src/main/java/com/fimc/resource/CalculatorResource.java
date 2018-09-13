package com.fimc.resource;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/_calculator")
public class CalculatorResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(CalculatorRequest request) {
		if (StringUtils.isEmpty(request.getFirstNumber()) || StringUtils.isEmpty(request.getSecondNumber())
				|| StringUtils.isEmpty(request.getOperator())) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).build();
		}

		CalculatorResponse messageResponse = new CalculatorResponse();
		String result = null;
		Float a = null;
		Float x = request.getFirstNumber();
		Float y = request.getSecondNumber();
		if (request.getOperator().equals("+")) {
			result = "addition";
			a = (x + y);
		} else if (request.getOperator().equals("-")) {
			result = "subtraction";
			a = (x - y);
		} else if (request.getOperator().equals("*")) {
			result = "multiplication";
			a = (x * y);
		} else if (request.getOperator().equals("/")) {
			result = "division";
			a = (x / y);
		} else {
			return Response.ok().entity("Bad Request").build();
		}
		System.out.println("Anwer: " + a);
		BigDecimal finalAns = new BigDecimal(String.format("%.5f", a));
		System.out.println("THIS IS THE SYSOUT" + finalAns);
		messageResponse.setResult(finalAns);
		messageResponse.setOperator(result);
		return Response.ok().entity(messageResponse).build();

	}
}