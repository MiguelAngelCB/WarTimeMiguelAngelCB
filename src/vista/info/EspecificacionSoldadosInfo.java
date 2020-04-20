package vista.info;

import modelo.Especialidad;

public class EspecificacionSoldadosInfo {
	private Especialidad especialidad;
	private int cantidad;

	//TODO cambiar String por Especialidad
	public EspecificacionSoldadosInfo(String especialidad, int cantidad) {
		super();
		this.especialidad = Especialidad.getTipoPorNombre(especialidad);
		this.cantidad = cantidad;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public int getCantidad() {
		return cantidad;
	}

}
