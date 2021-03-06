package Atv3.Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static void setSdf(SimpleDateFormat sdf) {
        Order.sdf = sdf;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total(){
        double sum = 0.0;
        for(OrderItem c : items){
            sum+=c.subTotal();

        }
        return sum;
    }

        public String toString(){
            
            StringBuilder sb = new StringBuilder();
            sb.append("ORDER SUMMARY:\n");
            sb.append("Order moment: "+sdf.format(moment)+"\n");
            sb.append("Order status: "+status+"\n");
            sb.append(client+"\n");
            for(OrderItem item : items){
                sb.append(item+"\n");
            }
            sb.append("Total Price: $ ");
            sb.append(String.format("%.2f", total()));

            return sb.toString();
        }

}
