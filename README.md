# NETS150_FINAL : Wikipedia Racer
_Group Members: Irene Zhang, Kenneth Shinn_
## Classes
* **BFS.java**
  -
* **Main.java**
  -
* **PageNode.java**
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
