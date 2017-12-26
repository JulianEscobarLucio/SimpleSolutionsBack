package co.com.simplesolutions.adminpruebas.model;

public class Prueba {
	
	private String idPrueba;
	private String idAplicacion;
	private String idVersion;
	private String nombreCiclo;
	private String cantPruebas;
	private String cantEjecutadas;
	private String cantFallidas;
	private String cantCompletadas;
	private String cantBloqueantes;
	
	public String getIdPrueba() {
		return idPrueba;
	}
	public void setIdPrueba(String idPrueba) {
		this.idPrueba = idPrueba;
	}
	public String getIdAplicacion() {
		return idAplicacion;
	}
	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public String getIdVersion() {
		return idVersion;
	}
	public void setIdVersion(String idVersion) {
		this.idVersion = idVersion;
	}
	public String getNombreCiclo() {
		return nombreCiclo;
	}
	public void setNombreCiclo(String nombreCiclo) {
		this.nombreCiclo = nombreCiclo;
	}
	public String getCantPruebas() {
		return cantPruebas;
	}
	public void setCantPruebas(String cantPruebas) {
		this.cantPruebas = cantPruebas;
	}
	public String getCantEjecutadas() {
		return cantEjecutadas;
	}
	public void setCantEjecutadas(String cantEjecutadas) {
		this.cantEjecutadas = cantEjecutadas;
	}

	public String getCantCompletadas() {
		return cantCompletadas;
	}
	public void setCantCompletadas(String cantCompletadas) {
		this.cantCompletadas = cantCompletadas;
	}
	public String getCantBloqueantes() {
		return cantBloqueantes;
	}
	public void setCantBloqueantes(String cantBloqueantes) {
		this.cantBloqueantes = cantBloqueantes;
	}
	public String getCantFallidas() {
		return cantFallidas;
	}
	public void setCantFallidas(String cantFallidas) {
		this.cantFallidas = cantFallidas;
	}
	
	
	
	

}
