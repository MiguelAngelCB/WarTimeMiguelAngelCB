package vista.Conversores;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import control.Juego;
import modelo.Batallon;
import modelo.Casilla;
import modelo.Castillo;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Tablero;
import modelo.Tipo;
import vista.EspecialidadSoldado;
import vista.FichaBatallon;
import vista.FichaBlanca;
import vista.info.EjercitoInfo;
import vista.info.EspecialidadSoldadoInfo;
import vista.info.FichaBatallonInfo;
import vista.info.FichaBlancaInfo;
import vista.info.FichaCastilloInfo;
import vista.info.FichaInfo;
import vista.info.MercadoSoldadoInfo;
import vista.info.TableroUIInfo;

public class Generador {

	public static ArrayList<EspecialidadSoldado> getEspecialidades(Tipo tipo, FocusAdapter focusAdapter) {
		ArrayList<EspecialidadSoldado> panelesEspecialidadSoldadosEnsayos = new ArrayList<EspecialidadSoldado>();
		for (Especialidad especialidad : Arrays.asList(Especialidad.values())) {
			if (especialidad.getTipo() == tipo) {
				panelesEspecialidadSoldadosEnsayos
						.add(new EspecialidadSoldado(new EspecialidadSoldadoInfo(especialidad), focusAdapter));
			}
		}
		return panelesEspecialidadSoldadosEnsayos;
	}

	public static MercadoSoldadoInfo getMercadoSoldadoInfo(Batallon batallon) {
		return new MercadoSoldadoInfo(batallon);
	}

	public static EjercitoInfo getEjercitoInfo(Ejercito ejercito) {
		return new EjercitoInfo(ejercito.getId(), ejercito.getIdBatallonActual(), ejercito.getTipoBatallon(),
				ejercito.getInfanteria(), ejercito.getCaballeria(), ejercito.getArqueria());
	}

	public static FichaInfo getFichaInfo(Juego juego, Coordenada coordenada) {
		Casilla casilla = juego.getCasilla(coordenada);
		return casilla.getInfo(juego.getEjercitoActual());
	}

	public static TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego);
	}
}
