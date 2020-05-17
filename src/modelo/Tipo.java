package modelo;

public enum Tipo {
	infanteria(new Range(1, 1), new Range(1, 1)), arqueria(new Range(1, 1), new Range(1, 1)),
	caballeria(new Range(1, 2), new Range(1, 2));

	private Range movinRange, attackRange;

	private Tipo(Range movinRange, Range attackRange) {
		this.movinRange = movinRange;
		this.attackRange = attackRange;
	}

	public Range getMovinRange() {
		return movinRange;
	}

	public Range getAttackRange() {
		return attackRange;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
