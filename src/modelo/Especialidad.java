package modelo;

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
	
	
}
