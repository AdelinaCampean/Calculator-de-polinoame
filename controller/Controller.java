package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import GUI.View;
import Model.Polinom;
import Model.Monom;

public class Controller {

	public View myV;
	public Polinom p1;
	public Polinom p2;

	public Controller(View v,Polinom p1,Polinom p2) {
		myV = v;
		this.p1=p1;
		this.p2=p2;
		myV.addListenerButon1(new adunare());
		myV.addListenerButon2(new scadere());
		myV.addListenerButon3(new inmultire());
		myV.addListenerButon4(new impartire());
		myV.addListenerButon5(new derivare());
		myV.addListenerButon6(new integrare());

	}
	
	 class adunare implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			myV.setRezultat(" ");
			p1.getPolinom().clear();
			p2.getPolinom().clear();
			String poli1 = myV.getPolinom1();
			String poli2 = myV.getPolinom2();
			Polinom result = new Polinom();
			try {
				p1.pattern(poli1);
				p2.pattern(poli2);
				System.out.println(p1.listP());
				System.out.println(p2.listP());
				result=p1.sum(p2);
				Collections.sort(result.getPolinom());
				myV.setRezultat(result.listP());
				}
				catch (Exception e){
					System.out.println(e.getMessage());
					myV.setRezultat("Polinom invalid!");
				}
		}
	}
	
	public class scadere implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
		
			myV.setRezultat(" ");	
			String poli1 = myV.getPolinom1();
			String poli2 = myV.getPolinom2();
			p1.getPolinom().clear();
			p2.getPolinom().clear();
			Polinom result = new Polinom();
			try {
				p1.pattern(poli1);
				p2.pattern(poli2);
				result=p1.sub(p2);
				Collections.sort(result.getPolinom());
				System.out.println(result.listP());
				myV.setRezultat(result.listP());
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					myV.setRezultat("Polinom invalid!");
				}
			
		}
	}
	
	public class inmultire implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0)  {
			myV.setRezultat(" ");
			String poli1 = myV.getPolinom1();
			String poli2 = myV.getPolinom2();
			p1.getPolinom().clear();
			p2.getPolinom().clear();
			Polinom result = new Polinom();
			try {
			p1.pattern(poli1);
			p2.pattern(poli2);
			result=p1.mul(p2);
			Collections.sort(result.getPolinom());
			System.out.println(result.listP());
			myV.setRezultat(result.listP());
			
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				myV.setRezultat("Polinom invalid!");
			}
		}
	}

	public class impartire implements ActionListener {
	
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	public class derivare implements ActionListener {
	
		public void actionPerformed(ActionEvent arg0) {
			myV.setRezultat(" ");
			String poli1 = myV.getPolinom1();
			p1.getPolinom().clear();
			
			Polinom result = new Polinom();
			
			try {
				p1.pattern(poli1);
				result=p1.deriv(p1);
				Collections.sort(result.getPolinom());
				System.out.println(result.listP());
				myV.setRezultat(result.listP());
			}
				catch (Exception e){
					System.out.println(e.getMessage());
					myV.setRezultat("Polinom invalid!");
				}			
			
		}
	}

	public class integrare implements ActionListener {
	
		public void actionPerformed(ActionEvent arg0) {
			myV.setRezultat(" ");
			String poli1 = myV.getPolinom1();
			String s="";
			p1.getPolinom().clear();
			p2.getPolinom().clear();
			int nr=0;
			Polinom result = new Polinom();
			try {
				p1.pattern(poli1);
				result=p1.integrare(p1);
				Collections.sort(result.getPolinom());
				ArrayList<Monom> mo =result.getPolinom();
				for(Monom i :mo) {
					nr=i.getPutere()+1;
					if(i.getNumar()<0)
						s+=i.getNumar()+"/"+String.valueOf(nr)+i.getVariabila()+"^"+String.valueOf(nr);
					else
						s+="+"+i.getNumar()+"/"+String.valueOf(nr)+i.getVariabila()+"^"+String.valueOf(nr);
				}
				myV.setRezultat(s);
				
			}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					myV.setRezultat("Polinom invalid!");
				}	
		}
	}	
	
}
