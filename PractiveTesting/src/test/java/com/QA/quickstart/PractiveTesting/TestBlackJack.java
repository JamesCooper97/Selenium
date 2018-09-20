package com.QA.quickstart.PractiveTesting;
import static org.junit.Assert.*;
import org.junit.Test;


public class TestBlackJack {
	@Test
	public void test() {
		BlackJack blackjack = new BlackJack();
		assertEquals(17,blackjack.blackJack(17,13));
		assertEquals(10, blackjack.blackJack(10, 22));
		assertEquals(9, blackjack.blackJack(22, 9));
		assertEquals(0, blackjack.blackJack(22, 22));
		assertEquals(10, blackjack.blackJack(10, 7));
		assertEquals(19, blackjack.blackJack(1, 19));
	}
	
}