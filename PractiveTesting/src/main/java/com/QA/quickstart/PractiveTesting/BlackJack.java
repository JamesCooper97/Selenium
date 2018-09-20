package com.QA.quickstart.PractiveTesting;

public class BlackJack {
	public static void main( String[] args ) {
        blackJack(13,17);
        blackJack(12,12);
    }
    
    public static int blackJack(int a, int b) {
    	if (a>21 && b>21) return 0;
    	if (b>21 && a<=21) return a;
    	if (a>21 && b<=21) return b;
    	if (a>b) return a;
    	if (b>a) return b;
    	return 0;
    }
}
