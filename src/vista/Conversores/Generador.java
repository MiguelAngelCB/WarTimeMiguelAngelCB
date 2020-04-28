package vista.Conversores;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Especialidad;
import modelo.Tablero;
import modelo.Tipo;
import vista.EspecialidadSoldado;
import vista.Ficha;
import vista.FichaBlanca;
import vista.info.EjercitoInfo;
import vista.info.EspecialidadSoldadoInfo;
import vista.info.FichaInfo;
import vista.info.MercadoSoldadoInfo;

public class Generador {
	private final static String[] imagenes = { "/Imagenes/Infanteria.jpg", "/Imagenes/Caballeria.png",
			"/Imagenes/Arqueria.jpg" };

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

	private static FichaInfo getFichaInfo(Tablero tablero, Coordenada coordenada) {
		Casilla casilla = tablero.getCasilla(coordenada);
		FichaInfo fichaInfo = null;
		if (casilla != null) {
			Batallon batallon = (Batallon) casilla;
			// TODO cambiar cuando el batallon tenga todos los valores para la ficha
			String imagen = conseguirImagenBatallon(batallon);
			fichaInfo = new FichaInfo(imagen, 10, batallon.getId(), 10, 10, 10, 10, batallon.getMaximoSoldados(), false,
					Color.GREEN, Color.RED);
			if (mitadTablero(tablero, coordenada)) {
				fichaInfo.setColorPrimario(Color.RED);
				fichaInfo.setColorSecundario(Color.GREEN);
			}
		}
		return fichaInfo;
	}

	private static String conseguirImagenBatallon(Batallon batallon) {
		int i = 0;
		for (Tipo tipo : Arrays.asList(Tipo.values())) {
			if (tipo == batallon.getTipo()) {
				return imagenes[i];
			}
			i++;
		}
		return null;
	}

	public static boolean mitadTablero(Tablero tablero, Coordenada coordenada) {
		return (coordenada.getY() > (tablero.getAncho() / 2) - 1);
	}

	public static Coordenada obtenCoordenada(String name) {
		int pos = name.length() / 2;
		return new Coordenada(Integer.valueOf(name.substring(0, pos)),
				Integer.valueOf(name.substring(pos, name.length())));
	}

	public static JPanel getFicha(Tablero tablero, Coordenada coordenada) {
		FichaInfo fichaInfo = getFichaInfo(tablero, coordenada);
		if (fichaInfo == null) {
			return new FichaBlanca();
		}
		return new Ficha(fichaInfo);
	}
}
