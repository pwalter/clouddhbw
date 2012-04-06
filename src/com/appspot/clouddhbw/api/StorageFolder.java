package com.appspot.clouddhbw.api;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

@Path("/folders")
public class StorageFolder {
	
	@GET
	@Produces("text/plain")
	@Path("/{path: [a-zA-Z0-9_/]+}")
	public String showFolder(@PathParam("path") String path) {
		return "This would list all folders in the folder: " + path;
	}
	
	@PUT
	@Path("/{path: [a-zA-Z0-9_/]+}")
	public String createFolder(@PathParam("path") String path) {
		return "This would create the folder: " + path;
	}
	
	@DELETE
	@Produces("text/plain")
	@Path("/{path: [a-zA-Z0-9_/]+}")
	public String deleteFolder(@PathParam("path") String path) {
		return "This would delete the files in the folder: " + path;
	}
}
