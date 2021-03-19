package by.robot.provider;

import by.robot.example.Robot;
import by.robot.order.Order;
import by.robot.product.Product;

import java.util.UUID;

public class Provider {

    private final String nameProvider;
    private final UUID idProvider;
    private Robot robot;

    public Provider(String nameProvider) {
        this.nameProvider = nameProvider;
        this.idProvider = UUID.randomUUID();
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public UUID getIdProvider() {
        return idProvider;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void createProducts() throws InterruptedException {
        if (!robot.getOrders().isEmpty()) {
            for (Order o : robot.getOrders()) {
                System.out.println("Заказ " + o.toString() +
                        " пользователя с id " + o.getClient().getIdClient() + " создан");

                Thread.sleep(1000);

                //кладет товар в склад
                robot.putProduct(new Product(o));
                Thread.sleep(1000);
            }
        } else System.out.println("Отсутствуют открытые заказы");
    }
}