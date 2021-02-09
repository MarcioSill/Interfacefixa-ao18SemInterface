package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractSercvice;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();		
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		int x = sc.nextInt();
		
		ContractSercvice contracService = new ContractSercvice(x);
		contracService.processContract(contract);
		
		System.out.println("Installments:");
		
		for(Installment emp : contract.getList()) {
			
			System.out.print(sdf.format(emp.getDueDate()) + " ");
			System.out.println(String.format("%.2f", emp.getAmount()));
		}
		sc.close();

	}

}
