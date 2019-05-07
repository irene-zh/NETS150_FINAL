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
		System.out.println("All input links *MUST* be Wikipedia links.");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a start link : ");
		String arg1 = "";
		String arg2 = "";
		while(sc.hasNext()) {
			arg1 = sc.next();
			if(!arg1.contains("https://en.wikipedia.org")) {
				
			}
			System.out.println("Please enter an end link: ");
			arg2 = sc.next();
		
		}
		sc.close();
		System.out.println("*************************************");
		System.out.println("***********Path Results**************");
		System.out.println("*************************************");
		List<String> results = BFS.getPath(new PageNode(arg1), new PageNode(arg2));
		System.out.println(results);
		

	}
}
