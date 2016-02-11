package org.dodiks.instruction;

import static java.lang.String.format;

public class Load implements Instruction {
	private final int dronId;
	private final int warehouseId;
	private final int productType;
	private final int productsAmouns;
	private final int turns;


	public Load(int dronId, int warehouseId, int productType, int productsAmouns, int turns) {
		this.dronId = dronId;
		this.warehouseId = warehouseId;
		this.productType = productType;
		this.productsAmouns = productsAmouns;
		this.turns = turns;
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
	public int getTurns() {
		return turns;
	}

	@Override
	public String print() {
		return format("%d L %d %d %d", dronId, warehouseId, productType, productsAmouns);
	}
}
