package org.dodiks;

import org.dodiks.instruction.Instruction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Test {

	public static void main(String[] args) {
		Map<Product, Long> prodsInWarehouse = new HashMap<Product, Long>();
		prodsInWarehouse.put(new Product(1, 10), 20L);
		prodsInWarehouse.put(new Product(2, 25), 30L);

		Map<Product, Long> prodsInOrder = new HashMap<Product, Long>();
		prodsInOrder.put(new Product(1, 10), 5L);
		prodsInOrder.put(new Product(2, 25), 2L);

		Settings settings = new Settings();
		settings.setMaxPayload(30);

		SimpleAlgo algo = new SimpleAlgo(
				asList(new Warehouse(1, 5, 5, prodsInWarehouse)),
				asList(new Order(1, 100, 115, prodsInOrder)),
				settings
		);

		System.out.println("before run");

		List<Instruction> instructions = algo.run();
		for (Instruction instruction : instructions) {
			System.out.println(instruction.print());
		}

	}


}
