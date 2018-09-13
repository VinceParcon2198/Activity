package com.fimc.resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
@Path("/_worker")
public class WorkerResource {

	List<WorkerResponse> list = new ArrayList<WorkerResponse>();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response worker(WorkerRequest request) {

		if (StringUtils.isEmpty(request.getFirstName()) || StringUtils.isEmpty(request.getLastName())
				|| StringUtils.isEmpty(request.getBirthDate())) {
			return Response.status(Response.Status.BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST)
					.type(MediaType.TEXT_PLAIN).build();
		} else {
			System.out.print("sssss"+ request.getFirstName());
			WorkerResponse workerResponse = new WorkerResponse();
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
			workerResponse.setFirstname(String.format("%s", request.getFirstName()));
			workerResponse.setLastname(String.format("%s", request.getLastName()));
			workerResponse.setBirthdate(formatter.format(request.getBirthDate()));
			list.add(workerResponse);
			return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response response(WorkerRequest request) {
		return Response.ok().entity(list).build();
	}
}
