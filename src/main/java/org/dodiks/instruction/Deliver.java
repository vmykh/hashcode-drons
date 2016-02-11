package org.dodiks.instruction;

import static java.lang.String.format;

public class Deliver implements Instruction {
	private final int dronId;
	private final int orderId;
	private final int productType;
	private final int productsAmount;

	public Deliver(int dronId, int orderId, int productType, int productsAmount) {
		this.dronId = dronId;
		this.orderId = orderId;
		this.productType = productType;
		this.productsAmount = productsAmount;
	}

	public int getDronId() {
		return dronId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getProductType() {
		return productType;
	}

	public int getProductsAmount() {
		return productsAmount;
	}

	@Override
	public String print() {
		return format("%d D %d %d %d", dronId, orderId, productType, productsAmount);
	}
}
