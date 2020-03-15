package GUI;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import Model.Monom;
import Model.Polinom;
import controller.Controller;

public class View extends JFrame {

	private JFrame frame;
	private JTextField polinom1 = new JTextField();
	private JTextField polinom2 = new JTextField();
	private JTextField rezultat = new JTextField();
	private JButton adunare = new JButton("+");
	private JButton scadere = new JButton("-");
	private JButton inmultire = new JButton("*");
	private JButton impartire = new JButton("/");
	private JButton derivare = new JButton("Derivare");
	private JButton integrare = new JButton("Integrare");
	
	public View() {
		
		JFrame frame = new JFrame("Operatii pe polinoame!");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 400);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);	
		
		JLabel text = new JLabel("Polinom 1: ");
		text.setBounds(10, 30, 90, 30);
		panel.add(text);
		
		polinom1.setBounds(100, 30, 240, 30);
		panel.add(polinom1);

		JLabel text2 = new JLabel("Polinom 2: ");
		text2.setBounds(10, 80, 90, 30);
		panel.add(text2);
		
		polinom2.setBounds(100, 80, 240, 30);
		panel.add(polinom2);
		
		adunare.setBounds(0, 150, 45, 45);
		panel.add(adunare);
		
		scadere.setBounds(60, 150, 45, 45);
		panel.add(scadere);
		
		inmultire.setBounds(120, 150, 45, 45);
		panel.add(inmultire);
		
		impartire.setBounds(180, 150, 45, 45);
		panel.add(impartire);
		
		derivare.setBounds(240, 150, 90, 45);
		panel.add(derivare);
		
		integrare.setBounds(345, 150, 90, 45);
		panel.add(integrare);
		
		JLabel rez = new JLabel("Rezultat: ");
		rez.setBounds(10, 240, 90, 30);
		panel.add(rez);
		
		rezultat.setBounds(100, 240, 240, 30);
		panel.add(rezultat);
		
		frame.add(panel);
		frame.setVisible(true);
}

	public String getRezultat() {
		return rezultat.getText();
	}
	public void setRezultat(String rezultat) {
		this.rezultat.setText(rezultat);
	}

	public String getPolinom1() {
		return polinom1.getText().toString();
	}

	public String getPolinom2() {
		return polinom2.getText().toString();
	}

	
	public JButton getAdunare() {
		return adunare;
	}


	public void setAdunare(JButton adunare) {
		this.adunare = adunare;
	}


	public JButton getScadere() {
		return scadere;
	}


	public void setScadere(JButton scadere) {
		this.scadere = scadere;
	}


	public JButton getInmultire() {
		return inmultire;
	}


	public void setInmultire(JButton inmultire) {
		this.inmultire = inmultire;
	}


	public JButton getImpartire() {
		return impartire;
	}


	public void setImpartire(JButton impartire) {
		this.impartire = impartire;
	}


	public void addListenerButon1(ActionListener adunare2) {
		adunare.addActionListener(adunare2);
	}


	public void addListenerButon2(ActionListener scadere2) {
		scadere.addActionListener(scadere2);
	}


	public void addListenerButon3(ActionListener inmultire2) {
		inmultire.addActionListener(inmultire2);
		
	}


	public void addListenerButon4(ActionListener impartire2) {
		impartire.addActionListener(impartire2);
		
	}


	public void addListenerButon5(ActionListener derivare2) {
		derivare.addActionListener(derivare2);
		
	}


	public void addListenerButon6(ActionListener integrare2) {
		integrare.addActionListener(integrare2);
		
	}
	

}