package vista.Conversores;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import modelo.Batallon;
import modelo.Especialidad;
import modelo.Tipo;
import vista.EspecialidadSoldado;
import vista.info.EspecialidadSoldadoInfo;
import vista.info.MercadoSoldadoInfo;

public class Generador {

	public static ArrayList<EspecialidadSoldado> getEspecialidades(Tipo tipo,FocusAdapter focusAdapter) {
		ArrayList<EspecialidadSoldado> panelesEspecialidadSoldadosEnsayos=new ArrayList<EspecialidadSoldado>();
		for (Especialidad especialidad : Arrays.asList(Especialidad.values())) {
			if(especialidad.getTipo()==tipo) {
				panelesEspecialidadSoldadosEnsayos.add(new EspecialidadSoldado(new EspecialidadSoldadoInfo(especialidad),focusAdapter));
			}
		}
		return panelesEspecialidadSoldadosEnsayos;
	}

	public static MercadoSoldadoInfo getMercadoSoldadoInfo(Batallon batallon) {
		return new MercadoSoldadoInfo(batallon);
	}

}
