package utiles;

import modelo.Coordenada;

public class Utiles {
	// Todos los metodos aqui definidos (o casi todos) se pasan a clases para dejar
		// de ser estaticos
	//TODO un test si sabes lo que te conviene
	
	public static String nombrar(int i, int j) {
		return String.valueOf(i)+":"+String.valueOf(j);
	}
	public static Coordenada getCoordenada(String coordenada) {
		String[] split = coordenada.split(":");
		return new Coordenada(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
	}

}
