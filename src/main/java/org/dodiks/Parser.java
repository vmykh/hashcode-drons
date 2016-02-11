package org.dodiks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sutula on 11.02.16
 */
public class Parser {

    private String filePath;
    private Settings settings;
    private List<Product> products;
    private List<Warehouse> warehouses;
    private List<Order> orders;

    public Parser(String filePath) {
        this.filePath = filePath;
    }

    public void perform() throws IOException {
        File inputFile = new File(filePath);
        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);

        String[] items = br.readLine().split(" ");

        settings = new Settings();
        settings.setRows(Integer.parseInt(items[0]));
        settings.setColumns(Integer.parseInt(items[1]));
        settings.setDrones(Integer.parseInt(items[2]));
        settings.setMaxTurns(Long.parseLong(items[3]));
        settings.setMaxPayload(Integer.parseInt(items[4]));

        items = br.readLine().split(" ");

        settings.setProductTypes(Integer.parseInt(items[0]));

        items = br.readLine().split(" ");

        products = new ArrayList<Product>();
        for (int i = 0; i < items.length; i++) {
            Product product = new Product(i, Integer.parseInt(items[i]));
            products.add(product);
//            System.out.println("Product: " + product);
        }

        items = br.readLine().split(" ");
        settings.setWarehouses(Integer.parseInt(items[0]));

        warehouses = new ArrayList<Warehouse>();
        for (int i = 0; i < settings.getWarehouses(); i++) {
            items = br.readLine().split(" ");
            int x = Integer.parseInt(items[0]);
            int y = Integer.parseInt(items[1]);
            items = br.readLine().split(" ");
            Map<Product, Long> productMap = new HashMap<Product, Long>();
            for (int j = 0; j < products.size(); j++) {
                productMap.put(products.get(j), Long.parseLong(items[j]));
            }
            Warehouse warehouse = new Warehouse(i, x, y, productMap);
            warehouses.add(warehouse);
//            System.out.println("Warehouse: " + warehouse);
        }

        items = br.readLine().split(" ");
        settings.setOrders(Integer.parseInt(items[0]));

        orders = new ArrayList<Order>();
        for (int i = 0; i < settings.getOrders(); i++) {
            items = br.readLine().split(" ");
            int x = Integer.parseInt(items[0]);
            int y = Integer.parseInt(items[1]);
            items = br.readLine().split(" ");
            int productsInOrderAmount = Integer.parseInt(items[0]);

            Map<Product, Long> productLongMap = new HashMap<Product, Long>();
            for (Product product : products) {
                productLongMap.put(product, 0L);
            }

            items = br.readLine().split(" ");
            for (int j = 0; j < productsInOrderAmount; j++) {
                int indexOfProduct = Integer.parseInt(items[j]);
                productLongMap.put(products.get(indexOfProduct), productLongMap.get(products.get(indexOfProduct)) + 1);
            }
            Order order = new Order(i, x, y, productLongMap);
            orders.add(order);
//            System.out.println("Order: " + order);
        }


//        System.out.println("Settings: " + settings);
    }

    public Settings getSettings() {
        return settings;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Parser{" +
                "filePath='" + filePath + '\'' +
                ", settings=" + settings +
                ", products=" + products +
                ", warehouses=" + warehouses +
                ", orders=" + orders +
                '}';
    }
}
