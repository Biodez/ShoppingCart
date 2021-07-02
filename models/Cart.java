package models;

import java.util.ArrayList;

public class Cart {
    ArrayList <Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItems(int index) {
        return new Item(items.get(index));
    }

    public void setItems(Item items, int index) {
        this.items.set(index, new Item(items));
    }

    public boolean add(Item item) {
        if (!(items.contains(item))) {
            this.items.add(new Item (item));
            return false;
        }
        return true;
    }

    public void remove(String name) {
        if (items.isEmpty()) {
            throw new IllegalStateException("The store is empty and cannot remove and item");
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
            }
        }
    }

    public String checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Store not in a valid state to checkout since the store is empty");
        }
        double price = 0.00;
        for (int i = 0; i < items.size(); i++) {
            price += items.get(i).getPrice();
        }
        double taxPrice = price * 0.13;
        double total = taxPrice + price;

        return  "\tRECEIPT\n\n" +
                "\tSubtotal: $" + price + "\n" +
                "\tTax: $" + taxPrice + "\n" +
                "\tTotal: $" + total + "\n";
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }
    
}
