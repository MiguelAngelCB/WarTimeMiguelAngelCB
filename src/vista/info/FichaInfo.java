package vista.info;

import java.awt.Color;

public class FichaInfo {
	private String icon;
	private int army;
	private int battalion;
	private int experience;
	private int attack;
	private int defence;
	private int stamina;
	private int units;
	private boolean heroe;
	private Color colorPrimario;
	private Color colorSecundario;

	public FichaInfo(String icon, int army, int battalion, int experience, int attack, int defence, int stamina,
			int units, boolean heroe, Color colorPrimario, Color colorSecundario) {
		super();
		this.icon = icon;
		this.army = army;
		this.battalion = battalion;
		this.experience = experience;
		this.attack = attack;
		this.defence = defence;
		this.stamina = stamina;
		this.units = units;
		this.heroe = heroe;
		this.colorPrimario = colorPrimario;
		this.colorSecundario = colorSecundario;
	}

	public String getIcon() {
		return icon;
	}

	public int getArmy() {
		return army;
	}

	public int getBattalion() {
		return battalion;
	}

	public int getExperience() {
		return experience;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefence() {
		return defence;
	}

	public int getStamina() {
		return stamina;
	}

	public int getUnits() {
		return units;
	}

	public char getHeroe() {
		char response = ' ';
		if (heroe) {
			response = 'H';
		}
		return response;
	}

	public Color getColorArmy() {
		return colorPrimario;
	}

	public Color getColorEnemy() {
		return colorSecundario;
	}

	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

}
