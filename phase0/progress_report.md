**Progress Report**

*1. Summary of Specification:*

We are designing a buying and selling program where each user can search for items, add them to cart, and buy items with money. Each user can also list their own items for sale on the platform.

*2. Summary of CRC model:*

**src.test.java.Entities**: User, Item, Order, Storage, ItemStorage, OrderStorage, UserStorage.

**Use Cases**: Buyer, Cart, Finder, God, ItemFinder, LoginU, OrderFinder, OrderGenerator, Seller

**src.test.java.Controller**: LoginC, Search, Tracking System, Transaction

**Interface**: CommandReader

*3. Scenario Walk-through and Skeleton Program:*

We imagined a scenario where an individual wants to purchase an item. After this person creates a new user, 
he/she can select any listed in-stock item and then check out.

*4. Questions we are struggling with:*

- How to decrease dependency between same level classes?
- 

*5. Parts that work well with our design:*

- We have an organized structure by ensuring that cross-level referencing. 
- 

*6. Team member's individual work:*   

Note: There are some overlapping since multiple group members worked on the same task 

- **Qingyi Liu:** 
  - Specification writing 
  - CRC Cards(Entities): Cart, Item, User
  - Java Coding: User, Item


- **Eva Xu:** 
  - CRC Cards(Entities): Order, Storage, ItemStorage, OrderStorage, UserStorage
  - Walkthrough


- **Feihao Qu:** 
  - CRC Cards(Controller): LoginC
  - CRC Cards(Use cases): LoginU


- **Hongda Zhu:** 
  - CRC Cards(Entities): Item, User


- **Howard Xiao:** 
  - CRC Cards(Use cases): Buyer, Seller, UserManager, CartManager, Finder, God, ItemFinder, OrderFinder, OrderGenerator, OrderManager
  - CRC Cards(Controller): Controller
  - CRC Cards(Interface): CommandReader
  - Java Coding: Storage, Cart, Order, Wallet


- **Xiao Qin:** 
  - CRC Cards(Controller): TrackingSystem
  - Unittest: UserTest
  - README writing


- **Xinyu Zhang:** 
  - CRC Cards(Controller): TrackingSystem
  - CRC Cards(Interfaces): Manager
  - Unittest: ItemTest


- **Zhen Sun:** 
  - Scenario walk through writing 
  - CRC Cards(Entities): StackableItem, Wallet, Item, User
  - CRC Cards(Controller): Search
