**Design Document**

**1. Updated Specification:**

We would like to design a service platform that allows users to search, buy and sell items.
It is similar to existing trading websites such as Kijiji, where each user is a buyer and seller at the same time. 
Specifically, a C2C(consumer to consumer) trading platform.

Firstly, the user should be able to sign up or login to our platform with their unique username and password. After logged in, the user would be able to see all the listed items in stock on our platform.
Users can look or search through list of items on the system, their own orders, their wallets, their carts and items sold under their accounts. 

They would also be able to post the item(s) they want to sell or purchase item(s) that they wish to buy.
To create a sale post, users must indicate the name of the item they wish to sell, as well as the price, quantity and the category it belongs to.
For purchasing, users should be able to search by item keywords, seller of the item, or a specific category. 
Users will be able to add the item(s) to their personal cart, and then check out successfully only when they have sufficient money in their wallet. 
There will be one order generated for each seller of the items purchased and returned to this user. 
Nothing would be changed if they have insufficient funds. 

The user may top up their wallet to get more money for purchasing.
After successfully paying for the order, users will receive an order number. The user would be able to search for their order by using
order number; Finding the order will show the following information: buyer name, seller name, ordered item(s), the total amount paid to the user.

<br />

**2. UML diagrams:**

Please see the ".uml" files under our "phase1" package.

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

*b.* 

<br />

*4. Following Clean Architecture:*

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

*5. Examples of Obeying SOLID Principles:*


*6. Packaging Strategies Used:*



*7.Design Patterns Implemented:*

To begin, we implemented the Iterator design pattern for our classes Cart, ItemStorage and OrderStorage. The reason for implementing this design pattern is that we would like to go through every item in a cart, every item stored in our item storage and every order stored in our order storage on the use case level. 
The Iterator design pattern avoids using a lot of getter methods and then iterate through the data structure we implemented underlying these classes. 

Also, to make it easier for searching operations to be performed, we changed our data structure for our storages from ArrayLists to HashMaps, but looping through every item in a hashmap is relatively complicated, so the Iterator pattern also made this process more efficient.

Secondly, we also implemented the Facade design pattern in our controller classes, FileFacade and InfoFacade. The reason for using the Facade design pattern in our FileFacade class is that we would like to read Users, Items and Orders stored in our files at the beginning of the program so that the platform has a record of everything. FIleFacade will redirect the tasks of reading users from file, reading items from file, and reading orders from file to UserReadWriter, ItemReadWriter and OrderReadWriter, respectively. 
Also, if these files are empty at the beginning, we would load system preset users, orders, or items to our storages. FileFacade will also redirect thesre tasks to UserManager, OrderManager or ItemManager respectively. 

The reason for using the Facade design pattern in our InfoFacade class is that on the UI level, we need to have a string representation of items in cart, a list of items, orders in general (for searching purposes) or orders made by a specific user. InfoFacade can redirect these tasks to CartManager, ItemManager and OrderManager respectively. 

*8. Progress Report:*
