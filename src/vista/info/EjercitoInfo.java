package vista.info;


import modelo.Tipo;

public class EjercitoInfo {
	private int EjercitoID;
	private int BattallonActual;
	private Tipo tipoActual;
	private int infanteria;
	private int caballeria;
	private int arqueria;

	

	public EjercitoInfo(int armyID, int currentBattalion, Tipo currentSquad, int infanteria, int caballeria,
			int arqueria) {
		super();
		this.EjercitoID = armyID;
		this.BattallonActual = currentBattalion;
		this.tipoActual = currentSquad;
		this.infanteria = infanteria;
		this.caballeria = caballeria;
		this.arqueria = arqueria;
	}

	public int getArmyID() {
		return EjercitoID;
	}

	public Tipo getCurrentSquad() {
		return tipoActual;
	}

	public int getCurrentBattalion() {
		return BattallonActual;
	}

	public int getInfanteria() {
		return infanteria;
	}

	public int getCaballeria() {
		return caballeria;
	}

	public int getArqueria() {
		return arqueria;
	}
	
	
}
