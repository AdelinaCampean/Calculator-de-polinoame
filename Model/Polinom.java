package Model;

import java.util.ArrayList;
import Model.Monom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom{

	private ArrayList<Monom> monoame = new ArrayList<Monom>();

	
	public Polinom(ArrayList<Monom> polinom1) {
		this.monoame=polinom1;
		
	}
	public Polinom()
	{
	}
	
	
public Polinom sum (Polinom polinom1) {
		Polinom rez = new Polinom();
		boolean val = false;
		for(Monom i:this.monoame) 
		{
			for(Monom j: polinom1.monoame)
			{
				if(i.getPutere()==j.getPutere()) {
					rez.monoame.add(new Monom(i.getNumar()+j.getNumar(),i.getVariabila(),i.getPutere()));
					//System.out.println(rez);
				}
				
			}
		}
		
		for (Monom a:this.monoame)
		{
			for(Monom b:rez.monoame)
			{
				if(a.getPutere()==b.getPutere())
				{
					val=false;
					break;
				}
				else {
					val=true; 
				}
				
			}
			if(val==true)
			{
				rez.monoame.add(new Monom(a.getNumar(),a.getVariabila(),a.getPutere()));
				val=false;
			}
		}	
		
		val=false;
		for (Monom a:polinom1.monoame)
		{
			for(Monom b:rez.monoame)
			{
				if(a.getPutere()==b.getPutere())
				{
					val=false;
					break;
				}
				else {
					val=true; 
				}
			}
			if(val==true)
			{
				rez.monoame.add(new Monom(a.getNumar(),a.getVariabila(),a.getPutere()));
				val=false;
			}
		}
		return rez;
}

public Polinom sub (Polinom polinom) {
	boolean val=false;
	Polinom rez = new Polinom();
	for(Monom i:this.monoame) 
		for(Monom j: polinom.monoame){
			if(i.getPutere()==j.getPutere()) {
				rez.monoame.add(new Monom(i.getNumar()-j.getNumar(),i.getVariabila(),i.getPutere()));	
			}
		}
	
	
		for (Monom a:this.monoame)
			{
				for(Monom b:rez.monoame)
				{
					if(a.getPutere()==b.getPutere())
					{
						val=false;
						break;
					}
					else {
						val=true; 
					}
					
				}
				if(val==true)
				{
					rez.monoame.add(new Monom(a.getNumar(),a.getVariabila(),a.getPutere()));
					val=false;
				}
			}	
			
			val=false;
			for (Monom a:polinom.monoame)
			{
				for(Monom b:rez.monoame)
				{
					if(a.getPutere()==b.getPutere())
					{
						val=false;
						break;
					}
					else {
						val=true; 
					}
				}
				if(val==true)
				{
					rez.monoame.add(new Monom(-a.getNumar(),a.getVariabila(),a.getPutere()));
					val=false;
				}
			}
	return rez;
}
	public Polinom mul (Polinom polinom) {
	Polinom rez = new Polinom();

		for(Monom i: this.monoame) 
		{
			for(Monom j: polinom.monoame)
			{
					rez.monoame.add(new Monom(i.getNumar()*j.getNumar(),j.getVariabila(),i.getPutere()+j.getPutere()));
			}
		}

		return rez;
		}
	
public Polinom deriv (Polinom polinom) {
	Polinom rez = new Polinom();
		for(Monom i:polinom.monoame) 
		{
					if (i.getPutere()>1)
					{
						rez.monoame.add(new Monom(i.getNumar()*i.getPutere(),i.getVariabila(),i.getPutere()-1));
					}
					else if (i.getPutere()==1) {
						rez.monoame.add(new Monom(i.getNumar(),'x',0));
					}
					else if (i.getPutere()==0){
						continue;
					}
				}				
		return rez;
		}


public Polinom integrare (Polinom polinom) {
	Polinom rez = new Polinom();
	for(Monom i:polinom.monoame) 
	{ 
		if (i.getPutere()>=1)
				{
					rez.monoame.add(new Monom(i.getNumar(),i.getVariabila(),i.getPutere()));
				}
				else {
					rez.monoame.add(new Monom(i.getNumar(),'x',i.getPutere()));
				}
			}
	return rez;
}

	public void pattern(String poli)  
	{
		char e=' ';
		String s = "";
		char o = ' ';
		String h = "";
		int coef=0;
		int pow =0;
		
		ArrayList<String> mono = new ArrayList<String>();

		final String regex = "[+-]?(\\d+x\\^\\d+|\\d*x?)"; 
		final Pattern pat = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher mat = pat.matcher(poli); 
		
			while (mat.find()) {
					if(mat.group().length()>0)
				mono.add(mat.group());
		}
		
		for (String d:mono) {
			if(d.contains("x")&&d.contains("^")) {	
				for (char x :d.toCharArray()) {
				if(x=='-' || x=='+')
					e=x; 
	
				if(x>='0'&&x<='9')
					s=s+x;
			
				if(x=='x'){
					o=x; 
					h=s; 
					s=""; 
				}
				
				}
			if (e=='-')
			coef = -Integer.parseInt(h);
			else 
			coef = Integer.parseInt(h);
			
			pow = Integer.parseInt(s);
	     	s="";
	     	this.monoame.add(new Monom(coef,o,pow));
		}
			else if (!(d.contains("x"))) 
			{ 
	     		
	     		for (char x :d.toCharArray())
	     		{
	     		if(x=='-' || x=='+')
	     			e=x; 

	     		if(x>='0'&&x<='9')
	     		{
	     			s=s+x;
	     		}
	     		}
	     		if (e=='-')
	     			coef = -Integer.parseInt(s);
	     			else 
	     				coef = Integer.parseInt(s);
	     	 	this.monoame.add(new Monom(coef,'x',0));
	     	}
			else if(!(d.contains("^")&& d.contains("x"))) 
	     	{
	     		for (char x :d.toCharArray())
	     		{
	     		if(x=='-' || x=='+')
	     			e=x; 

	     		if(x>='0'&&x<='9')
	     		{
	     			s=s+x;
	     		}
	     		if (x=='x')
	     		{
	     			if(s.isEmpty())
	     				s="1";
	     		}
	     		}
	     		if (e=='-')
	     			coef = -Integer.parseInt(s);
	     			else 
	     			coef = Integer.parseInt(s);
	     		this.monoame.add(new Monom(coef,'x',1));
	     		}
	s="";
	h ="";
	e=' ';
	o=' ';
	coef=0;
	pow=0;
	}
	}

	public String listP()
	{
		String w="";
		for(Monom q: this.monoame)
			if(q.getNumar()>0)
				w=w+"+"+q;
			else w=w+q;
	return w;
	}
	
	public ArrayList<Monom> getPolinom() {
		return monoame;
	}

	public void setPolinom(ArrayList<Monom> monoame) {
		this.monoame = monoame;
	}
	

}


