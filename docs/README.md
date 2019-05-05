# NETS150_FINAL : Wikipedia Racer
_Group Members: Irene Zhang, Kenneth Shinn_
## Project Description
Our project is a Wikipedia Racer. The program will ask the user to input two links: a start link and an end link. These *must* be Wikipedia links, or else the program will throw an error. The program will use BFS to search Wikipedia starting at the start link until the end link is found. Then, the distance from the original node, along with the path from start to end is printed to the user. 

## Classes
* **BFS.java**
  -
* **Main.java**
  -
* **PageNode.java**
  -
  * *url: String*
  * *page: Document*
  * *outLinks : Map\<String, PageNode\>*
  * *WIKI\_LINK\_PREFIX : String*
  
  * **PageNode(String URL)**
    * throws IllegalArgumentException of the input is null, or does not start with the Wikipedia link prefix
    * creates a new PageNode with the input URL.
  * **findOutgoingLinks() : void**
  * **isValidPage() : boolean**
  * **getURL() : String**
  * **getOutgoingLinks() : Set\<String\>**
  * **getOutNodes() : Set\<PageNode\>**
* **PageNodeTest.java**
  -
* **BFSTests.java**
  -
