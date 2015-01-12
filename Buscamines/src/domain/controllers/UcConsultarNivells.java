package domain.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.dataInterface.CtrlDataFactory;
import domain.model.Nivell;

public class UcConsultarNivells {
	
	public UcConsultarNivells() {
		
	}
	
	public List<TupleNivells> obtenirNivells() throws IOException {
		CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		List<Nivell> allNivells;
		try {
			allNivells = ctrlDataFactory.getCtrlNivell().getAll();
		} catch (IOException e) {
			throw e;
		}
		List<TupleNivells> result = new ArrayList<TupleNivells>();
		for (Nivell nivell : allNivells) {
			TupleNivells tuple = new TupleNivells();
			tuple.nom = nivell.getNom();
			tuple.nombreCasellesxFila = nivell.getNombreCasellesXFila();
			tuple.nombreCasellesxColumna = nivell.getNombreCasellesXColumna();
			tuple.nombreMines = nivell.getNombreMines();
			result.add(tuple);
		}
		return result;	
	}
	
	public class TupleNivells {
		public String nom;
		public int nombreCasellesxFila;
		public int nombreCasellesxColumna;
		public int nombreMines;
	}
}
