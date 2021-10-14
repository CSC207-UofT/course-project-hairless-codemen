**Scenario Walk Through** - "purchasing an item"   


Once starting the program, we can create a user, then login to the system with your newly created account by using the 
**"Login"** classes in controller and use case layers. Then, the user can post an item for sale by setting its price.  

This item will be put into the **"ItemStorage"** entity which can be accessed by all users using the program. The user 
can also act as a buyer that purchases items from the existing **"ItemStorage"** by searching items’ names using the 
**"Search"** and **"ItemFinder"** classes. 

Once they pick a specific item, they can purchase the item by performing a **"Transaction"**. The transaction will 
deduct buyer's money, add money to the seller, and delete this item from **"ItemStorage"** (if this item is not a 
StackableItem, which still exists in the storage unless sold out).  

Furthermore, an **"Order"** will be generated which contains information about price, seller, buyer, and an order 
number. This order will be placed into **"OrderStorage"** so the user can also search for their previous orders using 
**"Search"** and **"OrderFinder"**. Other than this, the user can also put their desired items in the **"Cart"**. 