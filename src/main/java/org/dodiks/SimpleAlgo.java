package org.dodiks;

import org.dodiks.instruction.Deliver;
import org.dodiks.instruction.Instruction;
import org.dodiks.instruction.Load;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

public class SimpleAlgo {
	private final List<Warehouse> warehouses;
	private final List<Order> orders;
	private final Settings settings;

	public SimpleAlgo(List<Warehouse> warehouses, List<Order> orders, Settings settings) {
		this.warehouses = new ArrayList<Warehouse>(warehouses);
		this.orders = new ArrayList<Order>(orders);
		this.settings = settings;
	}

	public List<Instruction> run() {
		int dronId = 0;

		List<Drone> drones = new ArrayList<Drone>();
		int dronX = warehouses.get(0).getX();
		int dronY = warehouses.get(0).getY();
		for (int i = 0; i < settings.getDrones(); i++) {
			drones.add(new Drone(dronX, dronY));
		}

		List<Instruction> instructions = new ArrayList<Instruction>();



		int currentDronIndex = 0;

		outer_loop:
		while (orders.size() > 0) {
			System.out.println("Orders left: " + orders.size());
			Order currentOrder = orders.get(0);
			Map<Product, Long> requiredProducts = currentOrder.getRequiredProducts();
			filterProducts(requiredProducts);
			if (requiredProducts.size() == 0) {
				orders.remove(0);
				continue;
			}
			int currentDronPayload = 0;
			for (Product product : requiredProducts.keySet()) {
				long curProductRequired = requiredProducts.get(product);
//				checkState(curProductRequired > 0);
				if (curProductRequired == 0) {
					continue;
				}
				for (Warehouse warehouse : warehouses) {
					long available = warehouse.getProductsAvailable(product);
					if (available == 0) {
						continue;
					}
					int loaded = (int) maxPossibleLoading(product, curProductRequired, available, settings.getMaxPayload());
					warehouse.decrease(product, loaded);
					long neededAfterDelivery = curProductRequired - loaded;
//					if (neededAfterDelivery == 0) {
//						requiredProducts.remove(product);
//						if (requiredProducts.size() == 0) {
//							orders.remove(0);
//						}
//					} else {
//						requiredProducts.put(product, neededAfterDelivery);
//					}
					requiredProducts.put(product, neededAfterDelivery);

					instructions.add(new Load(currentDronIndex, warehouse.getId(), product.getType(), loaded, 0));
					instructions.add(new Deliver(currentDronIndex, currentOrder.getId(), product.getType(), loaded, 0));

					currentDronIndex = (currentDronIndex + 1) % settings.getDrones();

					continue outer_loop;
				}
			}

		}
		return instructions;
	}

	private int maxPossibleLoading(Product product, long needed, long available, int maxPayload) {
		long loaded = available > needed ? needed : available;
		long totalWeight = loaded * product.getWeight();
		while (totalWeight > maxPayload) {
			totalWeight -= product.getWeight();
			loaded--;
		}
		return (int) loaded;
	}

	private void filterProducts(Map<Product, Long> products) {
//		for (Product product : products.keySet()) {
//			if (products.get(product) == 0L) {
//				products.remove(product);
//			}
//		}
		Iterator<Map.Entry<Product, Long>> iter = products.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Product, Long> entry = iter.next();
			if(entry.getValue() == 0L){
				iter.remove();
			}
		}
	}
}
