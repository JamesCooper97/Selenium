package com.QA.practice.tax;

public class Runner {
	public static double netSalary(int salary) {
		int taxTotal = 0;
		int chopped = 0;
		int netSalary;
		if (salary>=150000) {
			taxTotal += (salary-150000) * 0.45;
			chopped += salary-150000;
		}
		if (salary>=46351) {
			taxTotal += (salary-chopped-46351) * 0.4;
			chopped += chopped + salary - 46351
		}
		netSalary = salary - taxTotal;
		return netSalary;
	}
}
