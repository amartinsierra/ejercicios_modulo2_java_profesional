package model;

public class Pais {
	private String nombre;
	private String capital;
	private long habitantes;
	private String continente;
	public Pais(String nombre, String capital, long habitantes) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.habitantes = habitantes;
	}
	
	public Pais(String nombre, String capital, long habitantes, String continente) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.habitantes = habitantes;
		this.continente = continente;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}
	
	
}
