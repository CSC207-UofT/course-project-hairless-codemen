**Design Document**

**1. Updated Specification:**

We would like to design a service platform that allows users to search, buy and sell items.
It is similar to existing trading websites such as Kijiji, where each user is a buyer and seller at the same time. 
Specifically, a C2C(consumer to consumer) trading platform.

Firstly, the user should be able to sign up or login to our platform with their unique username and their password. 
After logged in, the user would be able to see all the listed items in stock on our platform.
Users can look or search through list of items on the system, their own orders, their wallets, their carts and items sold under their accounts. 

They would also be able to post the item(s) they want to sell or purchase item(s) that they wish to buy.
To create a sale post, users must indicate the name of the item they wish to sell, as well as the price, quantity and the category it belongs to.
For purchasing, users should be able to search by item keywords, seller of the item, or a specific category. 
Users will be able to add the item(s) to their personal cart, and then check out successfully only when they have sufficient money in their wallet. 
There will be one order generated for each seller of the items purchased and returned to this user. 
Nothing would be changed if they have insufficient funds. 

The user may top up their wallet to get more money for purchasing.
After successfully paying for the order, users will receive an order number. The user would be able to search for their 
orders by using the order numbers. 
Finding the order will show the following information: buyer name, seller name, ordered item(s), 
and the total amount paid to the user.

<br />

**2. UML diagrams:**

Please see the "UML.pdf" file under our "phase1" package.

<br />

**3. Major Design Decisions:**

*a.* Changed the underlying data structure for storages from ArrayList to HashMap.

In this phase, unlike phase 0, we decided to change the way we store all users, items and orders in our system from 
using ArrayLists to using Hashmaps. In UserStorage, we used a hashmap with keys being usernames and values the 
corresponding users, so we made sure every user's username is unique, like pretty much every C2C platform now. 

In ItemStorage, we allow items with the same names because in reality it is possible to have items with same names but 
from different sellers or with different prices, so we used a hashmap with keys being item names and values ArrayLists 
of all items under each name. In OrderStorage, we made sure every order has a unique order id, and we used these ids as 
keys in the hashmap, with values the corresponding orders. 

The reason we decided to change the underlying data structure for storages is that in this way, it is much easier to 
perform search operations for searching a user by username, an item by itemname and an order by its id. Although this 
made iterating through everything more complicated, we added the Iterator Design Pattern to solve this issue 
(see more in 7.).

*b.* The format of UI: GUI

Since we don't have that much data to be stored or complex operations to be carried out, in terms of programming, it is
easier for us to design the Desktop Application format of UI. Besides, using a desktop application eliminates the
requirement of having a remote server or storage, and desktop applications have better performance than web
applications. 

However, we did try to design a web platform on our system, which can be seen under our UI package as well. We are still
deciding between the two, although now the desktop version has more functionalities and we are demoing our program using
this version. 

*c.* The reason for serialization, and when to read and save into files. 

The reason we decided to implement serialization for UserStorage, ItemStorage and OrderStorage is that it is easier for
us to read the entire Hashmap data structure at the beginning of the program and save it in the end. We can save users,
items or orders individually in a text file for example, but we also have to read them one by one. Through 
serialization, we only need a few lines of code to do so. 

In our program, we read from file at the beginning of the program, so that our system can have a record of everything.
However, there is no need to modify the files directly during the operation of the program. That's why we only save the 
updated data of the storages to our files by the end of the program or after the user logged out. 

<br />

**4. Following Clean Architecture:**

In our project we divide our works into four major categories, which are Entities, Use_cases, Controller, and UI. 
We have followed the Clean Architecture rules. The classes are only dependent on their adjacent layer, and would not have 
direct connections across layers. For example, the Entities is our core layer, and when the Use_cases are building methods, 
they would only use the attributes and methods in the Entities or the method in the Use_cases. They cannot call the 
method in the upper layer classes. Similarly, the Controller only can call the method in the Use_cases classes or the 
Controller classes. Each of these four layers is dependent on its lower layers.

For example, we have designed four Manager classes, CartManager, UserManager, ItemManager and OrderManager, each in
charge of performing operations with entities Cart, User and UserStorage, Item and ItemStorage, Order and OrderStorage
respectively. On the controller level, we have two Facade classes and one transaction classes calling methods in these
Manager use cases, and on the UI level, we only call methods in our controllers to get the information or functionality
we need.

<br />

**5. Examples of Obeying SOLID Principles:**

*a.* Single Responsibility Principle.

We designed FileFacade and InfoFacade classes to delegate tasks to use cases UserManager, ItemManager, CartManager or 
OrderManager, where each use case is only in charge of modifying one or two interacting entities (for example Item and 
ItemStorage). No two use cases will act on the same entity, each type of Manager is used for that type of entity and
that type of storage only. 

*b.* Open or Closed Principle.

In the future, we can implement different types of storages as we wish jsut by implementing our storable interface.
Also, we can add additional managers corresponding to additional storages just by implementing our manager interface. In
this way, we can add more types of storages or managers without modifying any exiting ones.

*c.* Liskov Substitution Principle.

In our program, every storage implements the storable interface, but contains more methods than the ones in the storable 
interface. Some methods (addElement, deleteElement) are overloaded for convenience of the use cases providing different
types of inputs to these methods. Similarly, except for CartManager, all manager classes implemented the manager 
interface, but contains more methods than the ones included. Many methods are also overloaded for the convenience of our
controller classes. 

*d.* Interface Segregation Principle.

In our program, there are two interfaces, one is Storable and the other one Manager. Every storage implements the
Storable interface and used every method provided in the interface. Since we do not have a storage for carts, 
it does not make sense for CartManager to implement the addElement and removeElement methods in the manager interface. 
Hence, except for CartManager, every other manager class implemented the manager interface and they used every method in
the interface. 

*e.* Dependency Inversion Principle.

In our program, we don't have a chance to use dependency inversion technique since we designed our system in a way that
completely follows Clean Architecture.

<br />

**6. Packaging Strategies Used:**

The primary packaging strategy that was used in our code was packaging by layers. Specifically, the layers strictly
obeyed the clean architecture structure. For each layer in the clean architecture, we had a package for that layer.
This method of packaging enforces our code to obey the clean architecture structure as classes in each layer can only
import classes in their adjacent inner layer. I.e. controllers only import classes in the use case layer and use cases
only import the entities, while the entities would not be importing any other packages written by us (only the necessary
Java tools). By choosing this packaging strategy, it is obvious whether clean architecture is obeyed just by looking at 
the import statements.

<br />

**7.Design Patterns Implemented:**

To begin, we implemented the Iterator design pattern for our classes Cart, ItemStorage and OrderStorage. The reason for 
implementing this design pattern is that we would like to go through every item in a cart, every item stored in our item
storage and every order stored in our order storage on the use case level. 
The Iterator design pattern avoids using a lot of getter methods and then iterate through the data structure we 
implemented underlying these classes. 

Also, to make it easier for searching operations to be performed, we changed our data structure for our storages from 
ArrayLists to HashMaps, but looping through every item in a hashmap is relatively complicated, so the Iterator pattern 
also made this process more efficient.

Secondly, we also implemented the Facade design pattern in our controller classes, FileFacade and InfoFacade. The reason 
for using the Facade design pattern in our FileFacade class is that we would like to read Users, Items and Orders stored 
in our files at the beginning of the program so that the platform has a record of everything. FIleFacade will redirect 
the tasks of reading users from file, reading items from file, and reading orders from file to UserReadWriter, 
ItemReadWriter and OrderReadWriter, respectively. 
Also, if these files are empty at the beginning, we would load system preset users, orders, or items to our storages. 
FileFacade will also redirect thesre tasks to UserManager, OrderManager or ItemManager respectively. 

The reason for using the Facade design pattern in our InfoFacade class is that on the UI level, we need to have a string
representation of items in cart, a list of items, orders in general (for searching purposes) or orders made by a 
specific user. InfoFacade can redirect these tasks to CartManager, ItemManager and OrderManager respectively. 

<br />

**8. Progress Report:**

*Individual Work:*

- **Qingyi Liu:**
    - Specification update, further improvement writing
    - Java Coding: Finder, ItemStorage, ItemManager, OrderStorage, OrderManager
    - wrote tests for Finder


- **Zichun Xu:**
  - Finished methods in class Transaction, including buy and sell. Add relevant methods in use cases such as ItemManager and 
    OrderManager.
  - Support UI, and wrote tests for Transaction
  - Finished Clean Architecture part of the design document.


- **Feihao Qu:**



- **Hongda Zhu:**



- **Howard Xiao:**
  - Serialization, read and write files and to interact with storage and manager classes.
  - Support UI, implemented iterator and facade design patterns, completed tests to improve test coverage as high as
  possible.
  - Finished SOLID, major design decision and the design pattern part of the design document.


- **Xiao Qin:**



- **Xinyu Zhang:**



- **Zhen Sun:**
  - Coded the search feature, including the search method in both ItemManager and OrderManager, and the class Finder.
  - Wrote the test for search in ItemManager. 

*Further Improvement:*

- Modifying quantity of an item after posting is currently not allowed. Right now, if a user post an identical item he/she
posted previously, our program will take this item as a brand-new item and store them separately in the item storage. In 
the future, we can implement methods that allows adding quantity if identical items (same name, price, category) are posted
by the same user. For different user, we should still separate them since quality could differ between different sellers.

- We haven't had a chance to add constraints for username and password. Currently, a user can have the username " " (a blank space).
And password could be a single character. We would like to make our platform as close as a real world trading platform. 
Therefore, the cases described above should not be allowed.

- Even though our programs has used some exceptions, but overall, we lack the use of exceptions. Writing more exceptions
will help with our debugging process, as well as the efficiency if our program actually starts running.

- Now for some windows appeared in our program, they have different sizes and appearances for Mac and Windows systems.
We don't know how to solve this yet, and we would like to know how to deal with this issue.

- When performing checkout, sometimes unknown errors will occur but after another click for checkout,
  everything is good again. This requires troubleshooting in phase2 as well.