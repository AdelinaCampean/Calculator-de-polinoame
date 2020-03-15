package Model;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import java.util.Collections;
import junit.framework.TestCase;

public class teste extends TestCase {
		String resultSum="+5x^3-2x^2+8x^1+3x^0";
		String resultSub="-5x^3+8x^2-4x^1-11x^0";
		String resultMul="+15x^5-15x^4+10x^4+18x^3-10x^3-20x^3+21x^2+12x^2+20x^2+14x^1-24x^1-28x^0";
		String resultDer="+6x^1+2x^0";
		String resultInt="+3/3x^3+2/2x^2-4/1x^1";
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		
		public teste()
		{
		}
		@Test
		public void testAdd()
		{
			Polinom res = new Polinom();
			p1.pattern("3x^2+2x-4");
			p2.pattern("5x^3-5x^2+6x+7");
			res=p1.sum(p2);
			Collections.sort(res.getPolinom());
			System.out.println(res.listP());
			assertEquals(res.listP(),resultSum);
			//assertEquals(1,1);
		}
		@Test
		public void testSubs()
		{
			Polinom res = new Polinom();
			p1.pattern("3x^2+2x-4");
			p2.pattern("5x^3-5x^2+6x+7");
			res=p1.sub(p2);
			Collections.sort(res.getPolinom());
			assertEquals(res.listP(),resultSub);
		}
		@Test
		public void testMult()
		{
			Polinom res = new Polinom();
			p1.pattern("3x^2+2x-4");
			p2.pattern("5x^3-5x^2+6x+7");
			res=p1.mul(p2);
			Collections.sort(res.getPolinom());
			assertEquals(res.listP(),resultMul);
		}
		@Test
		public void testDeriv()
		{
			Polinom res = new Polinom();
			p1.pattern("3x^2+2x-4");
			res=p1.deriv(p1);
			Collections.sort(res.getPolinom());

			assertEquals(res.listP(),resultDer);
		}
		@Test
		public void testInteg()
		{
			int nr=0;
			String s="";
			Polinom result = new Polinom();
			p1.pattern("3x^2+2x-4");
			
			result=p1.integrare(p1);
			Collections.sort(result.getPolinom());
			ArrayList<Monom> mo =result.getPolinom();
			
			for(Monom i :mo)
			{nr=i.getPutere()+1;
				if(i.getNumar()<0)
				
				s+=i.getNumar()+"/"+String.valueOf(nr)+i.getVariabila()+"^"+String.valueOf(nr);
				else
					s+="+"+i.getNumar()+"/"+String.valueOf(nr)+i.getVariabila()+"^"+String.valueOf(nr);
		}
			assertEquals(resultInt,s);
		}
}
