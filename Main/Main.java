package Main;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import GUI.View;
import Model.Polinom;
import controller.Controller;

public class Main {

	public static void main(String[] args) {
		
		View vedere = new View();
		Polinom p1= new Polinom();
		Polinom p2= new Polinom();
		Controller c1=new Controller(vedere,p1,p2);
		
	
	}
}
