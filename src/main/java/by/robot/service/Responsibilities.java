package by.robot.service;

import by.robot.client.Client;
import by.robot.product.Product;

import java.util.List;

public interface Responsibilities {

    //    boolean searchProduct(Order order);  // искать товар

    List<Product> bringProduct(Client client) throws Exception; // приносить товар(для работы с клиентом)

    boolean putProduct(Product product) throws Exception; //заносить товар на склад (для работы с провайдером)

}
