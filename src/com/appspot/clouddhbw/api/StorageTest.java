package com.appspot.clouddhbw.api;

import javax.ws.rs.*;

@Path("/")
public class StorageTest {
	@GET
	@Produces("text/plain")
	public String getIndex() {
		// Return some cliched textual content
		return "This is the RESTful API for storing and retrieving data like in dropbox";
	}
}
