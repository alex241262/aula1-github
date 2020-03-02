package applocation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;

public class Program {

	public static void main(String[] args) {
		System.out.println("Ola voce entrou no Guithub");
		System.out.println("Ola Bom Dia");
//teste de orden status
		/*Order order = new Order(1080,new Date(),OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		OrderStatus os1 = OrderStatus.DELIVERED;
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		
		System.out.println(os1);
		System.out.println(os2);*/
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf =new  SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department´s name: ");
		String departmentName= ler.next();
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String workerName= ler.next();
		System.out.println("Level: ");
		String workerLevel= ler.next();
		System.out.print("Base Salary: ");
		double baseSalary = ler.nextDouble();
		Worker worker = new Worker(workerName,WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = ler.nextInt();
		for(int i=1;i<=n;i++){
			System.out.println("Enter contact n"+ i +" data:");
			System.out.println("Date(DD/MM/YYYY): ");
			Date contractDate = sdf.parse(ler.next());
			System.out.print("Valur per hour: ");
			double valuePerHour = ler.nextDouble();
			System.out.println("Duration (hours): ");
			int hours = ler.nextInt();
			HourContract contract = new HourContract(contractDate,valuePerHour,hours);
			worker.addContract(contract);
		}
		System.out.println("Enter month and year to calculete incone (MM/YYYY): ");
		String monthAndYear = ler.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+worker.getName());
		System.out.println("Derpatment: "+worker.getDepartment().getName());
		System.out.println("Income for "+ monthAndYear +": "+String.format("%.2f", worker.income(year,month)));
		
		ler.close();
	}

}
