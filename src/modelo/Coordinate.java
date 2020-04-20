package modelo;

public class Coordinate {
	private int x, y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		boolean response = super.equals(obj);
		if (!response) {
			Coordinate parametro = (Coordinate) obj;
			response = this.getX() == parametro.getX() && this.getY() == parametro.getY();
		}
		return response;
	}
	@Override
	public int hashCode() {
		return getX()*10+getY();
	}
	@Override
	public String toString() {
		return getX()+":"+getY()+"::"+hashCode();
	}
}
