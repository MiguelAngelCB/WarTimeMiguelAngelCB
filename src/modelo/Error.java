package modelo;

public enum Error {

	posicion("posicion no valida"), ocupada("La casilla no esta libre"),noerror("");
	
	private String mensaje;

	private Error(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
