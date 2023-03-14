package com.greatlearning.employee.email.main;

import java.util.Scanner;

import com.greatlearning.employee.email.model.Employee;
import com.greatlearning.employee.email.service.CredentialService;
import com.greatlearning.employee.email.service.CredentialServiceImpl;

public class Driver {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			CredentialService service = new CredentialServiceImpl();

			Employee emp = new Employee("Sherlock", "Holmes");
			System.out.println("Please select the department from the following ");
			System.out.println("1.Technical");
			System.out.println("2.Admin");
			System.out.println("3.Human Resouces");
			System.out.println("4.Legal");
			int choice = sc.nextInt();
			String department = null;
			switch (choice) {
			case 1:
				department = "tech";
				break;
			case 2:
				department = "admin";
				break;
			case 3:
				department = "hr";
				break;
			case 4:
				department = "lgl";
				break;
			default:
				System.out.println("Please select valid option");

			}
			if (department != null) {
				emp.setDepartment(department);

				String emailAddress = service.generateEmailAddress(emp);
				emp.setEmailAddress(emailAddress);

				String password = service.generatePassword();
				emp.setPassword(password);

				service.showCredentials(emp);

			}
		}
	}

}
