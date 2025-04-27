package testpackage.book_store_servlet;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    private ArrayList<ItemOrder> itemsOrdered;
    public ShoppingCart()
    {
        itemsOrdered = new ArrayList<>();
    }
    public List<ItemOrder> getItemsOrdered()
    {
        return(itemsOrdered);
    }

    public synchronized void addItem(String itemID)
    {
        ItemOrder order;
        for(int i=0; i<itemsOrdered.size(); i++)
        {
            order = (ItemOrder)itemsOrdered.get(i);
            if (order.getItemID().equals(itemID))
            {
                order.incrementNumItems();
                return;
            }
        }
        CatalogItem item = Catalog.getItem(itemID);
        if (item != null) {
            ItemOrder newOrder = new ItemOrder(item);  // Create new order item if not found
            itemsOrdered.add(newOrder);
        }
    }

    public synchronized void setNumOrdered(String itemID, int numOrdered)
    {
        ItemOrder order;
        for(int i=0; i<itemsOrdered.size(); i++)
        {
            order = (ItemOrder)itemsOrdered.get(i);
            if (order.getItemID().equals(itemID))
            {
                if (numOrdered <= 0)
                {
                    itemsOrdered.remove(i);
                }
                else
                {
                    order.setNumItems(numOrdered);
                }
                return;
            }
        }
        CatalogItem item = Catalog.getItem(itemID);
        if (item != null) {
            ItemOrder newOrder = new ItemOrder(item);
            newOrder.setNumItems(numOrdered);
            itemsOrdered.add(newOrder);
        }
    }
}
