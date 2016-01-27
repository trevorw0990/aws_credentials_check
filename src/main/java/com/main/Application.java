package com.main;

import java.util.Scanner;

import com.explorer.EC2Explorer;
import com.explorer.S3Explorer;

public class Application {

	static S3Explorer s3 = new S3Explorer();

	static EC2Explorer ec2 = new EC2Explorer();

	public static void main(String[] args) {

		userInput();

	}

	public static String userInput() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose from the following arguments: \n s3 \n ec2");
		System.out.print("Please enter your selection: ");
		String selection = scanner.nextLine();

		switch (selection) {

		case "s3":
			inputResponse(selection);
			s3.listBuckets();
			break;
		case "ec2":
			inputResponse(selection);
			ec2.listInstance();
			break;
		default:
			System.out.println("No response given or incorrect argument value... lets try again! \n");
			userInput();
			break;

		}

		scanner.close();

		return selection;

	}

	public static void usage() {
		String usage = "Choose from the following arguments: \n s3 \n ec2";
		String example = "Example: java -jar api-tester.jar s3";

		System.out.println(usage);
		System.out.println(example);

	}

	public static void inputResponse(String argument) {

		String returnVal = "Checking service: " + argument + " for appropriate credentials";

		System.out.println(returnVal);

	}
}
