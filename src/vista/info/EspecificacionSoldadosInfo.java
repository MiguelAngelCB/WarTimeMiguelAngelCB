package vista.info;

public class EspecificacionSoldadosInfo {
	private String especialidad;
	private int cantidad;

	//TODO cambiar String por Especialidad
	public EspecificacionSoldadosInfo(String especialidad, int cantidad) {
		super();
		this.especialidad = especialidad;
		this.cantidad = cantidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public int getCantidad() {
		return cantidad;
	}

}
