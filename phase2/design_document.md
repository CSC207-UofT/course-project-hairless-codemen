**Design Document**

**1. Program Specification:**

We would like to design a service platform that allows users to search, buy and sell items.
It is similar to existing trading websites such as Kijiji, where each user is a buyer and seller at the same time. 
Specifically, a C2C(consumer to consumer) trading platform.

Our specification consists of two parts:

*a.* Signup and user login

Users can create their unique username and password to sign up on our platform, and be able to login to our platform 
with their unique username and password. 

After logged in, the user would be able to see all the listed items in stock on our platform, money in their wallets,
and items in their carts.

*b.* Perform a transaction (buy or sell)

Users can search by item keywords, seller of the item, or a specific category to look for the items they want. User can
add a certain quantity of the items into their personal carts, as long as the quantity does not exceed the total 
quantity of the items in our storage. Users can check out from their carts and the purchase would be successful as long 
as they have sufficient money in their wallet. There will be one order generated for every seller of the items purchased 
and the order would be stored in our system. 

Users may top up their wallet to get more money for pudrchasing.
After successfully paying for the order, users will receive several order numbers. 
The user would be able to search for their orders by using these order numbers. the user may top up their wallet to get more money for purchasing.
After successfully paying for the order, users will receive an order number. The user would be able to search for their
orders by using the order numbers.

To create a sale post, users must indicate the name of the item they wish to sell, as well as the price, quantity and 
the category it belongs to. Then, the items the user wish to sell would be added to our platform, and everyone logged 
in can see them.

<br />

**2. UML diagrams:**

Please see the "UML.pdf" file under our "phase2" package for detail UML in each level.

<img alt="Aaron Swartz" src="https://github.com/CSC207-UofT/course-project-hairless-codemen/raw/main/images/Program%20UML.drawio.png"/>

<br />

**3. Modifications and Important Changes of the Program Made in Phase 2:**

*a.* Added features for adding a customized quantity of items into cart, buying and selling them.



*b.* Changed variable types from ArrayList to List to make it more abstract where needed.


*c.* Solved program bugs, catch exceptions during operation of the program.


*d.* Modified some of the iterators implemented to make them more efficient.


*e.* Other additional features added:
    
- Added RegexChecker class to apply constraints on passwords of users (must contain upper case, lower case, digit and 
special characters). Permit users to change their passwords.
- 

<br />


**4. Major Design Decisions Made Throughout Three Project Phases:**

*a.* Using HashMap for the underlying data structure of storages.

In UserStorage, we used a hashmap with keys being usernames and values the 
corresponding users, so we made sure every user's username is unique, like pretty much every C2C platform now. 

In ItemStorage, we allow items with the same names because in reality it is possible to have items with same names but 
from different sellers or with different prices, so we used a hashmap with keys being item names and values ArrayLists 
of all items under each name. In OrderStorage, we made sure every order has a unique order id, and we used these ids as 
keys in the hashmap, with values the corresponding orders. 

The reason we decided to use maps for the underlying data structure of storages is that in this way, it is much easier to 
perform search operations for searching a user by username, an item by itemname and an order by its id. Although this 
made iterating through everything more complicated, we added the Iterator Design Pattern to solve this issue 
(see more in 8.).

*b.* The format of UI: GUI

Since we don't have that much data to be stored or complex operations to be carried out, in terms of programming, it is
easier for us to design the Desktop Application format of UI. Besides, using a desktop application eliminates the
requirement of having a remote server or storage.

*c.* The reason for serialization, and when to read and save into files. 

The reason we decided to implement serialization for UserStorage, ItemStorage and OrderStorage is that it is easier for
us to read the entire Hashmap data structure at the beginning of the program and save it in the end. We can save users,
items or orders individually in a text file for example, but we also have to read them one by one. Through 
serialization, we only need a few lines of code to do so. 

In our program, we read from file at the beginning of the program, so that our system can have a record of everything.
However, there is no need to modify the files directly during the operation of the program. That's why we only save the 
updated data of the storages to our files by the end of the program or after the user logged out. 

*d.* Change data structure for cart

In phase0 and phase1, the data structure for cart is the arraylist of items. And in phase2, we change its data structure
into HashMap of the key items with the value their quantities. Since in our program, we offer customers a new function that they can choose the quantity of products when
they want to add them into their cart. So to check the price more convenient for us when customers click "checkout" button,
we made the change.

<br />

**5. Clean Architecture:**

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

**6. Examples of Obeying SOLID Principles:**

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

**7. Packaging Strategies Used:**

The primary packaging strategy that was used in our code was packaging by layers. Specifically, the layers strictly
obeyed the clean architecture structure. For each layer in the clean architecture, we had a package for that layer.
This method of packaging enforces our code to obey the clean architecture structure as classes in each layer can only
import classes in their adjacent inner layer. I.e. controllers only import classes in the use case layer and use cases
only import the entities, while the entities would not be importing any other packages written by us (only the necessary
Java tools). By choosing this packaging strategy, it is obvious whether clean architecture is obeyed just by looking at 
the import statements.

<br />

**8.Design Patterns Implemented:**

*a.* Iterator

We implemented the Iterator design pattern for our classes Cart, ItemStorage and OrderStorage. The reason for 
implementing this design pattern is that we would like to go through every item in a cart, every item stored in our item
storage and every order stored in our order storage on the use case level. 
The Iterator design pattern avoids using a lot of getter methods and then iterate through the data structure we 
implemented underlying these classes. 

Also, to make it easier for searching operations to be performed, we changed our data structure for our storages from 
ArrayLists to HashMaps, but looping through every item in a hashmap is relatively complicated, so the Iterator pattern 
also made this process more efficient.

*b.* Facade

We also implemented the Facade design pattern in our controller classes, FileFacade and InfoFacade. The reason 
for using the Facade design pattern in our FileFacade class is that we would like to read Users, Items and Orders stored 
in our files at the beginning of the program so that the platform has a record of everything. FIleFacade will redirect 
the tasks of reading users from file, reading items from file, and reading orders from file to UserReadWriter, 
ItemReadWriter and OrderReadWriter, respectively. 
Also, if these files are empty at the beginning, we would load system preset users, orders, or items to our storages. 
FileFacade will also redirect there tasks to UserManager, OrderManager or ItemManager respectively. 

The reason for using the Facade design pattern in our InfoFacade class is that on the UI level, we need to have a string
representation of items in cart, a list of items, orders in general (for searching purposes) or orders made by a 
specific user. InfoFacade can redirect these tasks to CartManager, ItemManager and OrderManager respectively. 

<br />

**9. Accessibility Report:**

Please see the accessibility.md file in our phase2 package.

<br />

**10. Significant pull requests:**

- **Qingyi Liu:** Pull request #27: \
In this pull request, I created the class RegexChecker in Controller to give constraints for users' username and password
inputs. Both username and password should be non-empty(all blank space input not allowed). For password, the input string
should contain at least one uppercase letter, one lowercase letter, one special character and a minimum length of 8. I
also added a method in UserManager to allow existing users modify their password. Lastly, I changed the way we define 
"identical items". Two items are identical and will be put under the same storage key if and only if they have the same
name, category and price. I modified the addItem and deleteItem methods in ItemStorage to implement this new definition.


- **Zichun Xu:** Pull request #46: \
  I fixed the bug for adding items to the item storage.
  When we add an item into the item storage the quantity of the item would have some mistake
  Also, when we delete the item, we cannot simply delete the value of the Map, it would cause an item(string)
  with an empty ArrayList of Item. When the item did not exist we should delete the key of the item string.
  Also, the Object variable type would cause a big problem when we add an array list of the item as a parameter
  into the item storage. It is also the subclass of the Object and causes some issues to exist in the program.
  Since I have a technical issue I could not push into the branch. I got a push failed. Therefore, I did not have
  many pull requests before the phase2. I just write my code and show the code to my teammate, after they checked
  I directly pushed it into main, like the feature of transaction and the searching of the orders with different items
  and buyers but with the same seller.


- **Feihao Qu:** Pull request #43: \
In this pull request, since our group members decided to change the data structure of Cart from ArrayList to HashMap, I 
accordingly updated one of the most important methods in our program, BuyItem. Now, this method takes Cart as a parameter 
directly instead of an arraylist of items.In this case, our program can run properly with new data structure of Cart. 
At the same time, I updated some test cases about Cart and Cart Manager due to the change of data structure and the updated
method BuyItem.

  
- *Hongda Zhu:*  Pull request #13: \
In this pull request, I wrote the method in Controller Transaction. Since the rule of clean architecture needs to be 
followed. I have also moderate and add functions in Use_cases for ItemManager, CartManager, OrderManager, and 
UserManager. I wrote functions like RemoveElements, AddElements, LoadMoney, SubtractMoney, GetItemPrice, 
Get_all_itemPrice......
To test if the Transaction methods will run successful. I have also wrote few test cases for Transaction 'Buy', 
to test if the money will be subtracted from user, will the seller get money, etc...


- **Howard Xiao:** Pull request #9: \
I changed the underlying data structure of storages from ArrayList to HashMap, and also created a static interface Storable. This pull request is significant because 
the team decision of changing the underlying data structure of storages is implemented in this pull request, which is 
one of the most important design decisions we made (see more in 4.a). Also, I decided to extract a static interface for
storage classes so that we can use static methods in ItemStorage and UserStorage. Added OrderStorage.


- **Xiao Qin:** Pull request #18: \
In this pull request, I wrote the ReadWriter files with serialization for our program. When we stop our program, 
data(items information, users information, orders information) produced during the process of running the program 
can be stored in our program. Also, when we rerun our program after
closing it, we can load data from files. 



- **Xinyu Zhang:** Pull request #30: \
In this pull request, I have fixed the bug that occurs when clicking the "checkout" button when running the program. 
I found that when I want to delete or add a list of items into the arraylist of ItemStorage, I can't use the loop method
to do it because the size of the target list will change during the process, so the program will report an error(ConcurrentModificationException).
So in order to solve this problem, I did a deep copy, and then everything resolved.



- **Zhen Sun:** Pull request #41: \
In order to specify the total quantity that a user want to purchase from an item that has more than 1 in stock, 
the structure of the cart has to change. Before the change, the cart's itemlist variable is an ArrayList of items.
However, the quantity stored in each instance of Item is only the total number in stock, not the amount the user wants
purchase. So, I changed cart into a hashmap that has each key as the item, and each value as an integer of how many
a user added to cart. I wrote some overloaded methods that relates to cart so the parameter "quantity" is used. 
Then, not all quantity of an item has to be added to a user's cart at once.

<br />

**11. Progress Report:**


*Individual Work for the Project:*

- **Qingyi Liu:**
  - Specification writing.
  - CRC Cards for Cart, Item, User in Entities.
  - Java Coding: User, Item
  - Unittest: CartTest, WalletTest, OrderTest (**Phase 0**)
  - Further improvement writing
  - Java Coding: Finder, ItemStorage, ItemManager, OrderStorage, OrderManager
  - Unittest: Finder (**Phase 1**)
  - **Phase2:** Java Coding: RegexChecker, ItemStorage, UserManager
  - Unittest: RegexCheckerTest, CartManagerTest, InfoFacadeTest

  
- **Zichun Xu:**
  - CRC Cards(Entities): Order, Storage, ItemStorage, OrderStorage, UserStorage
  - CRC Cards(UI): CommandReader
  - Wrote Walk through
  - Checking Java code (**Phase 0**)
  - Finished methods in class Transaction, including buy and sell. Add relevant methods in use cases such as ItemManager and
      OrderManager.
  - Support UI, and wrote tests for Transaction
  - Finished Clean Architecture part of the design document.(**Phase 1**)
  - **Phase2:** Java Coding: ItemStorage, UserManager, Transaction, OrderStorage, OrderManager
  - Unittest: TransactionTest, CartManagerTest, ItemManagerTest, OrderManagerTest, InfoFacadeTest, FinderTest


- **Feihao Qu:**
  - CRC Cards(Controller): Login（**Phase 0**)
  - Implemented Web version User Interface
  - Build Three Web Pages: Login, Signup and Main
  - Page transitions
  - Coding：html, css and Javascript（**Phase 1**)
  - **Phase 2**: Java coding: Transaction, Entities, InfoFacade
  - Unittest: CartTest, CartManagerTest



- **Hongda Zhu:**
  - Assist writing design pattern
  - accessibility document writing Part 2
  - Provide ideas and insight on what new features can be added to further improve our program 


- **Howard Xiao:**
    - CRC Cards for use cases, controller and UI.
    - Java Coding: Storage, Cart, Order, Wallet, CommandReader, Transaction (**Phase 0**)
    - Serialization, read and write files and to interact with storage and manager classes.
    - Support UI, implemented iterator and facade design patterns, completed tests to improve test coverage as high as
      possible.
    - Finished SOLID, major design decision and the design pattern part of the design document. (**Phase 1**)
    - **Phase2:** Accessibility report and Modify design document.


- **Xiao Qin:**
  - CRC Cards(Use cases): Part of OrderManager
  - Unittest: UserTest
  - README writing
  - Wrote specification and progress report(**Phase 0**)
  - Serialization, coding ReadWriters
  - Created UML Diagram
  - some entity documentations(**Phase 1**)
  - **Phase 2:** Java coding:QuantFrame, Layout desginer of UI, improve UI, Added Order sold by users box, Font function of UI. 


- **Xinyu Zhang:**
  - CRC Cards(Use cases): Part of OrderManager
  - CRC Cards(Interfaces): Manager
  - Unittest: ItemTest (**Phase 0**)
  - Java coding: Entry, Frame, Home, SearchFrame, SearchResult, SellFrame
  - Help improve codes in Controller. (**Phase 1**)
  - **Phase2:** Improve UI and debug codes of program


- **Zhen Sun:**
  - CRC cards(controller): Finder and Transaction (**Phase 0**)
  - Assisted the implementation of Transaction
  - Implemented search methods in the Managers and Finder Class (**Phase 1**)
  - **Phase 2:** Implemented "quantity" related features in Cart, ItemManager and Transaction
  - Implemented the new structure of Cart
  - Includes calculation of total price of all items in cart
  - Final debugs and testing
  - Cleaning up the code by removing unnecessary methods