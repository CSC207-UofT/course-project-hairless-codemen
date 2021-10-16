**Progress Report**

*1. Summary of Specification:*

We are designing a buying and selling platform where each user can search for items, add them to cart, and buy items with money. Each user can also list their own items for sale on the platform.

*2. Summary of CRC model:*

**Entities**: User, Item, Order, Cart, Wallet, StackableItem, Storage, ItemStorage, OrderStorage, UserStorage.

**Use Cases**: CartManager, ItemManager, OrderManager, UserManager

**Controller**: Login, Finder, Transaction

**Interface**: Manager

**UI**: CommandReader

*3. Scenario Walk-through:* 

We imagined a scenario where an individual wants to purchase an item. After this person creates a new user, 
he/she can select any listed in-stock item and then check out.


*4. Skeleton Program:*
For the phase 0, we allow user to create a new account with the new user's name, and the password.
The system would provide some items for the user to buy. When you run the program, the item in the system
will be printed out and user can choose the item they want to buy. Every user have initial $100, for purchasing.

*4. Questions we are struggling with:*

- How to decrease dependency between same level classes?
- What format should our final project be? (like a software or website)Do we need to set-up the interface?

*5. Parts that work well with our design:*

- We have an organized structure by ensuring that cross-level referencing. 
- Made a mindmap to help see the relationship between all the classes. 
- Draw a picture to show what the final project looks like. 

*6. Team member's individual work:*   

Note: There are some overlapping since multiple group members worked on the same task 

- **Qingyi Liu:** 
  - Specification writing 
  - CRC Cards(Entities): Cart, Item, User
  - Java Coding: User, Item


- **Eva Xu:** 
  - CRC Cards(Entities): Order, Storage, ItemStorage, OrderStorage, UserStorage
  - CRC Cards(UI): CommandReader
  - Wrote Walkthrough
  - checking Java code


- **Feihao Qu:** 
  - CRC Cards(Controller): Login


- **Hongda Zhu:** 
  - CRC Cards(Entities): Item, User
  - Java Coding: Item, User


- **Howard Xiao:** 
  - CRC Cards(Use cases): UserManager, CartManager, ItemManager OrderManager
  - CRC Cards(Controller): Transaction, Finder
  - CRC Cards(UI): CommandReader
  - Java Coding: Storage, Cart, Order, Wallet, CommandReader, Transaction


- **Xiao Qin:** 
  - CRC Cards(Use cases): Part of OrderManager
  - Unittest: UserTest
  - README writing
  - Wrote specification and progress report


- **Xinyu Zhang:** 
  - CRC Cards(Use cases): Part of OrderManager
  - CRC Cards(Interfaces): Manager
  - Unittest: ItemTest


- **Zhen Sun:** 
  - Scenario walk through writing 
  - CRC Cards(Entities): StackableItem, Wallet, Item, User
  - CRC Cards(Controller): Search
