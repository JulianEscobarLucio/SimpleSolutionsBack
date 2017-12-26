package co.com.simplesolutions.adminpruebas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.codehaus.jettison.json.JSONObject;

import co.com.simplesolutions.adminpruebas.model.Aplicacion;
import co.com.simplesolutions.adminpruebas.model.Prueba;
import co.com.simplesolutions.adminpruebas.model.Version;
import co.com.simplesolutions.adminpruebas.util.conexionDB;

public class PruebaDaoImpl implements PruebaDao {
	
	 Connection con;
	 
	@Override
	public ArrayList<Aplicacion> listarAplicacion() throws Exception {
		ArrayList<Aplicacion>  listAplicacion = new ArrayList<>();
		Aplicacion aplicacion = null;
        ResultSet resultSet;
        JSONObject json = new JSONObject(); 
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "SELECT idaplicacion, nombreaplicacion from aplicacion ";
        try {
            preparedStatement  = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	aplicacion = new Aplicacion();
            	aplicacion.setId(resultSet.getString("idaplicacion"));
            	aplicacion.setNombre(resultSet.getString("nombreaplicacion"));
            	listAplicacion.add(aplicacion);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error en listarAplicacion " + e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("error en listarAplicacion " + e);
			}
		}
		return listAplicacion;
	}
	
	@Override
	public ArrayList<Version> listarVersion(String idAplicacion) throws Exception {
		ArrayList<Version>  listVersion = new ArrayList<>();
		Version version = null;
        ResultSet resultSet;
        JSONObject json = new JSONObject(); 
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "SELECT idVersion, nombre, idAplicacion FROM version WHERE idAplicacion = ?  ";
        try {
            preparedStatement  = con.prepareStatement(sql);
            preparedStatement.setString(1, idAplicacion);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	version = new Version();
            	version.setIdAplicacion(idAplicacion);
            	version.setIdVersion(resultSet.getString("idVersion"));
            	version.setNombre(resultSet.getString("nombre"));
            	listVersion.add(version);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error en listarAplicacion " + e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("error en listarAplicacion " + e);
			}
		}
		return listVersion;
	}

	@Override
	public boolean agregarPrueba(Prueba prueba) throws Exception {
		// TODO Auto-generated method stub
		boolean respuesta = false;
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "INSERT INTO `prueba`( `aplicacion`, `version`, `nombreCiclo`, `cantidadpruebas`, `cantidadejecutadas`,"
        		+ " `cantidadfallidas`, `cantidadcompletadas`, `cantidadbloqueantes`) values (?,?,?,?,?,?,?,?) ";
        preparedStatement  = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, prueba.getIdAplicacion());
        preparedStatement.setString(2, prueba.getIdVersion());
        preparedStatement.setString(3, prueba.getNombreCiclo());
        preparedStatement.setString(4, prueba.getCantPruebas());
        preparedStatement.setString(5, prueba.getCantEjecutadas());
        preparedStatement.setString(6, prueba.getCantFallidas());
        preparedStatement.setString(7, prueba.getCantCompletadas());
        preparedStatement.setString(8, prueba.getCantBloqueantes());
        if(preparedStatement.executeUpdate() == 1) {
        	respuesta = true;
        }        
		return  respuesta;
	}

	@Override
	public ArrayList<Prueba> listarPrueba() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Prueba>  listPrueba = new ArrayList<>();
		Prueba prueba = null;
        ResultSet resultSet;
        con = conexionDB.getConexion(); 
        PreparedStatement preparedStatement = null ;
        String sql = "SELECT `idPrueba`, `aplicacion`, `version`, `nombreCiclo`, `cantidadpruebas`, `cantidadejecutadas`, "
        		+ "`cantidadfallidas`, `cantidadaprobadas`, `cantidadbloqueantes` FROM `prueba`";
        try {
            preparedStatement  = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	prueba = new Prueba();
            	prueba.setIdPrueba(resultSet.getString("idPrueba"));
            	prueba.setIdAplicacion(resultSet.getString("aplicacion"));
            	prueba.setIdVersion(resultSet.getString("version"));
            	prueba.setNombreCiclo(resultSet.getString("nombreCiclo"));
            	prueba.setCantPruebas(resultSet.getString("cantidadpruebas"));
            	prueba.setCantEjecutadas(resultSet.getString("cantidadejecutadas"));
            	prueba.setCantFallidas(resultSet.getString("cantidadfallidas"));
            	prueba.setCantCompletadas(resultSet.getString("cantidadaprobadas"));
            	prueba.setCantBloqueantes(resultSet.getString("cantidadbloqueantes"));
            	listPrueba.add(prueba);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error en listarAplicacion " + e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("error en listarAplicacion " + e);
			}
		}
		return listPrueba;
	}

}
