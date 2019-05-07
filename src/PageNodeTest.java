import java.util.Set;
 
import org.junit.Test;
 
//Full Name: Kenneth Shinn
//Full Name: Irene Zhang
//NETS 150: Spring 2019
 
public class PageNodeTest {
    @Test(timeout = 100000)
    public void getOutLinksTechHighTest() {
        PageNode test = new PageNode("https://en.wikipedia.org/wiki/Technology_High_School_"+
                                     "(Rohnert_Park,_California)");
        //PageNode test = new PageNode("https://en.wikipedia.org/wiki/Argentina");
        // get the outgoing links
        test.findOutgoingLinks();
       
        Set<String> outLinks = test.getOutLinks();
       
        System.out.println("********************************************");
        System.out.println("HERE ARE THE OUTGOING LINKS FOR: " + test.getURL());
        System.out.println("********************************************");
        for (String s : outLinks) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
    }
   
    @Test(timeout = 100000)
    public void getOutLinksDieboldTest() {
        PageNode test = new PageNode("https://en.wikipedia.org/wiki/Francis_X._Diebold");
       
        // get the outgoing links
        test.findOutgoingLinks();
       
        Set<String> outLinks = test.getOutLinks();
       
        System.out.println("********************************************");
        System.out.println("HERE ARE THE OUTGOING LINKS FOR: " + test.getURL());
        System.out.println("********************************************");
        for (String s : outLinks) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
    }
   
    @Test(timeout = 100000)
    public void getOutLinksArgentina() {
        PageNode test = new PageNode("https://en.wikipedia.org/wiki/Economic_history_of_Argentina");
       
        // get the outgoing links
        test.findOutgoingLinks();
       
        Set<String> outLinks = test.getOutLinks();
       
        System.out.println("********************************************");
        System.out.println("HERE ARE THE OUTGOING LINKS FOR: " + test.getURL());
        System.out.println("********************************************");
        for (String s : outLinks) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
    }
}