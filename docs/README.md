# NETS150_FINAL : Wikipedia Racer
_Group Members: Irene Zhang, Kenneth Shinn_
## Project Description

_Summary_

Our project is a Wikipedia Racer. The program will ask the user to input two links: a start link and an end link. These *must* be Wikipedia links, or else the program will throw an error. The program will use BFS to search Wikipedia starting at the start link until the end link is found. Then, the distance from the original node, along with the path from start to end is printed to the user. 

_Dependencies_

We used JSOUP to parse through each Wikipedia page.  


_Limitations_

Due to our choice in webscraper, the program that we have created can, at times, be very inefficient. Especially with long webpages with thousands of links, the runtime of the program becomes exponential as it has to scrape not only that page, but also the page of each of its neighbors. 


## Classes
* **BFS.java**
  * **static getPath()**
    * 
* **Main.java**
  * **static main(String[] args)**
    * The main User Interface of the program. Prompts the User for 2 inputs. First, it asks for a start link. 
    Then, it asks for an end link. Both links must be Wikipedia links. Otherwise, the UI will reject the input 
    and ask the user to try another link. 
* **PageNode.java**
  * *url: String*
  * *page: Document*
  * *outLinks : Map\<String, PageNode\>*
  * *WIKI\_LINK\_PREFIX : String*
  
  * **PageNode(String URL)**
    * creates a new PageNode with the input URL.
  * **findOutgoingLinks() : void**
    * Uses JSOUP to find all outgoing links from the PageNode. This function ignores any link that is not on 
    wikipedia, along with links that  
  * **isValidPage() : boolean**
    
  * **getURL() : String**
  * **getOutgoingLinks() : Set\<String\>**
  * **getOutNodes() : Set\<PageNode\>**
  
* **PageNodeTest.java**
  
* **BFSTests.java**
  
