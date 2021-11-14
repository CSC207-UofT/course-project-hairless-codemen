**Design Document**

*1. Updated Specification:*

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


*2. UML diagrams:*

Please see the ".uml" files under our phase1 package.

*3. Major Design Decisions:*



*4. Examples of Following Clean Architecture:*

*5. Examples of Obeying SOLID Principles:*

*6. Packaging Strategies Used:*

*7.Design Patterns Implemented:*

*8. Progress Report:*