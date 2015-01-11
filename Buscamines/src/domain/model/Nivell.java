package domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nivell {

	@Id
	private String nom;
	@Basic
	private int nombreCasellesXFila;
	@Basic
	private int nombreCasellesXColumna;
	@Basic
	private int nombreMines;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNombreCasellesXFila() {
		return nombreCasellesXFila;
	}
	public void setNombreCasellesXFila(int nombreCasellesXFila) {
		this.nombreCasellesXFila = nombreCasellesXFila;
	}
	public int getNombreCasellesXColumna() {
		return nombreCasellesXColumna;
	}
	public void setNombreCasellesXColumna(int nombreCasellesXColumna) {
		this.nombreCasellesXColumna = nombreCasellesXColumna;
	}
	public int getNombreMines() {
		return nombreMines;
	}
	public void setNombreMines(int nombreMines) {
		this.nombreMines = nombreMines;
	}
	
	
}
