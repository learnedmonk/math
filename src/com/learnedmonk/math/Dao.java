package com.learnedmonk.math;

import java.util.Random;

public class Dao {
	
	public static class Q{
		public String exp;
		public int val;
		Q(String exp, int val){
			this.exp = exp;
			this.val = val;
		}
	}
	
	public static Q[] generate(int level, int no){
		
		Q[] qs = new Q[no];
		
		Random r = new Random();
		
		for( int i = 0; i < qs.length; i++){
			
			int a = r.nextInt(10) + 1;
			
			int b = r.nextInt(20) + 2;
			
			int v = 0;
			
			if ( Math.random() < 0.4){
				v = a + b;
				qs[i] = new Q(a+" + "+b,v);
			}else{
				if ( a > b ){
					v = a - b;
					qs[i] = new Q(a+" - "+b,v);
				}else{
					v = b - a;
					qs[i] = new Q(b+" - "+a,v);
				}
			}
			
		}
		return qs;
		
	}

}
