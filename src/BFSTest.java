import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

//Full Name: Kenneth Shinn
//Full Name: Irene Zhang
//NETS 150: Spring 2019
public class BFSTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullInput() {
		BFS.getPath(null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidInput() {
		PageNode n = null;
		PageNode m = null;
		BFS.getPath(n, m);
	}
	
	@Test
	public void testDistanceOne() {
		System.out.println("---Test Distance of 1---");
		long startTime = System.currentTimeMillis();		
		PageNode start1 = new PageNode("https://en.wikipedia.org/wiki/Technology_High_School_"+
                "(Rohnert_Park,_California)");
		PageNode end1 = new PageNode("https://en.wikipedia.org/wiki/Sonoma_County,_California");	
		List<String> result = BFS.getPath(start1, end1);
		System.out.println(result.toString());		
		long endTime = System.currentTimeMillis();
	    System.out.println("Took " + (endTime-startTime)/1000.0 + "s to run");
	}
	
	@Test
	public void testShortDistance() {
		System.out.println("---Test Distance of greather than 1---");
		long startTime = System.currentTimeMillis();		
		PageNode start2 = new PageNode("https://en.wikipedia.org/wiki/Kilman");
		PageNode end2 = new PageNode("https://en.wikipedia.org/wiki/Swedish_Army");	
		List<String> result = BFS.getPath(start2, end2);
		System.out.println(result.toString());		
		long endTime = System.currentTimeMillis();
	    System.out.println("Took " + (endTime-startTime)/1000.0 + "s to run");
	}
	
	@Test
	public void testDistanceZero() {
		System.out.println("---Test Distance of 0---");
		long startTime = System.currentTimeMillis();		
		PageNode start2 = new PageNode("https://en.wikipedia.org/wiki/Kilman");
		PageNode end2 = new PageNode("https://en.wikipedia.org/wiki/Kilman");	
		List<String> result = BFS.getPath(start2, end2);
		System.out.println(result.toString());		
		long endTime = System.currentTimeMillis();
	    System.out.println("Took " + (endTime-startTime)/1000.0 + "s to run");
		
	}
}
