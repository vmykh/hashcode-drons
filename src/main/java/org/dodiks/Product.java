package org.dodiks;

public class Product {
	private final int type;
	private final int weight;

	public Product(int type, int weight) {
		this.type = type;
		this.weight = weight;
	}

	public int getType() {
		return type;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;

		Product product = (Product) o;

		if (type != product.type) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return type;
	}
}
