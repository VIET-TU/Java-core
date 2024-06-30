package test;

import code_a.ViDu;

public class test {
	public static void main(String[] args) {
		ViDu vd = new ViDu(1, 2);
		
		code_b.ViDu vdb = new code_b.ViDu(4, 5, 6);
		
		System.out.println(""+vd.getA());
		System.out.println(""+vdb.getC());
		
	}
}
