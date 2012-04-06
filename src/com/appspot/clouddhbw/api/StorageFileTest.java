package com.appspot.clouddhbw.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.appspot.clouddhbw.test.RequestHelper;
import com.appspot.clouddhbw.test.RequestType;

@Path("/test/files")
public class StorageFileTest {
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/GET/{path: [a-zA-Z0-9_/.]+}")
	public String downloadFileAsPlain(@PathParam("path") String path, @Context UriInfo ui) {
		return RequestHelper.doGET(RequestHelper.getHost(ui) + "/api/files/images/holidays/img01.jpg", MediaType.TEXT_PLAIN);
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/PUT/{path: [a-zA-Z0-9_/.]+}")
	public String uploadFile(@PathParam("path") String path, @Context UriInfo ui) {
		return RequestHelper.doPUT(RequestHelper.getHost(ui) + "/api/files/images/holidays/img01.jpg", MediaType.TEXT_PLAIN, "a=123");
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/GET/{path: [a-zA-Z0-9_/]+}")
	public String showFiles(@PathParam("path") String path, @Context UriInfo ui) {
		return RequestHelper.doGET(RequestHelper.getHost(ui) + "/api/files/images/holidays/", MediaType.TEXT_PLAIN);
	}
}
