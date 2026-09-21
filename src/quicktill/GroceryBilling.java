package quicktill;
import java.util.*;
 
public class GroceryBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
 // Below we array-list to enable details to be listed.       
        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<Integer> itemQty = new ArrayList<>();
        ArrayList<Double> itemPrices = new ArrayList<>();
        double total = 0;
        boolean shopping = true;
 
        System.out.println("===Greetings!- 'Welcome to QuickBill' ===");
 
  //  THE WHILE LOOP: keeps the menu below running until the user  chooses checks out
        while (shopping) {
            System.out.println("\n1. Add Item\n2. Checkout");
            System.out.print("Choose  one option: ");
            int choice = sc.nextInt();
     
        
 // the if statement for selection 1: allows for continued suggestions. 
            if (choice == 1) {
                sc.nextLine(); // clear the enter option to allow scan for next instead of pressing enter...
                System.out.print("Enter item name: ");
                String name = sc.nextLine();
 
                System.out.print("Enter price per unit: ");
                double price = sc.nextDouble();
 
                
                
  // DO-WHILE LOOP: forces at least one attempt, which is for a valid entry to be made.
               
                int qty;
                do {
                    System.out.print("Enter quantity (must be greater than 0): ");
             
            //if-statement to check correct qty.
                    qty = sc.nextInt();
                    if (qty <= 0) {
                        System.out.println("Invalid quantity! Please enter valid quantity.");
                    }
                } while (qty <= 0);
 
                itemNames.add(name);
                itemQty.add(qty);
                itemPrices.add(price);
                total += price * qty;
 
                System.out.println(name + " added to basket.");
                
                
    //if-else continuation for selection 2; boolean false.  
            } else if (choice == 2) {
                shopping = false;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
 
        System.out.println("\n========= RECEIPT =========");
     System.out.println("Number of different items:" + itemNames.size());
       
        
    // FOR LOOP: this prints every item that was collected above
        
        for (int i = 0; i < itemNames.size(); i++) {
            double subtotal = itemPrices.get(i) * itemQty.get(i);
            System.out.printf("%-15s x%-3d @ %-8.2f = %.2f%n",
                    itemNames.get(i), itemQty.get(i), itemPrices.get(i), subtotal);
        }
 
       
    // TERNARY STATEMENT: 10% discount only if total is above 50,000
        double discount = (total > 50000) ? total * 0.10 : 0;
        double finalTotal = total - discount;
 
        System.out.println("----------------------------");
        System.out.printf("Subtotal: UGX %.2f%n", total);
        System.out.printf("Discount: UGX %.2f%n", discount);
        System.out.printf("Total Payable: UGX %.2f%n", finalTotal);
        System.out.println("============================");
        System.out.println("Have a nice Day! Thank you for shopping with us! !");
 
        sc.close();
    }
}
