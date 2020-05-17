package modelo;

public class Soldado {

	private Especialidad especialidad;
	private final int staminaMaxima = 100;
	private int stamina = staminaMaxima;
	private final int staminaCritica = 20;
	private int experiencia = 1;
	private int defensa = 1;
	private int ataque = 1;

	public Soldado(Especialidad especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public int getStamina() {
		return stamina;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public float atacar() {
		// TODO aplicar formula de ataque
		return -1;
	}

	public float defender() {
		// TODO aqui se aplica la formula de defensa
		return -1;
	}

	public void incrementarExperiencia() {
		// TODO Auto-generated method stub
	}

	public void incrementarDefensa() {
		// TODO Auto-generated method stub

	}

	public void incrementaAtaque() {
		// TODO Auto-generated method stub

	}

	public boolean isCriticaStamina() {
		// TODO Auto-generated method stub
		return false;
	}

}