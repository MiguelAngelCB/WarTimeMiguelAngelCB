package vista.Conversores;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import ensayos.EspecialidadSoldadosEnsayo;
import modelo.Especialidad;
import modelo.Tipo;
import vista.info.EspecialidadSoldadoInfo;

public class Generador {

	public static ArrayList<Especialidad> getEspecialidades(Tipo tipo) {
		return null;
	}

	public static ArrayList<EspecialidadSoldadosEnsayo> getEspecialidadesEnsayo(Tipo tipo,FocusAdapter focusAdapter) {
		ArrayList<EspecialidadSoldadosEnsayo> panelesEspecialidadSoldadosEnsayos=new ArrayList<EspecialidadSoldadosEnsayo>();
		for (Especialidad especialidad : Arrays.asList(Especialidad.values())) {
			if(especialidad.getTipo()==tipo) {
				panelesEspecialidadSoldadosEnsayos.add(new EspecialidadSoldadosEnsayo(new EspecialidadSoldadoInfo(especialidad),focusAdapter));
			}
		}
		return panelesEspecialidadSoldadosEnsayos;
	}

}
