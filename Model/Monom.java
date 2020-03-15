package Model;

import java.io.Serializable;
import java.lang.Object;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Monom implements Comparable{
	
	private int numar;
	private char variabila; //x 
	private int putere;
	private int a;
	
	public int getA() {
		return a;
	}

	
	public void setA(int a) {
		this.a = a;
	}

	public Monom(int numar, char variabila, int putere)
	{
		this.numar=numar;
		this.variabila=variabila;
		this.putere=putere;
		a=1;
	}
	
	public Monom()
	{
		
	}
	
	public Monom(int numar)
	{
		this.numar=numar;
		a=3;
	}
	
	public Monom(int numar, char variabila)
	{
		this.numar=numar;
		this.variabila=variabila;
		a=2;
	}

	public int getNumar() {
		return numar;
	}

	
	/*public String listM(int a) {
		if(a==1)
		return String.valueOf(numar)+this.variabila+"^"+String.valueOf(putere);
		else if(a==2) return String.valueOf(numar)+this.variabila+"";
		else return String.valueOf(numar)+"";
	}*/

	public String toString() {
		return String.valueOf(numar)+this.variabila+"^"+String.valueOf(putere);
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public char getVariabila() {
		return variabila;
	}

	public void setVariabila(char variabila) {
		this.variabila = variabila;
	}

	public int getPutere() {
		return putere;
	}

	public void setPutere(int putere) {
		this.putere = putere;
	}

	public int compareTo(Object o) {
		Monom p= (Monom) o;
		if (this.putere>p.putere)
			return -1;
		if (this.putere<p.putere)
			return 1;
		else
		return 0;
	}
		
}
