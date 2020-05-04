package vista.Conversores;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import control.Juego;
import modelo.Batallon;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Tablero;
import modelo.Tipo;
import vista.EspecialidadSoldado;
import vista.info.EjercitoInfo;
import vista.info.EspecialidadSoldadoInfo;
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

	public static FichaInfo getFichaInfo(Tablero tablero, Coordenada coordenada) {
		Casilla casilla = tablero.getCasilla(coordenada);
		FichaInfo fichaInfo = null;
		if (casilla != null) {
			Batallon batallon = (Batallon) casilla;
			// TODO cambiar cuando el batallon tenga todos los valores para la ficha
			String imagen = conseguirImagenBatallon(batallon);
			fichaInfo = new FichaInfo(imagen, -1, batallon.getId(), -1, -1, -1, -1, batallon.getMaximoSoldados(), false,
					Color.GREEN, Color.RED);
			if (tablero.mitadTablero(coordenada)) {
				fichaInfo.setColorArmy(Color.RED);
				fichaInfo.setColorEnemy(Color.GREEN);
			}
		}
		return fichaInfo;
	}

	private static String conseguirImagenBatallon(Batallon batallon) {
		String[] imagenes = { "/Imagenes/infanteria.png", "/Imagenes/caballeria.png", "/Imagenes/arqueria.png" };
		int i = 0;
		for (Tipo tipo : Arrays.asList(Tipo.values())) {
			if (tipo == batallon.getTipo()) {
				return imagenes[i];
			}
			i++;
		}
		return null;
	}

	public static TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego.getTablero());
	}
}
