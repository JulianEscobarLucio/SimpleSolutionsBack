package co.com.simplesolutions.adminpruebas.helper;

import java.util.ArrayList;

import co.com.simplesolutions.adminpruebas.dao.PruebaDao;
import co.com.simplesolutions.adminpruebas.dao.PruebaDaoImpl;
import co.com.simplesolutions.adminpruebas.model.Aplicacion;
import co.com.simplesolutions.adminpruebas.model.Prueba;
import co.com.simplesolutions.adminpruebas.model.Version;

public class PruebaHelperImpl implements PruebaHelper {
	

	@Override
	public ArrayList<Aplicacion> listarAplicacion() throws Exception {
		PruebaDao pruebaDao = new  PruebaDaoImpl();
		return pruebaDao.listarAplicacion();
	}

	@Override
	public ArrayList<Version> listarVersion(String idVersion) throws Exception {
		// TODO Auto-generated method stub
		PruebaDao pruebaDao = new  PruebaDaoImpl();
		return pruebaDao.listarVersion(idVersion);
	}

	@Override
	public boolean agregarPrueba(Prueba prueba) throws Exception {
		// TODO Auto-generated method stub
		PruebaDao pruebaDao = new  PruebaDaoImpl();
		return pruebaDao.agregarPrueba(prueba);
	}

	@Override
	public ArrayList<Prueba> listarPrueba() throws Exception {
		// TODO Auto-generated method stub
		PruebaDao pruebaDao = new  PruebaDaoImpl();
		return pruebaDao.listarPrueba();
	}

}
