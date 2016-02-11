package org.dodiks.instruction;

import static java.lang.String.format;

public class Load implements Instruction {
	private final int dronId;
	private final int warehouseId;
	private final int productType;
	private final int productsAmouns;

	public Load(int dronId, int warehouseId, int productType, int productsAmouns) {
		this.dronId = dronId;
		this.warehouseId = warehouseId;
		this.productType = productType;
		this.productsAmouns = productsAmouns;
	}

	public int getDronId() {
		return dronId;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public int getProductType() {
		return productType;
	}

	public int getProductsAmouns() {
		return productsAmouns;
	}

	@Override
	public String print() {
		return format("%d L %d %d %d", dronId, warehouseId, productType, productsAmouns);
	}
}
