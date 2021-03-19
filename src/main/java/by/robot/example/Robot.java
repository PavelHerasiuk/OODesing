package by.robot.example;

import by.robot.WareHouse;
import by.robot.client.Client;
import by.robot.order.Order;
import by.robot.product.Product;
import by.robot.service.Responsibilities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Robot implements Responsibilities {

    private final String nameRobot;
    private final UUID idRobot;
    private final WareHouse warehouse;
    private List<Order> orders = new ArrayList<>();

    public Robot(String nameRobot, WareHouse wareHouse) {
        this.nameRobot = nameRobot;
        this.idRobot = UUID.randomUUID();
        this.warehouse = wareHouse;
    }

    public String getNameRobot() {
        return nameRobot;
    }

    public List<Order> getOrders() {
        return orders;
    }

//    @Override
//    public boolean searchProduct(Order order) {
//        return Warehouse.productList.stream().anyMatch(s -> s.getIdProduct() == id);
//    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public List<Product> bringProduct(Client client) {

        List<Product> findProducts = warehouse.productList
                .stream()
                .filter(product -> product.getOrder().getClient().equals(client))
                .collect(Collectors.toList());

        if (findProducts.isEmpty()) {
            System.out.println("На ваше имя нет товаров " + client.toString());
        }

        return findProducts;
    }

    @Override
    public boolean putProduct(Product product) {
        int initial = warehouse.productList.size();
        warehouse.productList.add(product);
        if (initial == warehouse.productList.size()) {
            System.out.println("Такой товар уже существует");
            return false;
        }
        System.out.println("Товар добавлен в хранилище(склад)");
        return true;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "nameRobot='" + nameRobot + '\'' +
                ", idRobot=" + idRobot +
                ", warehouse=" + warehouse +
                ", orders=" + orders +
                '}';
    }
}