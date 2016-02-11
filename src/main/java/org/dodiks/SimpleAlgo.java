package org.dodiks;

import org.dodiks.instruction.Deliver;
import org.dodiks.instruction.Instruction;
import org.dodiks.instruction.Load;

import java.util.ArrayList;
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
		List<Instruction> instructions = new ArrayList<Instruction>();

		outer_loop:
		while (orders.size() > 0) {
			Order currentOrder = orders.get(0);
			Map<Product, Long> requiredProducts = currentOrder.getRequiredProducts();
			int currentDronPayload = 0;
			for (Product product : requiredProducts.keySet()) {
				long curProductRequired = requiredProducts.get(product);
				checkState(curProductRequired > 0);
				for (Warehouse warehouse : warehouses) {
					long available = warehouse.getProductsAvailable(product);
					if (available == 0) {
						continue;
					}
					int loaded = (int) maxPossibleLoading(product, curProductRequired, available, settings.getMaxPayload());
					warehouse.decrease(product, loaded);
					long neededAfterDelivery = curProductRequired - loaded;
					if (neededAfterDelivery == 0) {
						requiredProducts.remove(product);
						if (requiredProducts.size() == 0) {
							orders.remove(0);
						}
					} else {
						requiredProducts.put(product, neededAfterDelivery);
					}
					instructions.add(new Load(dronId, warehouse.getId(), product.getType(), loaded));
					instructions.add(new Deliver(dronId, currentOrder.getId(), product.getType(), loaded));

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
}
