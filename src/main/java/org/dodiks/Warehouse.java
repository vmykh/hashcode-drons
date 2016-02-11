package org.dodiks;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

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

	public long getProductsAvailable(Product product) {
		return products.containsKey(product) ? checkNotNull(products.get(product)) : 0;
	}

	public void decrease(Product product, long amount) {
		long available = getProductsAvailable(product);
		checkState(available >= amount);
		products.put(product, available - amount);
	}

	@Override
	public String toString() {
		return "Warehouse{" +
				"id=" + id +
				", x=" + x +
				", y=" + y +
				", products=" + products +
				'}';
	}
}
