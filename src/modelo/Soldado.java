package modelo;

public class Soldado {
	private Especialidad especialidad;
	private final int staminaMaxima=100; 
	private int stamina=staminaMaxima;
	private int experiencia=1;
	private int defensa=1;
	private int ataque=1;

	public Soldado(Especialidad especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}
	
	public void atacar() {
		
	}
	public void defender() {
		
	}
}
