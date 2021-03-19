package by.robot.main;

import by.robot.WareHouse;
import by.robot.client.Client;
import by.robot.example.Robot;
import by.robot.product.Product;
import by.robot.provider.Provider;

/**
 * Робототизированное управление складом.
 * Робот должен уметь:
 * приносить товар клиенту
 * ложить товар на склад от постовщика.
 * Товары создаются под заказ при общании к роботу, если есть товар,
 * то приносит клиенту, если нет, то (сообщение надо подождать, пока провайдер привезет на склад.
 * Провайдер(поставщик товаров) привозит товары на склад, а робот их принимает.
 *
 * bringProducts возращает все продукты для конкретного клиента.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Provider provider = new Provider("Pavel");
        WareHouse wareHouse = new WareHouse();

        Robot robot = new Robot("Roy", wareHouse);

        Client client = new Client("Вася");

        //клиент создал заказ
        client.createOrder("Audi", robot);
        client.createOrder("BMW", robot);
        client.createOrder("Mersedes", robot);

        Client vladimir = new Client("Владимир");

        // клиент создал заказ
        vladimir.createOrder("1", robot);
        vladimir.createOrder("2", robot);
        vladimir.createOrder("3", robot);

        // связываем пользователя и клиента
        provider.setRobot(robot);

        // здесь происходит проверка на наличие открытых заказов
        provider.createProducts();

        System.out.println("Товары в хранилище");

        for (Product p : wareHouse.productList) {
            System.out.println(p);
        }
        System.out.println();
        /**
         *  Проверка на получение заказов из хранилища от робота по клиенту
         */
        for (Product p : robot.bringProduct(vladimir)) {
            System.out.println(p);
        }

        System.out.println();

        for (Product p : robot.bringProduct(client)) {
            System.out.println(p);
        }

        Client v = new Client("Влад");
        System.out.println(robot.bringProduct(v));
    }
}