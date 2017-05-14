package pl.sternik.weekend.entites;

public enum Status {

	PREMIERA("Premiera"), WYPRZEDAZ("Wyprzedaż"), PRZED_SPRZEDAZ("Przed sprzedaż");

	public static final Status[] ALL = { PREMIERA, WYPRZEDAZ, PRZED_SPRZEDAZ };

	private final String name;

	private Status(final String name) {
		this.name = name;
	}

	// public static Status forName(final String name) {
	// if (name == null) {
	// throw new IllegalArgumentException("Nie mozna nula dla Status");
	// }
	// if (name.equalsIgnoreCase("NOWA")) {
	// return NOWA;
	// } else if (name.equalsIgnoreCase("DO_SPRZEDANIA")) {
	// return Status.DO_SPRZEDANIA;
	// }
	// throw new IllegalArgumentException("Nazwa \"" + name + "\" nie pasuje do
	// zadengo Statusu");
	// }
	//

	public String getName() {
		return this.name;
	}
}
