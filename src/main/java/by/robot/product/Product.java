package by.robot.product;

import by.robot.order.Order;

import java.util.Objects;
import java.util.UUID;

public class Product {

    private final String nameProduct;
    private final UUID idProduct;
    private final Order order;

    public Product(Order order) {
        this.order = order;
        this.nameProduct = order.getWish();
        this.idProduct = UUID.randomUUID();
    }

    public Order getOrder() {
        return order;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, idProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", idProduct=" + idProduct +
                ", order=" + order +
                '}';
    }
}