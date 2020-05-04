package control;

import java.util.List;

import modelo.Batallon;
import modelo.Soldado;
import vista.info.EspecificacionSoldadosInfo;

public class PobladorController {

	// porque el controller SI que tiene acceso al modelo
	//De donde sale ese batallon???
	private Batallon batallon;

	

	public Batallon getBatallon() {
		return batallon;
	}



	public PobladorController(Batallon batallon) {
		super();
		this.batallon = batallon;
	}

	public void poblarBatallon(List<EspecificacionSoldadosInfo> especificacion) {
		assert especificacion != null;
		for (EspecificacionSoldadosInfo especificacionSoldadosInfo : especificacion) {
			for (int i = 0; i < especificacionSoldadosInfo.getCantidad(); i++) {
				this.batallon.alistarSoldado(new Soldado(especificacionSoldadosInfo.getEspecialidad()));
			}
		}

	}
}
