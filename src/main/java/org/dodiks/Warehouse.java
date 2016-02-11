package org.dodiks;

import java.util.Map;

public class Warehouse {
	private final int id;
	private final int x;
	private final int y;
	private final Map<Product, Long> products;

	public Warehouse(int id, int x, int y, Map<Product, Long> products) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.products = products;
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

	public Map<Product, Long> getProducts() {
		return products;
	}
}
