import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
//Full Name: Kenneth Shinn
//Full Name: Irene Zhang
//NETS 150: Spring 2019
 
public class PageNode {
    /*
     * fields
     */
    private String url;
    private Document page;
    private Map<String, PageNode> outLinks;
    private static String WIKI_LINK_PREFIX = "https://en.wikipedia.org";
   
    /*
     * The constructor for the page node object
     *
     * @param the url of the wikipedia page
     * @throws an IllegalArgumentException of the input is null, or does not start with the
     * Wikipedia link prefix
     */
    public PageNode(String url) {
        // check for a valid url input
        if (url == null) {
            throw new IllegalArgumentException();
        } else if (url.length() < WIKI_LINK_PREFIX.length()) {
            throw new IllegalArgumentException();
        }
        if(!url.contains(WIKI_LINK_PREFIX)) {
        throw new IllegalArgumentException();
        }
       
        this.url = url;
       
        // create the document object using JSoup
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException e) {
            // if the page doesn't load then just move on
            page = null;
        }
       
        outLinks = new HashMap<String, PageNode>();
    }
   
    /*
     * This method will load the outgoing links for this page
     *
     * This method caps the number of outgoing links to 10, so that the memory usage and number
     * of considered nodes does not explode.
     */
    public void findOutgoingLinks() {
        Element content = page.getElementById("bodyContent");
        Elements links = content.getElementsByTag("a");
       
        int cnt = 0;
       
        for (Element e : links) {
            if (cnt >= 10) {
                break;
            }
           
            String subLink = e.attr("href");
            if ((subLink.length() > 0 && subLink.charAt(0) == '#') ||
                 subLink.contains("index.php") || subLink.contains("File:") ||
                 subLink.contains("Category:") || subLink.contains("Help:") ||
                 subLink.contains("Special:") || subLink.contains("Wikipedia:")) {
                continue;
               
            } else {
                PageNode outPage = new PageNode("https://en.wikipedia.org" +  subLink);
                if (outPage.isValidPage()) {
                    outLinks.put("https://en.wikipedia.org" +  e.attr("href"), outPage);
                    cnt++;
                }
            }
        }
    }
   
    /*
     * returns whether this node successfully became a page
     */
    public boolean isValidPage() {
        return page != null;
    }
   
    /*
     * getter for the string URL
     *
     * @returns url of this PageNode
     */
    public String getURL() {
        return this.url;
    }
   
    /*
     * getter for the outgoing links
     *
     * @return a set of all the urls of the out going links as strings
     */
    public Set<String> getOutLinks() {       
        return this.outLinks.keySet();
    }
   
    public HashSet<PageNode> getOutNodes(){
        HashSet<PageNode> nodes = new HashSet<PageNode>();
        for (Entry<String, PageNode> e : outLinks.entrySet()) {
            nodes.add(e.getValue());
        }
        return nodes;
    }
   
    
    
    /*
     * Determine whether a given URL is a link from this node
     *
     * @param string url
     */
    public boolean hasLink(String link) {
        return outLinks.containsKey(link);
    }
   
    /*
     * checks if the other object is a page node with the same URL
     *
     * @returns true if the other object is a page with the same URL
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
       
        // cast the object to a PageNode
        PageNode otherNode = (PageNode) o;
       
        return this.url.equals(otherNode.getURL());
    }
   
}