package com.appspot.clouddhbw.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import com.appspot.clouddhbw.test.RequestHelper;
import com.appspot.clouddhbw.test.RequestType;

@Path("/test/folders")
public class StorageFolderTest {
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/GET/{path: [a-zA-Z0-9_/]+}")
	public String showFolders(@PathParam("path") String path) {
		return RequestHelper.doGET("/api/folders/images/holidays/", MediaType.TEXT_PLAIN);
	}
}
