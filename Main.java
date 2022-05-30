package Atv3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Atv3.Entities.Client;
import Atv3.Entities.Order;
import Atv3.Entities.OrderItem;
import Atv3.Entities.OrderStatus;
import Atv3.Entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner imput = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("ENTER A CLIENT DATA:");
        System.out.print("Name: ");
        String name = imput.nextLine();
        System.out.print("Email: ");
        String email = imput.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(imput.next());

        Client client = new Client(name, email, birthDate);

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(imput.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("\nHow many items to this order?");
        int n = imput.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter #" + (i + 1) + " item data:");
            System.out.print("Product Name: ");
            imput.nextLine();
            String productName = imput.nextLine();
            System.out.print("Product Price: ");
            double price = imput.nextDouble();

            Product product = new Product(productName, price);

            System.out.print("Quantity: ");
            int quantity = imput.nextInt();

            OrderItem item = new OrderItem(quantity, price, product);

            order.addItem(item);
        }

        System.out.println("");
        System.out.println(order);

        imput.close();
    }
}