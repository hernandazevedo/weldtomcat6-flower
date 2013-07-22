package br.giava.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import by.giava.model.Track;

@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Track> getTrackInJSON() {
 
		List<Track> lista = new ArrayList<Track>();
		
		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");
		
		
		Track track2 = new Track();
		track.setTitle("Enter Sandman2");
		track.setSinger("Metallica2");
		
		lista.add(track);
		lista.add(track2);
		
 
		return lista;
 
	}
 
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {
 
		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
 
	}
 
}