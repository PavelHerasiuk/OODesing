package by.robot.client;

import by.robot.example.Robot;
import by.robot.order.Order;

import java.util.UUID;

public class Client implements ActionsClient {
    private String nameClient;
    private UUID idClient;

    public Client(String nameClient) {
        this.nameClient = nameClient;
        this.idClient = UUID.randomUUID();
    }

    public String getNameClient() {
        return nameClient;
    }

    public UUID getIdClient() {
        return idClient;
    }

    @Override
    public void createOrder(String wish, Robot robot) {
        if (wish.length() > 0) {
            //создается заказ и кладется в список  заказов к роботу
            robot.addOrder(new Order(this, wish));
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "nameClient='" + nameClient + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}