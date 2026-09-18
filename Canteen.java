
import java.util.Scanner; 
 
public class Main { 
    public static void main(String[] args) { 
 
        Scanner input = new Scanner(System.in); 
 
        String[] food = { 
            "Burger", 
            "Fries", 
            "Sandwich", 
            "Spaghetti", 
            "Iced Tea" 
        }; 
 
        double[] price = { 
            80, 120, 100, 70, 90 
        }; 
 
        int totalQuantity = 0; 
        double totalAmount = 0; 
        double totalDiscount = 0; 
 
        System.out.println("====== MENU ======"); 
 
        for (int i = 0; i < food.length; i++) { 
            System.out.printf("%d. %s - $%.2f%n",  
                i + 1, food[i], price[i]); 
        } 
 
        String again = "Y"; 
 
        while (again.equalsIgnoreCase("Y")) { 
             
            System.out.print("\nEnter item number: "); 
            int item = input.nextInt(); 
 
            System.out.print("Enter quantity: "); 
            int quantity = input.nextInt(); 
 
            System.out.print("Are you a student? (Y/N): "); 
            String student = input.next(); 
 
            // Check the order 
            if (item < 1 || item > 5 || 
                quantity < 1 || quantity > 10 || 
                (!student.equalsIgnoreCase("Y") && 
                 !student.equalsIgnoreCase("N"))) { 
 
                System.out.println( 
                    "\nInvalid order! Please enter a valid item and quantity." 
 
                ); 
 
                System.out.print( 
                    "\nDo you want to order again? (Y/N)\n " 
                ); 
 
                continue;  
            } 
 
            // Calculate the order 
            double amount = price[item - 1] * quantity; 
            double discount = 0; 
 
            // Apply the discount 
            if (student.equalsIgnoreCase("Y") && 
                amount >= 500) { 
 
                    discount = amount * 0.15; 
 
            } else if (student.equalsIgnoreCase("Y")) { 
 
                    discount = amount * 0.10; 
 
            } else if (amount >= 500) { 
 
                    discount = amount * 0.05; 
 
            } 
 
            // Save the order that is valid 
            totalQuantity += quantity; 
            totalAmount += amount; 
            totalDiscount += discount; 
 
            System.out.printf("\nSubtotal: $%.2f%n", amount); 
            System.out.printf("Discount: $%.2f%n", discount); 
 
            System.out.printf( 
                "Order total: $%.2f%n", 
                amount - discount 
            ); 
 
            // Ask if the customer wants to order again 
            while (true) { 
 
                System.out.print( 
                    "\nDo you want to order again? (Y/N): " 
                ); 
 
                again = input.next(); 
 
                if (again.equalsIgnoreCase("Y") || 
                    again.equalsIgnoreCase("N")) { 
                    break; 
                } 
 
                System.out.println( 
                    "Please enter Y for Yes or N for No." 
                ); 
            } 
        } 
 
        // Show the final receipt 
        System.out.println("\n===== ORDER SUMMARY ====="); 
 
        System.out.println( 
            "Total items: " + totalQuantity 
        ); 
 
        System.out.printf( 
            "Total before discount: $%.2f%n", totalAmount 
        ); 
 
        System.out.printf( 
            "Total discount: $%.2f%n", totalDiscount 
        ); 
 
        System.out.printf( 
            "Final amount: $%.2f%n", 
            totalAmount - totalDiscount 
        ); 
 
        System.out.println("\nThank you for ordering!"); 
 
        input.close(); 
 
    } 
}