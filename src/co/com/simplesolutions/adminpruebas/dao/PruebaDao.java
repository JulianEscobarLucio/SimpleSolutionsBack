package co.com.simplesolutions.adminpruebas.dao;

import java.util.ArrayList;

import co.com.simplesolutions.adminpruebas.model.Aplicacion;
import co.com.simplesolutions.adminpruebas.model.Prueba;
import co.com.simplesolutions.adminpruebas.model.Version;

public interface PruebaDao {
	 public ArrayList<Aplicacion> listarAplicacion() throws Exception ;
	 
	 public ArrayList<Version> listarVersion(String idVersion) throws Exception;
	 
	 public boolean agregarPrueba(Prueba prueba) throws Exception;
	 
	 public ArrayList<Prueba> listarPrueba()throws Exception;

}
