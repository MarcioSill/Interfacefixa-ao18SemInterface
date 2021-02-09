package model.service;

public class PaypalService {
     	public Double TaxService(double amount, int x) {
     		double result = amount + amount * 0.01 * x;
     		return result * 1.02;
     	}
}
