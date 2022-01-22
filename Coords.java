package it.unibs.fdp.planetarium;

import java.util.regex.Pattern;

import it.unibs.fp.mylib.InputDati;

public class Coords {
	private double x;
	private double y;
	
	//Metodo costruttore
	public Coords(double x, double y) {
		this.x = x;
		this.y = y;
	}

	//Getters
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	//Setters
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	//Metodo Equals, ritorna true se la x e la y corrispondono
	public boolean equals(Coords c) {
		return this.x == c.getX() && this.y == c.getY();
	}

	//Metodo per l'input delle coordinate da tastiera
	public static Coords leggiCoordinate(String messaggio) {
		//Prendo in input una stringa con sintassi = 1.0;2.0 (finché l'input non è valido)
		String coordinate;
		boolean finito = false;
		
		//Prendo in input le coordinate finché non sono valide (il replace permette di fare l'input sia con '.' che con ','
		do {
			coordinate = InputDati.leggiStringa(messaggio).replace(',', '.');
			
			if(validateCoords(coordinate))
				finito = true;
			else
				System.out.println("Errore di sintassi");
		}while(!finito);
		
		//Creo delle sottostringhe che metto in parts, separando la stringa originale dove ci sono i caratteri ';'
		String[] parts = coordinate.split(";");
		
		//Parso le sottostringhe in double
		double x = Double.parseDouble(parts[0]);
		double y = Double.parseDouble(parts[1]);
		
		//Ritorno delle nuove coordinate
		return new Coords(x, y);
	}
	
	//Verifica se una stringa è una valida coordinata
	public static boolean validateCoords(String str) {
		String[] parts = str.split(";");
		if(parts.length != 2)
			return false;
		//^[-+]?[0-9]+([\,|\.][0-9]+)?$ regex
		// [+-]? = possibili "+" e "-", [0-9]+ = 1+ corrispondenze, gruppo dopo il + opzionale per i decimali (con virgola o punto)
		return Pattern.matches("^[-+]?[0-9]+([\\,|\\.][0-9]+)?$",parts[0]) && Pattern.matches("^[-+]?[0-9]+([\\,|\\.][0-9]+)?$",parts[1]);
	}

	@Override
	public String toString() {
		return "(" + String.format("%.3f", x) + "; " + String.format("%.3f", y) + ")";
	}
	
}