package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;

public class ContractSercvice {
	
	private Integer months;
	
	 PaypalService taxService = new PaypalService();

	public ContractSercvice(Integer months) {
		super();
		this.months = months;
	
	}
	
	public void processContract(Contract contract) {
		double basicPayment = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			int x = i;
			
			Double resultaValor = taxService.TaxService(basicPayment, x);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(contract.getDate());
			cal.add(Calendar.MONTH, x);
			Date date = cal.getTime();
			
			contract.addLista(date, resultaValor);			
			
			
		}
	}
	
	

}
