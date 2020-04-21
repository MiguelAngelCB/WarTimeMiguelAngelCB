package modelo;

import java.util.Arrays;

public enum Especialidad {
	
	espada(Tipo.infanteria),lanza(Tipo.infanteria),arco(Tipo.arqueria),ballesta(Tipo.arqueria),
	ligera(Tipo.caballeria),pesada(Tipo.caballeria);
	private Tipo tipo;

	private Especialidad(Tipo tipo) {
		this.tipo = tipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public static Especialidad getTipoPorNombre(String especialidad) {
		
		for (Especialidad especial : Arrays.asList(Especialidad.values())) {
			if(especial.toString().equals(especialidad)) {
				return especial;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
