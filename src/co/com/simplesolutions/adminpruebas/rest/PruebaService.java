package co.com.simplesolutions.adminpruebas.rest;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

import co.com.simplesolutions.adminpruebas.helper.PruebaHelper;
import co.com.simplesolutions.adminpruebas.helper.PruebaHelperImpl;
import co.com.simplesolutions.adminpruebas.model.Aplicacion;
import co.com.simplesolutions.adminpruebas.model.Prueba;
import co.com.simplesolutions.adminpruebas.model.Version;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationPath("rest")
@Path("/PruebaService")
public class PruebaService {
	private Gson gson;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStartingPage() {
		String output = "<h1>Hello World!<h1>" + "<p>RESTful Service is running ... <br>Ping @ " + new Date().toString()
				+ "</p><br>";
		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/registrarPrueba")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrarPrueba(String hola) {
		return Response.status(200).entity("hola").build();
	}

	@GET
	@Path("/listaAplicaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaAplicacion() {
		PruebaHelper pruebaHelper = new PruebaHelperImpl();
		try {
			ArrayList<Aplicacion> listAplicacion = pruebaHelper.listarAplicacion();
			return Response.status(200).entity(pruebaHelper.listarAplicacion()).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			return Response.status(500).entity("").build();
		}
	}

	@POST
	@Path("/listaVersiones")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaVersiones(Version Version) {
		PruebaHelper pruebaHelper = new PruebaHelperImpl();
		String id = Version.getIdAplicacion();
		if(id == null || id.equals("")) {
			return Response.status(500).entity("Falta id de la aplicación").build();
		}
		try {
			return Response.status(200).entity(pruebaHelper.listarVersion(id)).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			return Response.status(500).entity("").build();
		}
	}

	@POST
	@Path("/agregaPrueba")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response agregaPrueba(Prueba prueba) {
		PruebaHelper pruebaHelper = new PruebaHelperImpl();
		if(prueba.getIdAplicacion() == null || prueba.getIdAplicacion().equals("")) {
			return Response.status(500).entity("Faltan datos para almacenar").build();
		}
		if(prueba.getCantPruebas() == null || prueba.getCantPruebas().equals("")) {
			return Response.status(500).entity("Faltan datos para almacenar").build();
		}
		if(prueba.getCantEjecutadas() == null || prueba.getCantEjecutadas().equals("")) {
			return Response.status(500).entity("Faltan datos para almacenar").build();
		}
		if(prueba.getCantFallidas() == null || prueba.getCantFallidas().equals("")) {
			return Response.status(500).entity("Faltan datos para almacenar").build();
		}
		if(prueba.getCantCompletadas() == null || prueba.getCantCompletadas().equals("")) {
			return Response.status(500).entity("Faltan datos para almacenar").build();
		}
		if(prueba.getCantBloqueantes() == null || prueba.getCantBloqueantes().equals("")) {
			return Response.status(500).entity("Faltan datos para almacenar").build();
		}
		try {
			if (!pruebaHelper.agregarPrueba(prueba)) {
				return Response.status(500).entity("Error almacenando prueba").build();
			}
			return Response.status(200).entity("Prueba almacenada").build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			return Response.status(500).entity("Error almacenando prueba").build();
		}
	}
	
	@GET
	@Path("/listaPruebas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPruebas( ) {
		PruebaHelper pruebaHelper = new PruebaHelperImpl();
		try {
			ArrayList<Prueba> ListPrueba = pruebaHelper.listarPrueba();
			return Response.status(200).entity(ListPrueba).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e);
			return Response.status(500).entity("").build();
		}
	}

}
