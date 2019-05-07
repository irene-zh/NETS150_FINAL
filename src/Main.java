import java.util.List;
import java.util.Scanner;

//Full Name: Kenneth Shinn
//Full Name: Irene Zhang
//NETS 150: Spring 2019

public class Main {
	public static void main(String[] args) {
		System.out.println("*************************************");
		System.out.println("***********Wikipedia  Racer**********");
		System.out.println("*************************************");
		System.out.println("Welcome to the Wikipedia Racer!");
		System.out.println("You may enter a start link and an end link");
		System.out.println("All input links *MUST* be Wikipedia links.");
		System.out.println("HIT ENTER TO START!");

		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.out.println("Please enter a start link : ");
		String arg1 = null;
		String arg2 = null;
		while(sc.hasNext()) {
			arg1 = sc.next();
			if(!arg1.contains("https://en.wikipedia.org")) {
				System.out.println("Oops. That's not on Wikipedia. Try again!");
				System.out.println("Please enter a start link : ");
				arg1 = sc.next();
			}
			System.out.println("Please enter an end link: ");
			arg2 = sc.next();
			if(!arg2.contains("https://en.wikipedia.org")) {
				System.out.println("Oops. That's not on Wikipedia. Try again!");
				System.out.println("Please enter an end link : ");
				arg2 = sc.next();
			}
			if (arg1 != null && arg2 != null) {
				System.out.println("\n*************************************");
				System.out.println("***********Path Results**************");
				System.out.println("*************************************");
				List<String> results = BFS.getPath(new PageNode(arg1), new PageNode(arg2));
				System.out.println(results);			
			}
		
		}
		
		
		
		sc.close();
	}
}
