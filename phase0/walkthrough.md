**Scenario Walk Through** - "purchasing an item"   


Once starting the program, we can create a **User**, then login to the platform with your newly created account by 
using the **"LoginC"** classes in controller layout. The information of user would storage in 
**UserStorage**  

The user can act as a buyer and purchases **Item** which is posted by other users from the existing **"ItemStorage"**.
The user can search items’ names by using the **"Search"** classes. The **ItemManager** would 
return a list of matched items. If there is no relevant item, the screen would show "0 items for 
'what the user types in'". After that, the user can also put their desired items in the **"Cart"**.

Once they pick a specific item, they can purchase the item by performing a **"Transaction"**. The transaction will 
deduct buyer's money in **Wallet**, add money to the seller's **Wallet**, and delete this item from **"ItemStorage"** 
(if this item is not a StackableItem, which still exists in the storage unless sold out).  

Furthermore, an **"Order"** will be generated which contains information about price, seller(s), buyer, and an order 
number. This order will be placed into **"OrderStorage"** so the user can also search for their previous orders using 
**"Search"**. Also, the **OrderManager** would give the list of order. 