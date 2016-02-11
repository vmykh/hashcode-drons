package org.dodiks;

public class Settings {
	private int rows;
	private int columns;
	private int drones;
	private long maxTurns;
	private int maxPayload;
	private int productTypes;
	private int warehouses;
	private int orders;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getDrones() {
		return drones;
	}

	public void setDrones(int drones) {
		this.drones = drones;
	}

	public long getMaxTurns() {
		return maxTurns;
	}

	public void setMaxTurns(long maxTurns) {
		this.maxTurns = maxTurns;
	}

	public int getMaxPayload() {
		return maxPayload;
	}

	public void setMaxPayload(int maxPayload) {
		this.maxPayload = maxPayload;
	}

	public int getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(int productTypes) {
		this.productTypes = productTypes;
	}

	public int getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(int warehouses) {
		this.warehouses = warehouses;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Settings{" +
				"rows=" + rows +
				", columns=" + columns +
				", drones=" + drones +
				", maxTurns=" + maxTurns +
				", maxPayload=" + maxPayload +
				", productTypes=" + productTypes +
				", warehouses=" + warehouses +
				", orders=" + orders +
				'}';
	}
}
