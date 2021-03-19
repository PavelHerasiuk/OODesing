package by.robot.order;

import by.robot.client.Client;

import java.util.UUID;

public class Order {
    private final UUID id;
    private final Client client;
    private final String wish;   //желание, что хочу

    public Order(Client client, String wish) {
        this.client = client;
        this.wish = wish;
        this.id = UUID.randomUUID();
    }

    public String getWish() {
        return wish;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", wish='" + wish + '\'' +
                '}';
    }
}
