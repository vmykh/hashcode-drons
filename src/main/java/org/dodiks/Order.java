package org.dodiks;

import java.util.Map;

public class Order {
	private final int id;
	private final int x;
	private final int y;
	private final Map<Product, Long> requiredProducts;

	public Order(int id, int x, int y, Map<Product, Long> requiredProducts) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.requiredProducts = requiredProducts;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Map<Product, Long> getRequiredProducts() {
		return requiredProducts;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", x=" + x +
				", y=" + y +
				", requiredProducts=" + requiredProducts +
				'}';
	}
}
