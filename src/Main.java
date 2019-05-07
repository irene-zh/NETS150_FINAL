import java.util.Scanner;

//Full Name: Kenneth Shinn
//Full Name: Irene Zhang
//NETS 150: Spring 2019

public class Main {
	public static void main(String[] args) {
		System.out.println("*************************************");
		System.out.println("********NETS 150 FINAL PROJECT*******");
		System.out.println("*************************************");
		System.out.println("Welcome to the Wikipedia Racer!");
		System.out.println("All input links *MUST* be Wikipedia links.");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a start link : ");
		String arg1 = sc.next();
		System.out.println("Please enter an end link: ");
		String arg2 = sc.next();
		
		
		System.out.println(arg1+ arg2);
		

	}
}
