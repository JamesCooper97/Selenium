package com.QA.practice.tax;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestTax {

	@Test
	public void test() {
		Runner runner = new Runner();
		assertEquals("iugiu",3000,runner.netSalary(20000),0.01);
		assertEquals("waka waka", 0.20 * 33333,runner.netSalary(33334),0.01);
	}
}
