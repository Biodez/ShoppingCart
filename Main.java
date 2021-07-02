import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Cart;
import models.Item;
import models.Store;

public class Main {
    static Store store = new Store();
    static Cart cart = new Cart();
    public static void main(String[] args) {
        try {
            
            loadItems("products.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("********************************** JAVA GROCERIES **************************************\n");
            System.out.println(store + "\n");
            manageItems();
        }
        
    }
    public static void manageItems() {
        Scanner scan = new Scanner(System.in);
        boolean value = true;
        while (value) {
            System.out.println("choose to \n\ta) add or \n\tb) remove \n\tc) checkout.");
            switch (scan.nextLine()) {
                case "a":
                    System.out.print("\nChoose an aisle number between: 1 – 7: ");
                    int row = scan.nextInt() - 1;
                    scan.nextLine();
                    System.out.print("Choose an item number between: 1 – 3: ");
                    int column = scan.nextInt() - 1;
                    scan.nextLine();
                    Item item = store.getItems(row, column);
                    if(cart.add(item)) {
                        System.out.println("\n" + item.getName() + " is already in your shopping cart.");
                    } else {
                        System.out.println("\n" + item.getName() + " was added to your shopping cart."); 
                    }
                    break;
                case "b":
                    System.out.print("Enter the item you'd like to remove: ");
                    cart.remove(scan.nextLine());
                    break;
                case "c":
                    cart.checkout();
                    break;
            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            scan.nextLine();
        }
        scan.close();
    }

     public static void loadItems(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);

        for (int i = 0; scan.hasNextLine(); i++) {
            String[] values = scan.nextLine().split(";");
            for (int j = 0; j < values.length; j++) {
                String[] fields = values[j].split("=");
                store.setItems(i, j, new Item(fields[0], Double.parseDouble(fields[1])));
            }
        }
        scan.close();
     }

}
