package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Trabajador{

	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty street;
	private final StringProperty city;
	private final StringProperty turno;
	private final StringProperty idiomas;

	public Trabajador() {
		this(null, null);
	}

	public Trabajador(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);

		this.street = new SimpleStringProperty("Calle X");
		this.city = new SimpleStringProperty("Madrid");
		this.turno = new SimpleStringProperty("Mañana");
		this.idiomas = new SimpleStringProperty("Español");
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public String getStreet() {
		return street.get();
	}

	public void setStreet(String street) {
		this.street.set(street);
	}

	public StringProperty streetProperty() {
		return street;
	}

	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty cityProperty() {
		return city;
	}

	public String getTurno() {
		return turno.get();
	}

	public void setTurno(String turno) {
		this.turno.set(turno);
	}

	public StringProperty turnoProperty() {
		return turno;
	}

	public String getIdiomas() {
		return idiomas.get();
	}

	public void setIdiomas(String idiomas) {
		this.idiomas.set(idiomas);
	}

	public StringProperty idiomasProperty() {
		return idiomas;
	}

}
